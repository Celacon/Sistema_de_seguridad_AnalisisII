import { Component,OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators' 
import { Observable } from 'rxjs';
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-detalle-planilla',
  templateUrl: './detalle-planilla.component.html',
  styleUrls: ['./detalle-planilla.component.css']
})
export class DetallePlanillaComponent implements OnInit{
  public idCabeceraPlanilla2:any = {};
  public cabeceraPlanilla:any = {};
  public usuarioMomentaneo:any = {};
  public detalle:any = [];
  public empleado:any = [];
  temporal:any ={};

  constructor(private http: HttpClient
    , private router: Router, 
    private url:AppComponent) { }

  ngOnInit(): void { 
  
    this.localStorage()
    
    }


    localStorage(){
      this.temporal=localStorage.getItem("usu");
      if(this.temporal!=null){
        this.temporal=JSON.parse(this.temporal||'{}');

     this.usuarioMomentaneo= this.temporal.usuario;
     this.idCabeceraPlanilla2=JSON.parse(localStorage.getItem("editar")||'{}');
  
    this.buscarCabecera(this.idCabeceraPlanilla2);
   // this. buscarEmpleado();
      }
    }


    buscarCabecera(id:any){
      
      this.buscarCabeceraServicio(id).subscribe(
        (response:any)=> this.cabeceraPlanilla=response[0]
        //console.log(response[0].idPlanillaCabecera)
        
      )
      this.buscarDetalle(id);
     
    }
  
    buscarCabeceraServicio(id:any):Observable<any>{
      return this.http.get<any>(this.url.url+'miapp/planillaCabecera/buscarId/'+id.anio+'/'+id.mes).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; 
          })
      )
    }



    buscarDetalle(id:any){

      this.buscarDetalleServicio(id).subscribe(
        (response:any)=> this.detalle=response
        //console.log(response[0].idPlanillaCabecera)
        
      )
     
    }
  
    buscarDetalleServicio(id:any):Observable<any>{
      return this.http.get<any>(this.url.url+'miapp/planillaDetalle/buscarId2/'+id.anio+'/'+id.mes).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; 
          })
      )
    }


    buscarEmpleado(){

      this.buscarEmpleadoServicio().subscribe(
        (response:any)=> this.empleado=response
       // console.log(response)
        
      )
     
    }
  
    buscarEmpleadoServicio():Observable<any>{
      return this.http.get<any>(this.url.url+'miapp/empleado/buscar/').pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; 
          })
      )
    }


    getEmpleadoNombre(idEmpleado: number): number {
      console.log(this.empleado.length)
      for (let x = 0; x < this.empleado.length; x++) {
        if (this.empleado.idEmpleado == idEmpleado) {
          return this.empleado[x].idPersona
        }
      }
      return 0;
    }

  
    cancelar(){
      //location.href="/reporte_planilla";
      this.router.navigateByUrl("/reporte_planilla")
    }
  
   
    


}
