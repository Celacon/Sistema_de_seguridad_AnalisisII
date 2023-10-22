import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators' 
import { Observable } from 'rxjs'; 
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-editar-flujo-status-empleado',
  templateUrl: './editar-flujo-status-empleado.component.html',
  styleUrls: ['./editar-flujo-status-empleado.component.css']
})
export class EditarFlujoStatusEmpleadoComponent implements OnInit{
  public flujoEstatusEmpleado:any = {};
  public flujoEmpleado2:any = {};
  public estatus:any = [];
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient
    , private router: Router, 
    private url:AppComponent) { }

  ngOnInit(): void { 
   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
    this.usuarioMomentaneo= this.temporal.usuario;
    this.flujoEstatusEmpleado=JSON.parse(localStorage.getItem("editar")||'{}');
    this.buscarStatus();
   }

   editarFlujoStatusEmpleado(){
    let formularioValido:any = document.getElementById("editarFlujoStatusEmpleado");
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
       // location.href="/flujo_status_empleado";
       this.router.navigateByUrl("/flujo_status_empleado")
    }
 
    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'
      } 
     
      this.flujoEstatusEmpleado.usuarioModificacion = this.usuarioMomentaneo.idUsuario;
      return this.http.post<any>(this.url.url+'miapp/flujoStatusEmpleado/editar',this.flujoEstatusEmpleado,httpOptions).pipe(
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
        //location.href="/flujo_status_empleado";
        this.router.navigateByUrl("/flujo_status_empleado")
      }

      buscarStatus(){
        this.buscarStatusServicio().subscribe(
          (response:any)=> this.estatus=response
        )
      }

      buscarStatusServicio():Observable<any>{
        return this.http.get<any>(this.url.url+'miapp/statusEmpleado/buscar').pipe(
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
