import { Component , OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators'



@Component({
  selector: 'app-agregar-tipo-documento',
  templateUrl: './agregar-tipo-documento.component.html',
  styleUrls: ['./agregar-tipo-documento.component.css']
})
export class AgregarTipoDocumentoComponent implements OnInit {
  public tipoDocumento:any = {};
    public usuarioMomentaneo:any = {};
    temporal:any ={};

    constructor(private http: HttpClient) { }
    ngOnInit(): void {



     this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');

     this.usuarioMomentaneo= this.temporal.usuario;


    }


    agregarTipoDocumento(){
      let formularioValido:any = document.getElementById("agregarTipoDocumento");

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

          location.href="/tipos_documento";



      }



      servicioLogin(){
        let httpOptions ={
          Headers: new HttpHeaders({
            'Accept':'txt/html'
          }),responseType:'text' as 'json'

        }

        this.tipoDocumento.usuarioCreacion = this.usuarioMomentaneo.idUsuario;

        return this.http.post<any>('http://localhost:6500/miapp/tipoDocumento/guardar',this.tipoDocumento,httpOptions).pipe(
          catchError((error) => {
            console.log(error);
            const mensaje =error.error;
            const objetoJSON = JSON.parse(mensaje);
            alert(objetoJSON.mensaje);
            throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
          }))
        }

        cancelar(){
          location.href="/tipos_documento";
        }



}
