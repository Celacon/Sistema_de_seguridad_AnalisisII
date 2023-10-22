import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import * as XLSX from 'xlsx';
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-status-empleado',
  templateUrl: './status-empleado.component.html',
  styleUrls: ['./status-empleado.component.css']
})
export class StatusEmpleadoComponent implements OnInit{
  statusEmpleado: any = [];
  paginaActual: number = 1;
  idOpcion: any = {};
  opcion: any = {};
  edit: boolean = true;
  create: boolean = true;
  delete: boolean = true;
  print: boolean = true;
  export: boolean = true;

  constructor(private http: HttpClient
    , private router: Router, 
    private url:AppComponent) { }

  ngOnInit(): void {
    this.buscarStatusEmpleado();
    this.idOpcion = JSON.parse(localStorage.getItem('opcion') || '{}');
    this.buscarOpcion(this.idOpcion);
  }
  buscarStatusEmpleado() {
    this.buscarStatusEmpleadoServicio().subscribe(
      (response: any) => (this.statusEmpleado = response)
    );
  }

  buscarStatusEmpleadoServicio(): Observable<any> {
    return this.http
      .get<any>(this.url.url+'miapp/statusEmpleado/buscar')
      .pipe(
        catchError((error) => {
          console.log(error);
          const mensaje = error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error;
        })
      );
  }

  editar(datos: any) {
    datos.password = null;
    localStorage.setItem('editar', JSON.stringify(datos));
    //location.href = '/editar-estatus-empleado';
    this.router.navigateByUrl("/editar-estatus-empleado")
  }

  eliminar(datos: any) {
    this.eliminarStatusEmpleadoServicio(datos.idStatusEmpleado).subscribe((response: any) =>
      this.confirmarEliminacion(response)
    );
  }

  confirmarEliminacion(response: any) {
    alert(response.mensaje);
    this.buscarStatusEmpleado();
  }

  eliminarStatusEmpleadoServicio(id: any) {
    return this.http
      .delete<any>(this.url.url+'miapp/statusEmpleado/eliminar/' + id)
      .pipe(catchError((e) => 'error'));
  }

  buscarOpcion(id: any) {
    this.buscarOpcionServicio(id).subscribe((response: any) =>
      this.validarOpcion(response)
    );
  }

  validarOpcion(opcion: any) {
    console.log(opcion[0]);

    this.edit = opcion[0].cambio === 1 ? true : false;
    this.create = opcion[0].alta === 1 ? true : false;
    this.delete = opcion[0].baja === 1 ? true : false;
    this.print = opcion[0].imprimir === 1 ? true : false;
    this.export = opcion[0].exportar === 1 ? true : false;
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

  agregar() {
    //location.href = '/agregar-estatus-empleado';
    this.router.navigateByUrl("/agregar-estatus-empleado")
  }

  name = 'StatusReporte.xlsx';
  exportToExcel(): void {
    let element = document.getElementById('statusEmpleado');
    const worksheet: XLSX.WorkSheet = XLSX.utils.table_to_sheet(element);

    const book: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(book, worksheet, 'Sheet1');

    XLSX.writeFile(book, this.name);
  } 

}
