import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators' 
import { Observable } from 'rxjs';
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-agregar-puesto',
  templateUrl: './agregar-puesto.component.html',
  styleUrls: ['./agregar-puesto.component.css']
})
export class AgregarPuestoComponent implements OnInit{
  public agregaPuesto:any = {};
  public departamento:any = [];
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient
    , private router: Router, 
    private url:AppComponent) { }

  ngOnInit(): void {
   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
   this.usuarioMomentaneo= this.temporal.usuario;
   this.buscarDepartamento();
  }

  agregarPuesto(){
    let formularioValido:any = document.getElementById("agregarPuesto");
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
      //location.href="/puesto";
      this.router.navigateByUrl("/puesto")
      
    }
    
    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'
      } 
     
      this.agregaPuesto.usuarioCreacion = this.usuarioMomentaneo.idUsuario;
      return this.http.post<any>(this.url.url+'miapp/puesto/guardar',this.agregaPuesto,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
        }))
      }

      cancelar(){
        //location.href="/puesto";
        this.router.navigateByUrl("/puesto")
      }

      buscarDepartamento(){
        this.buscarDepartamentoServicio().subscribe(
          (response:any)=> this.departamento=response
        )
      }
    
      buscarDepartamentoServicio():Observable<any>{
        return this.http.get<any>(this.url.url+'miapp/departamento/buscar').pipe(
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
