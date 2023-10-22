import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators' 
import { Observable } from 'rxjs';
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-agregar-inasistencia',
  templateUrl: './agregar-inasistencia.component.html',
  styleUrls: ['./agregar-inasistencia.component.css']
})
export class AgregarInasistenciaComponent implements OnInit{
  public inasistencia:any = {};
  public buscarEmpleado:any = [];
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient
    , private router: Router, 
    private url:AppComponent) { }

  ngOnInit(): void {
   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
   this.usuarioMomentaneo= this.temporal.usuario;
   this.buscaEmpleado();
  }

  agregarInasistencia(){
    let formularioValido:any = document.getElementById("agregarInasistencia");
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
       // location.href="/inasistencia";
       this.router.navigateByUrl("/inasistencia")    
      }
 
    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'
      } 
     
      this.inasistencia.usuarioCreacion = this.usuarioMomentaneo.idUsuario;
      
      return this.http.post<any>(this.url.url+'miapp/inasistencia/guardar',this.inasistencia,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
        }))
      }

      cancelar(){
        //location.href="/inasistencia";
        this.router.navigateByUrl("/inasistencia")   
      }

      buscaEmpleado(){
        this.buscarEmpleadoServicio().subscribe(
          (response:any)=> this.buscarEmpleado=response
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

}
