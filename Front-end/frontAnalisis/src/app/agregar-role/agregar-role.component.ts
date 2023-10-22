import { Component , OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators'
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-agregar-role',
  templateUrl: './agregar-role.component.html',
  styleUrls: ['./agregar-role.component.css']
})
export class AgregarRoleComponent implements OnInit{
  public role:any = {};
  public usuarioMomentaneo:any = {};
  temporal:any ={};
  
  constructor(private http: HttpClient
    , private router: Router, 
    private url:AppComponent) { }

  ngOnInit(): void {



   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');

   this.usuarioMomentaneo= this.temporal.usuario;
  }


  agregarRole(){
    let formularioValido:any = document.getElementById("agregarRole");

    if(formularioValido.reportValidity()){
      this.servicioLogin().subscribe(
        (response: any)=>  this.respuesta(response)
      )

    }

  }

  respuesta(res: any){

      let json = JSON.parse(res);

      console.log(json);

      alert(json.mensaje);

        //location.href="/role";
        this.router.navigateByUrl("/role")



    }



    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'

      }

      this.role.usuarioCreacion = this.usuarioMomentaneo.idUsuario;

      return this.http.post<any>(this.url.url+'miapp/role/guardar',this.role,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
        }))
      }

      cancelar(){
        this.router.navigateByUrl("/role")
      }


}
