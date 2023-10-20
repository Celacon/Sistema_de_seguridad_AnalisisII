import { Component , OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError} from 'rxjs/operators'
import { Observable } from 'rxjs';
import * as XLSX from 'xlsx';


@Component({
  selector: 'app-departamento',
  templateUrl: './departamento.component.html',
  styleUrls: ['./departamento.component.css']
})
export class DepartamentoComponent implements OnInit{
  departamento:any=[];
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
    this.buscarDepartamento();

    this.idOpcion=JSON.parse(localStorage.getItem("opcion")||'{}');
    this.buscarOpcion(this.idOpcion);
  }
  buscarDepartamento(){

    this.buscarDepartamentoServicio().subscribe(
      (response:any)=> this.departamento=response


    )

  }
  buscarDepartamentoServicio():Observable<any>{
    return this.http.get<any>('http://localhost:6500/miapp/departamento/buscar').pipe(
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
      location.href="/editarDepartamento";
    }

    eliminar(datos:any){

      this.eliminarDepartamentoServicio(datos.idDepartamento).subscribe(
         (response:any)=> this.confirmarEliminacion(response)
       )
     }
     confirmarEliminacion(response:any){

      alert(response.mensaje);
       this.buscarDepartamento()
     }

     eliminarDepartamentoServicio(id:any){
         return this.http.delete<any>('http://localhost:6500/miapp/departamento/eliminar/'+id).pipe(
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

    location.href="/agregarDepartamento";
  }

  name = 'reportedepartamento.xlsx';
  exportToExcel(): void {
    let element = document.getElementById('departamento');
    const worksheet: XLSX.WorkSheet = XLSX.utils.table_to_sheet(element);

    const book: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(book, worksheet, 'Sheet1');

    XLSX.writeFile(book, this.name);
  }


}
