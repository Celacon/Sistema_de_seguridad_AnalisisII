import { Component , OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators'
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";


@Component({
  selector: 'app-agregar-modulo',
  templateUrl: './agregar-modulo.component.html',
  styleUrls: ['./agregar-modulo.component.css']
})
export class AgregarModuloComponent implements OnInit{
  public modulo:any = {};
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient
    , private router: Router, 
    private url:AppComponent) { }

  ngOnInit(): void {



   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');

   this.usuarioMomentaneo= this.temporal.usuario;
  }


  agregarModulo(){
    let formularioValido:any = document.getElementById("agregarModulo");

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

       // location.href="/modulo";
       this.router.navigateByUrl("/modulo")


    }



    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'

      }

      this.modulo.usuarioCreacion = this.usuarioMomentaneo.idUsuario;

      return this.http.post<any>(this.url.url+'miapp/modulo/guardar',this.modulo,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
        }))
      }

      cancelar(){
        //location.href="/modulo";
        this.router.navigateByUrl("/modulo")
      }

}
