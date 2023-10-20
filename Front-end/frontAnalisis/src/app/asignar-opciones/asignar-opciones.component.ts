
import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError} from 'rxjs/operators'
import { Observable } from 'rxjs';
import * as XLSX from 'xlsx';

@Component({
  selector: 'app-asignar-opciones',
  templateUrl: './asignar-opciones.component.html',
  styleUrls: ['./asignar-opciones.component.css']
})
export class AsignarOpcionesComponent implements OnInit{
  asignaropciones:any=[];
  paginaActual:number=1;
  idOpcion:any={};
  opcion:any={};
  edit: boolean = true;
  create: boolean = true;
  delete: boolean = true;
  print: boolean = true;
  export: boolean = true;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.buscarAsignarOpciones();

    this.idOpcion=JSON.parse(localStorage.getItem("opcion")||'{}');
    this.buscarOpcion(this.idOpcion);
  }
  buscarAsignarOpciones(){

    this.buscarAsignarOpcionesServicio().subscribe(
      (response:any)=> this.asignaropciones=response


    )

  }
  buscarAsignarOpcionesServicio():Observable<any>{
    return this.http.get<any>('http://localhost:6500/miapp/role-opcion/buscar').pipe(
      catchError((error) => {
        console.log(error);
        const mensaje =error.error;
        const objetoJSON = JSON.parse(mensaje);
        alert(objetoJSON.mensaje);
        throw error;
        })
    )
  }
  editar(datos:any){

    datos.password=null;
      localStorage.setItem("editar",JSON.stringify(datos))
      location.href="/editar_asignaropciones";
    }

    eliminar(datos:any){

      this.eliminarAsignarOpcionesServicio(datos.id).subscribe(
         (response:any)=> this.confirmarEliminacion(response)
       )
     }
     confirmarEliminacion(response:any){

      alert(response.mensaje);
       this.buscarAsignarOpciones()
     }

       eliminarAsignarOpcionesServicio(id:any){
         return this.http.delete<any>('http://localhost:6500/miapp/role-opcion/eliminarRoleOpcion/'+id.idRole+'/'+id.idOpcion).pipe(
           catchError(e=> "error")
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
    return this.http.get<any>('http://localhost:6500/miapp/role-opcion/buscarId/'+id.idRole+'/'+id.idOpcion).pipe(
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

    location.href="/AgregueAsignarOpciones";
  }

  name = 'reporteasignaropciones.xlsx';
  exportToExcel(): void {
    let element = document.getElementById('asignarOpciones');
    const worksheet: XLSX.WorkSheet = XLSX.utils.table_to_sheet(element);

    const book: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(book, worksheet, 'Sheet1');

    XLSX.writeFile(book, this.name);
  }

}
