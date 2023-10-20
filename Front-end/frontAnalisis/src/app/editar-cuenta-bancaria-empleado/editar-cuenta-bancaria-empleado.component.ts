import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators'
import { Observable } from 'rxjs';

@Component({
  selector: 'app-editar-cuenta-bancaria-empleado',
  templateUrl: './editar-cuenta-bancaria-empleado.component.html',
  styleUrls: ['./editar-cuenta-bancaria-empleado.component.css']
})
export class EditarCuentaBancariaEmpleadoComponent implements OnInit{
  public cuentaEmpleado:any = {};
  public empleado:any = [];
  public banco:any = [];
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient) { }
  ngOnInit(): void {
  this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
  this.usuarioMomentaneo= this.temporal.usuario;
  this.cuentaEmpleado=JSON.parse(localStorage.getItem("editar")||'{}');
  this.buscarEmpleado();
  this.buscarBanco();
   }

   editarCuenta(){
    let formularioValido:any = document.getElementById("editarCuenta");
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
      location.href="/cuenta_bancaria_empleado";
    }

    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'
      }

      this.cuentaEmpleado.usuarioModificacion = this.usuarioMomentaneo.idUsuario;
      return this.http.post<any>('http://localhost:6500/miapp/cuentaBancariaEmpleado/editar',this.cuentaEmpleado,httpOptions).pipe(
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
        location.href="/cuenta_bancaria_empleado";
      }

      buscarEmpleado(){
        this.buscarEmpleadoServicio().subscribe(
        (response:any)=> this.empleado=response
        )
      }

      buscarEmpleadoServicio():Observable<any>{
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

      buscarBanco(){
        this.buscarBancoServicio().subscribe(
          (response:any)=> this.banco=response
        )
      }

      buscarBancoServicio():Observable<any>{
        return this.http.get<any>('http://localhost:6500/miapp/banco/buscar').pipe(
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