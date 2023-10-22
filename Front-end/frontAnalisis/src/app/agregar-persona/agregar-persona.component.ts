import { Component , OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators'
import { Observable } from 'rxjs';
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-agregar-persona',
  templateUrl: './agregar-persona.component.html',
  styleUrls: ['./agregar-persona.component.css']
})
export class AgregarPersonaComponent implements OnInit {
  public persona:any = {};
    public genero:any = [];
    public estadocivil:any = [];
    public usuarioMomentaneo:any = {};
    temporal:any ={};

    constructor(private http: HttpClient
      , private router: Router, 
      private url:AppComponent) { }

    ngOnInit(): void {



     this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');

     this.usuarioMomentaneo= this.temporal.usuario;

     this.buscarGenero();
     this.buscarEstadoCivil();



    }


    agregarPersona(){
      let formularioValido:any = document.getElementById("agregarPersona");

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

         // location.href="/personas";
         this.router.navigateByUrl("/personas")


      }



      servicioLogin(){
        let httpOptions ={
          Headers: new HttpHeaders({
            'Accept':'txt/html'
          }),responseType:'text' as 'json'

        }

        this.persona.usuarioCreacion = this.usuarioMomentaneo.idUsuario;

        return this.http.post<any>(this.url.url+'miapp/persona/guardar',this.persona,httpOptions).pipe(
          catchError((error) => {
            console.log(error);
            const mensaje =error.error;
            const objetoJSON = JSON.parse(mensaje);
            alert(objetoJSON.mensaje);
            throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
          }))
        }

        cancelar(){
          //location.href="/personas";
          this.router.navigateByUrl("/personas")
        }

        buscarGenero(){

          this.buscarGeneroServicio().subscribe(
            (response:any)=> this.genero=response


          )

        }

        buscarGeneroServicio():Observable<any>{
          return this.http.get<any>(this.url.url+'miapp/genero/buscar').pipe(
            catchError((error) => {
              console.log(error);
              const mensaje =error.error;
              const objetoJSON = JSON.parse(mensaje);
              alert(objetoJSON.mensaje);
              throw error;
              })
          )
        }

        buscarEstadoCivil(){

          this.buscarEstadoCivilServicio().subscribe(
            (response:any)=> this.estadocivil=response


          )

        }

        buscarEstadoCivilServicio():Observable<any>{
          return this.http.get<any>(this.url.url+'miapp/estadoCivil/buscar').pipe(
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
