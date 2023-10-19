import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators' 

@Component({
  selector: 'app-agregar-estatus-empleado',
  templateUrl: './agregar-estatus-empleado.component.html',
  styleUrls: ['./agregar-estatus-empleado.component.css']
})
export class AgregarEstatusEmpleadoComponent implements OnInit{
  public statusEmpleado:any = {};
  public buscarStatusUsuario:any = [];
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient) { }
  ngOnInit(): void {
   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
   this.usuarioMomentaneo= this.temporal.usuario;
   //this.buscarStatus();
  }

  agregarStatusEmpleado(){
    let formularioValido:any = document.getElementById("agregarStatusEmpleado");
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
     
      this.statusEmpleado.usuarioCreacion = this.usuarioMomentaneo.idUsuario;
      
      return this.http.post<any>('http://localhost:6500/miapp/statusEmpleado/guardar',this.statusEmpleado,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
        }))
      }

      cancelar(){
        location.href="/status_empleado";
      }

}
