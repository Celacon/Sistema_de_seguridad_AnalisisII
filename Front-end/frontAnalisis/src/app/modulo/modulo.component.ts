import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError} from 'rxjs/operators'
import { Observable } from 'rxjs';
import * as XLSX from 'xlsx';
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-modulo',
  templateUrl: './modulo.component.html',
  styleUrls: ['./modulo.component.css']
})
export class ModuloComponent implements OnInit{
  modulo:any=[];
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
    this.buscarModulo();

    this.idOpcion=JSON.parse(localStorage.getItem("opcion")||'{}');
    this.buscarOpcion(this.idOpcion);
  }
  buscarModulo(){

    this.buscarModuloServicio().subscribe(
      (response:any)=> this.modulo=response


    )

  }
  buscarModuloServicio():Observable<any>{
    return this.http.get<any>(this.url.url+'miapp/modulo/buscar').pipe(
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
     // location.href="/editar_modulo";
      this.router.navigateByUrl("/editar_modulo")
    }

    eliminar(datos:any){

      this.eliminarModuloServicio(datos.idModulo).subscribe(
         (response:any)=> this.confirmarEliminacion(response)
       )
     }

     confirmarEliminacion(response:any){

      alert(response.mensaje);
       this.buscarModulo()
     }
     eliminarModuloServicio(id:any){
      return this.http.delete<any>(this.url.url+'miapp/modulo/EliminarModulo/'+id).pipe(
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

//location.href="/AgregueModulo";
this.router.navigateByUrl("/AgregueModulo")
}
name = 'reportemodulo.xlsx';
exportToExcel(): void {
  let element = document.getElementById('modulo');
  const worksheet: XLSX.WorkSheet = XLSX.utils.table_to_sheet(element);

  const book: XLSX.WorkBook = XLSX.utils.book_new();
  XLSX.utils.book_append_sheet(book, worksheet, 'Sheet1');

  XLSX.writeFile(book, this.name);
}

}
