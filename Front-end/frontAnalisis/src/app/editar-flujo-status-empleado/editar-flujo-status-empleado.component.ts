import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators' 

@Component({
  selector: 'app-editar-flujo-status-empleado',
  templateUrl: './editar-flujo-status-empleado.component.html',
  styleUrls: ['./editar-flujo-status-empleado.component.css']
})
export class EditarFlujoStatusEmpleadoComponent implements OnInit{
  public flujoEstatusEmpleado:any = {};
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient) { }
  ngOnInit(): void { 
   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
    this.usuarioMomentaneo= this.temporal.usuario;
    this.flujoEstatusEmpleado=JSON.parse(localStorage.getItem("editar")||'{}');
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
        location.href="/flujo_status_empleado";
    }
 
    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'
      } 
     
      this.flujoEstatusEmpleado.usuarioModificacion = this.usuarioMomentaneo.idUsuario;
      return this.http.post<any>('http://localhost:6500/miapp/flujoStatusEmpleado/editar',this.flujoEstatusEmpleado,httpOptions).pipe(
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
        location.href="/flujo_status_empleado";
      }

}
