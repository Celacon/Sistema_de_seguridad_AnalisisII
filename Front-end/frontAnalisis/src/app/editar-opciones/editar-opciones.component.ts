import { Component , OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators'
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-editar-opciones',
  templateUrl: './editar-opciones.component.html',
  styleUrls: ['./editar-opciones.component.css']
})
export class EditarOpcionesComponent implements OnInit{
  public opcion:any = {};
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient
    , private router: Router, 
    private url:AppComponent) { }

  ngOnInit(): void {
   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
    this.usuarioMomentaneo= this.temporal.usuario;
    this.opcion=JSON.parse(localStorage.getItem("editar")||'{}');

   }


   editarOpcion(){
    let formularioValido:any = document.getElementById("editarOpcion");

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

        //location.href="/opcion";
        this.router.navigateByUrl("/opcion")


    }



    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'

      }

      this.opcion.usuarioModificacion = this.usuarioMomentaneo.idUsuario;

      return this.http.post<any>(this.url.url+'miapp/opcion/editar',this.opcion,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
        }))
      }

      cancelar(){
        localStorage.removeItem("editar")
        //location.href="/opcion";
        this.router.navigateByUrl("/opcion")
      }


}
