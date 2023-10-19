import { Component , OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators'
import { Observable } from 'rxjs';

@Component({
  selector: 'app-editar-empleado',
  templateUrl: './editar-empleado.component.html',
  styleUrls: ['./editar-empleado.component.css']
})
export class EditarEmpleadoComponent implements OnInit {
  public empleado:any = {};

  public persona:any = [];
  public sucursal:any = [];
  public puesto:any = [];
  public statusempleado:any = [];
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient) { }
  ngOnInit(): void {
   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
    this.usuarioMomentaneo= this.temporal.usuario;
    this.empleado=JSON.parse(localStorage.getItem("editar")||'{}');


    this.buscarPersona();
    this.buscarSucursal();
    this.buscarPuesto();
    this.buscarStatusEmpleado();


   }


   editarEmpleado(){
    let formularioValido:any = document.getElementById("editarEmpleado");

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

        location.href="/empleado";



    }



    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'

      }

      this.empleado.usuarioModificacion = this.usuarioMomentaneo.idUsuario;

      return this.http.post<any>('http://localhost:6500/miapp/empleado/editar',this.empleado,httpOptions).pipe(
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
        location.href="/empleado";
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
      buscarSucursal(){

        this.buscarSucursalServicio().subscribe(
          (response:any)=> this.sucursal=response


        )

      }

      buscarSucursalServicio():Observable<any>{
        return this.http.get<any>('http://localhost:6500/miapp/sucursal/buscar').pipe(
          catchError((error) => {
            console.log(error);
            const mensaje =error.error;
            const objetoJSON = JSON.parse(mensaje);
            alert(objetoJSON.mensaje);
            throw error;
            })
        )
      }

      buscarPuesto(){

        this.buscarPuestoServicio().subscribe(
          (response:any)=> this.puesto=response


        )

      }

      buscarPuestoServicio():Observable<any>{
        return this.http.get<any>('http://localhost:6500/miapp/puesto/buscar').pipe(
          catchError((error) => {
            console.log(error);
            const mensaje =error.error;
            const objetoJSON = JSON.parse(mensaje);
            alert(objetoJSON.mensaje);
            throw error;
            })
        )
      }

      buscarStatusEmpleado(){

        this.buscarStatusEmpleadoServicio().subscribe(
          (response:any)=> this.statusempleado=response


        )

      }

      buscarStatusEmpleadoServicio():Observable<any>{
        return this.http.get<any>('http://localhost:6500/miapp/statusEmpleado/buscar').pipe(
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
