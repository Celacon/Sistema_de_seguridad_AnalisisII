import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators' 
import { Observable } from 'rxjs';
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-agregar-estatus-usuario',
  templateUrl: './agregar-estatus-usuario.component.html',
  styleUrls: ['./agregar-estatus-usuario.component.css']
})
export class AgregarEstatusUsuarioComponent implements OnInit{
  public statusUsuario:any = {};
  public buscarStatusUsuario:any = [];
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient
    , private router: Router, 
    private url:AppComponent) { }

  ngOnInit(): void {
   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
   this.usuarioMomentaneo= this.temporal.usuario;
   //this.buscarStatus();
  }

  agregarStatusUsuario(){
    let formularioValido:any = document.getElementById("agregarStatusUsuario");
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
        //location.href="/status_usuario";
        this.router.navigateByUrl("/status_usuario")
    }
 
    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'
      } 
     
      this.statusUsuario.usuarioCreacion = this.usuarioMomentaneo.idUsuario;
      
      return this.http.post<any>(this.url.url+'miapp/status-usuario/guardar',this.statusUsuario,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
        }))
      }

      cancelar(){
        //location.href="/status_usuario";
        this.router.navigateByUrl("/status_usuario")
      }
/*
      buscarStatus(){
        this.buscarStatusServicio().subscribe(
          (response:any)=> this.buscarStatusUsuario=response
        )
      }
    
      buscarStatusServicio():Observable<any>{
        return this.http.get<any>('http://localhost:6500/miapp/status-usuario/buscar').pipe(
          catchError((error) => {
            console.log(error);
            const mensaje =error.error;
            const objetoJSON = JSON.parse(mensaje);
            alert(objetoJSON.mensaje);
            throw error; 
            })
        )
      }
*/

}
