import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators' 


@Component({
  selector: 'app-editar-estatus-empleado',
  templateUrl: './editar-estatus-empleado.component.html',
  styleUrls: ['./editar-estatus-empleado.component.css']
})
export class EditarEstatusEmpleadoComponent implements OnInit{
  public estatusEmpleado:any = {};
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient) { }
  ngOnInit(): void { 
   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
    this.usuarioMomentaneo= this.temporal.usuario;
    this.estatusEmpleado=JSON.parse(localStorage.getItem("editar")||'{}');
   }

   editarEstatusEmpleado(){
    let formularioValido:any = document.getElementById("editarEstatusEmpleado");
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
        location.href="/status_empleado";
    }
 
    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'
      } 
     
      this.estatusEmpleado.usuarioModificacion = this.usuarioMomentaneo.idUsuario;
      return this.http.post<any>('http://localhost:6500/miapp/statusEmpleado/editar',this.estatusEmpleado,httpOptions).pipe(
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
        location.href="/status_empleado";
      }

}
