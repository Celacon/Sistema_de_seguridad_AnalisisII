import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError} from 'rxjs/operators' 
import { Observable } from 'rxjs';
import * as XLSX from 'xlsx';
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-reporte-planilla',
  templateUrl: './reporte-planilla.component.html',
  styleUrls: ['./reporte-planilla.component.css']
})
export class ReportePlanillaComponent implements OnInit{
  planillaCabecera:any=[];
  paginaActual:number=1;
  idOpcion:any={};
  opcion:any={};
  edit: boolean = true;
  create: boolean = true;
  delete: boolean = true;
  print: boolean = true;
  export: boolean = true;

  constructor(private http: HttpClient
    , private router: Router, 
    private url:AppComponent) { }

  ngOnInit(): void {
    this.buscarPlanillaCabecera();

    this.idOpcion=JSON.parse(localStorage.getItem("opcion")||'{}');
    this.buscarOpcion(this.idOpcion);


  }

  buscarPlanillaCabecera(){

    this.buscarPlanillaCabeceraServicio().subscribe(
      (response:any)=> this.planillaCabecera=response
//console.log(response)
      
    )
   
  }

  buscarPlanillaCabeceraServicio():Observable<any>{
    return this.http.get<any>(this.url.url+'miapp/planillaCabecera/buscar').pipe(
      catchError((error) => {
        console.log(error);
        const mensaje =error.error;
        const objetoJSON = JSON.parse(mensaje);
        alert(objetoJSON.mensaje);
        throw error; 
        })
    )
  }










  buscarOpcion(id:any){

    this.buscarOpcionServicio(id).subscribe(
      (response:any)=> this.validarOpcion(response)

      
    )
   
  }

  validarOpcion(opcion:any){

    console.log(opcion[0]);

   this.edit = (opcion[0].cambio === 1) ? true : false;
this.create = (opcion[0].alta === 1) ? true : false;
this.delete = (opcion[0].baja === 1) ? true : false;
this.print = (opcion[0].imprimir === 1) ? true : false;
this.export = (opcion[0].exportar === 1) ? true : false;

  }

  buscarOpcionServicio(id:any):Observable<any>{
    return this.http.get<any>(this.url.url+'miapp/role-opcion/buscarId/'+id.idRole+'/'+id.idOpcion).pipe(
      catchError((error) => {
        console.log(error);
        const mensaje =error.error;
        const objetoJSON = JSON.parse(mensaje);
        alert(objetoJSON.mensaje);
        throw error; 
        })
    )
  }

  agregar(){
   
    //location.href="/calculo_planilla";
    this.router.navigateByUrl("/calculo_planilla")
  }

  editar(datos:any){

      localStorage.setItem("editar",JSON.stringify(datos.idPlanillaCabecera))
     // location.href="/detalle_planilla";
     this.router.navigateByUrl("/detalle_planilla")
    }


  eliminar(datos:any){

    this.eliminarAlumnoServicio(datos.idPlanillaCabecera).subscribe(
       (response:any)=> this.confirmarEliminacion(response)
     )
   }
   
   confirmarEliminacion(response:any){
 
    alert(response.mensaje);
     this.buscarPlanillaCabecera()
   }
   
     eliminarAlumnoServicio(id:any){
       return this.http.delete<any>(this.url.url+'miapp/planillaCabecera/eliminar/'+id.anio+'/'+id.mes).pipe(
         catchError(e=> "error")
       )
     }

     name = 'reporte.xlsx';
     exportToExcel(): void {
       let element = document.getElementById('planilla');
       const worksheet: XLSX.WorkSheet = XLSX.utils.table_to_sheet(element);
   
       const book: XLSX.WorkBook = XLSX.utils.book_new();
       XLSX.utils.book_append_sheet(book, worksheet, 'Sheet1');
   
       XLSX.writeFile(book, this.name);
     }     

}
