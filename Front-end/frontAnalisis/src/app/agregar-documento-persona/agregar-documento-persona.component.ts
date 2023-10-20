import { Component , OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators'
import { Observable } from 'rxjs';

@Component({
  selector: 'app-agregar-documento-persona',
  templateUrl: './agregar-documento-persona.component.html',
  styleUrls: ['./agregar-documento-persona.component.css']
})
export class AgregarDocumentoPersonaComponent implements OnInit {
  public documentopersona:any = {id: { idTipoDocumento: null, idPersona: null }};
  public tipoDocumento:any = [];
  public persona:any = [];
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient) { }
  ngOnInit(): void {



   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');

   this.usuarioMomentaneo= this.temporal.usuario;

   this.buscarTipoDocumento();
   this.buscarPersona();

  }


  agregarDocumentoPersona(){
    let formularioValido:any = document.getElementById("agregarDocumentoPersona");

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

        location.href="/documento_persona";



    }



    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'

      }

      this.documentopersona.usuarioCreacion = this.usuarioMomentaneo.idUsuario;

      return this.http.post<any>('http://localhost:6500/miapp/documento-persona/guardar',this.documentopersona,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
        }))
      }

      cancelar(){
        location.href="/documento_persona";
      }

      buscarTipoDocumento(){

        this.buscarTipoDocumentoServicio().subscribe(
          (response:any)=> this.tipoDocumento=response


        )

      }

      buscarTipoDocumentoServicio():Observable<any>{
        return this.http.get<any>('http://localhost:6500/miapp/tipoDocumento/buscar').pipe(
          catchError((error) => {
            console.log(error);
            const mensaje =error.error;
            const objetoJSON = JSON.parse(mensaje);
            alert(objetoJSON.mensaje);
            throw error;
            })
        )
      }

      buscarPersona(){

        this.buscarPersonaServicio().subscribe(
          (response:any)=> this.persona=response


        )

      }

      buscarPersonaServicio():Observable<any>{
        return this.http.get<any>('http://localhost:6500/miapp/persona/buscar').pipe(
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
