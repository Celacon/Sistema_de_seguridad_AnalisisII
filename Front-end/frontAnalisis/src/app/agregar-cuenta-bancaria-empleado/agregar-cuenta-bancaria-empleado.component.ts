import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators'
import { Observable } from 'rxjs';
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-agregar-cuenta-bancaria-empleado',
  templateUrl: './agregar-cuenta-bancaria-empleado.component.html',
  styleUrls: ['./agregar-cuenta-bancaria-empleado.component.css']
})
export class AgregarCuentaBancariaEmpleadoComponent implements OnInit{
  public cuentaBancaria:any = {};
  public empleado:any = [];
  public banco:any = [];
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient
    , private router: Router, 
    private url:AppComponent) { }

  ngOnInit(): void {
   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
   this.usuarioMomentaneo= this.temporal.usuario;
   this.buscarEmpleado();
   this.buscarBanco();
  }

  agregarCuentaBancaria(){
    let formularioValido:any = document.getElementById("agregarCuentaBancaria");
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
     // location.href="/cuenta_bancaria_empleado";
     this.router.navigateByUrl("/cuenta_bancaria_empleado")
    }

    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
        'Accept':'txt/html'
        }),responseType:'text' as 'json'
      }

      this.cuentaBancaria.usuarioCreacion = this.usuarioMomentaneo.idUsuario;
      return this.http.post<any>(this.url.url+'miapp/cuentaBancariaEmpleado/guardar',this.cuentaBancaria,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
        }))
      }

      cancelar(){
        //location.href="/cuenta_bancaria_empleado";
        this.router.navigateByUrl("/cuenta_bancaria_empleado")
      }

      buscarEmpleado(){
        this.buscarEmpleadoServicio().subscribe(
          (response:any)=> this.empleado=response
        )
      }

      buscarEmpleadoServicio():Observable<any>{
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

      buscarBanco(){
        this.buscarBancoServicio().subscribe(
          (response:any)=> this.banco=response
        )
      }

      buscarBancoServicio():Observable<any>{
        return this.http.get<any>(this.url.url+'miapp/banco/buscar').pipe(
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