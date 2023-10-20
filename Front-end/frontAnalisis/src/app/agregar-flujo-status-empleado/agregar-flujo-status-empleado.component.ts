import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators'
import { Observable } from 'rxjs'; 

@Component({
  selector: 'app-agregar-flujo-status-empleado',
  templateUrl: './agregar-flujo-status-empleado.component.html',
  styleUrls: ['./agregar-flujo-status-empleado.component.css']
})
export class AgregarFlujoStatusEmpleadoComponent implements OnInit{
  public flujoEmpleado:any = {};
  public empleados:any = [];
  public buscarStatusUsuario:any = [];
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient) { }
  ngOnInit(): void {
   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
   this.usuarioMomentaneo= this.temporal.usuario;
   this.buscarEmpleados();
  }

  agregarFlujoEmpleado(){
    let formularioValido:any = document.getElementById("agregarFlujoEmpleado");
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
     
      this.flujoEmpleado.usuarioCreacion = this.usuarioMomentaneo.idUsuario;
      
      return this.http.post<any>('http://localhost:6500/miapp/flujoStatusEmpleado/guardar',this.flujoEmpleado,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
        }))
      }

      cancelar(){
        location.href="/flujo_status_empleado";
      }

      buscarEmpleados(){

        this.buscarEmpleadosServicio().subscribe(
          (response:any)=> this.empleados=response


        )

      }

      buscarEmpleadosServicio():Observable<any>{
        return this.http.get<any>('http://localhost:6500/miapp/empleado/buscar').pipe(
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
