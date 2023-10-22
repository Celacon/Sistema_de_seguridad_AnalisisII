import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators' 
import { Observable } from 'rxjs';
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-planilla',
  templateUrl: './planilla.component.html',
  styleUrls: ['./planilla.component.css']
})
export class PlanillaComponent implements OnInit{
  periodo:any=[];
  public usuarioMomentaneo:any = {};
  temporal:any ={};
  cabecera:any ={};
  cabecera2:any ={};

  constructor(private http: HttpClient
    , private router: Router, 
    private url:AppComponent) { }
    
  ngOnInit(): void {

    this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
  
   this.usuarioMomentaneo= this.temporal.usuario;
   this.buscarPeriodo();
  }



  buscarPeriodo(){

    this.buscarPeriodoServicio().subscribe(
      (response:any)=> this.periodo=response

      
    )
   
  }

  buscarPeriodoServicio():Observable<any>{
    return this.http.get<any>(this.url.url+'miapp/periodoPlanilla/buscar').pipe(
      catchError((error) => {
        console.log(error);
        const mensaje =error.error;
        const objetoJSON = JSON.parse(mensaje);
        alert(objetoJSON.mensaje);
        throw error; 
        })
    )
  }



  agregarUsuario(){

    this.cabecera2 = {
      idPlanillaCabecera: {
        anio: this.cabecera.anio,
        mes: this.cabecera.mes
      }
    };
   // this.cabecera2.idPlanillaCabecera = this.cabecera.anio;
    //this.cabecera2.idPlanillaCabecera = this.cabecera.mes;
    let formularioValido:any = document.getElementById("agregarUsuario");
    
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
 
      //location.href="/reporte_planilla";
      this.router.navigateByUrl("/reporte_planilla")
  
     
  
    }
 

    
    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'
        
      } 
     console.log(this.cabecera2)
      this.cabecera2.usuarioCreacion = this.usuarioMomentaneo.idUsuario;
      
      return this.http.post<any>(this.url.url+'miapp/planillaCabecera/guardar',this.cabecera2,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
        }))
      }

  cancelar(){
    //location.href="/reporte_planilla";
    this.router.navigateByUrl("/reporte_planilla")
  }

}
