import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators' 

@Component({
  selector: 'app-editar-estatus-usuario',
  templateUrl: './editar-estatus-usuario.component.html',
  styleUrls: ['./editar-estatus-usuario.component.css']
})
export class EditarEstatusUsuarioComponent implements OnInit{
  public estatusUsuario:any = {};
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient) { }
  ngOnInit(): void { 
   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
    this.usuarioMomentaneo= this.temporal.usuario;
    this.estatusUsuario=JSON.parse(localStorage.getItem("editar")||'{}');
   }

   editarEstatusUsuario(){
    let formularioValido:any = document.getElementById("editarEstatusUsuario");
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
        location.href="/status_usuario";
    }
 
    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'
      } 
     
      this.estatusUsuario.usuarioModificacion = this.usuarioMomentaneo.idUsuario;
      return this.http.post<any>('http://localhost:6500/miapp/status-usuario/editar',this.estatusUsuario,httpOptions).pipe(
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
        location.href="/status_usuario";
      }

}
