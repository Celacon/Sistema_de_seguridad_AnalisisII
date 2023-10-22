import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators'
import { Observable } from 'rxjs';
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-agregar-opciones',
  templateUrl: './agregar-opciones.component.html',
  styleUrls: ['./agregar-opciones.component.css']
})
export class AgregarOpcionesComponent implements OnInit{
  public opcion:any = {};
  public menu:any = [];
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient
    , private router: Router, 
    private url:AppComponent) { }
  ngOnInit(): void {



   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');

   this.usuarioMomentaneo= this.temporal.usuario;

   this.buscarMenu();
  }


  agregarOpcion(){
    let formularioValido:any = document.getElementById("agregarOpcion");

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

       // location.href="/opcion";
       this.router.navigateByUrl("/opcion")


    }



    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'

      }

      this.opcion.usuarioCreacion = this.usuarioMomentaneo.idUsuario;

      return this.http.post<any>(this.url.url+'miapp/opcion/guardar',this.opcion,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
        }))
      }

      cancelar(){
        //location.href="/opcion";
        this.router.navigateByUrl("/opcion")
      }

      buscarMenu(){

        this.buscarMenuServicio().subscribe(
          (response:any)=> this.menu=response


        )

      }

      buscarMenuServicio():Observable<any>{
        return this.http.get<any>(this.url.url+'miapp/menu/buscar').pipe(
          catchError((error) => {
            console.log(error);
            const mensaje =error.error;
            const objetoJSON = JSON.parse(mensaje);
            alert(objetoJSON.mensaje);
            throw error;
            })
        )
      }

}
