import { Component , OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators'
import { Observable } from 'rxjs';
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-agregar-empleado',
  templateUrl: './agregar-empleado.component.html',
  styleUrls: ['./agregar-empleado.component.css']
})
export class AgregarEmpleadoComponent implements OnInit {
  public empleado:any = {};
    public empleados:any = [];
    public persona:any = [];

    public sucursal:any = [];
    public puesto:any = [];
    public statusempleado:any = [];
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient
    , private router: Router, 
    private url:AppComponent) { }

  ngOnInit(): void {



   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');

   this.usuarioMomentaneo= this.temporal.usuario;

   this.buscarEmpleados();
   this.buscarPersona();
   this.buscarSucursal();
   this.buscarPuesto();
   this.buscarStatusEmpleado();


  }


  agregarEmpleado(){
    let formularioValido:any = document.getElementById("agregarEmpleado");

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

        //location.href="/empleado";
        this.router.navigateByUrl("/empleado")


    }



    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'

      }

      this.empleado.usuarioCreacion = this.usuarioMomentaneo.idUsuario;

      return this.http.post<any>(this.url.url+'miapp/empleado/guardar',this.empleado,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
        }))
      }

      cancelar(){
       // location.href="/empleado";
        this.router.navigateByUrl("/empleado")
      }

      buscarEmpleados(){

        this.buscarEmpleadosServicio().subscribe(
          (response:any)=> this.empleados=response


        )

      }

      buscarEmpleadosServicio():Observable<any>{
        return this.http.get<any>(this.url.url+'miapp/empleado/buscar').pipe(
          catchError((error) => {
            console.log(error);
            const mensaje =error.error;
            const objetoJSON = JSON.parse(mensaje);
            alert(objetoJSON.mensaje);
            throw error;
            })
        )
      }




       buscarPersona(){

        this.buscarPersonaServicio().subscribe(
          (response:any)=> this.persona=response


        )

      }

      buscarPersonaServicio():Observable<any>{
        return this.http.get<any>(this.url.url+'miapp/persona/buscar').pipe(
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
        return this.http.get<any>(this.url.url+'miapp/sucursal/buscar').pipe(
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
        return this.http.get<any>(this.url.url+'miapp/puesto/buscar').pipe(
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
