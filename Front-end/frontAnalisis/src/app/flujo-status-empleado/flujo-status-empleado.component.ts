import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import * as XLSX from 'xlsx';
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-flujo-status-empleado',
  templateUrl: './flujo-status-empleado.component.html',
  styleUrls: ['./flujo-status-empleado.component.css']
})
export class FlujoStatusEmpleadoComponent implements OnInit{
  flujoStatusEmpleado: any = [];
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
    this.buscarFlujoStatusEmpleado();

    this.idOpcion = JSON.parse(localStorage.getItem('opcion') || '{}');
    this.buscarOpcion(this.idOpcion);
  }
  buscarFlujoStatusEmpleado() {
    this.buscarFlujoStatusEmpleadoServicio().subscribe(
      (response: any) => (this.flujoStatusEmpleado = response)
    );
  }

  buscarFlujoStatusEmpleadoServicio(): Observable<any> {
    return this.http
      .get<any>(this.url.url+'miapp/flujoStatusEmpleado/buscar')
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

  buscarFlujoStatusEmpleadoId() {
    this.buscarFlujoStatusEmpleadoServicio().subscribe(
      (response: any) => (this.flujoStatusEmpleado = response)
    );
  }

  buscarFlujoStatusEmpleadoIdServicio(): Observable<any> {
    return this.http
      .get<any>(this.url.url+'miapp/flujoStatusEmpleado/buscar')
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
   // location.href = '/editar_flujo_status_empleado';
    this.router.navigateByUrl("/editar_flujo_status_empleado")
  }

  eliminar(datos: any) {
    this.eliminarStatusUsuarioServicio(datos.idStatusActual).subscribe((response: any) =>
      this.confirmarEliminacion(response)
    );
  }

  confirmarEliminacion(response: any) {
    alert(response.mensaje);
    this.buscarFlujoStatusEmpleado();
  }

  eliminarStatusUsuarioServicio(id: any) {
    return this.http
      .delete<any>(this.url.url+'miapp/flujoStatusEmpleado/eliminar/' + id.idStatusActual + '/' + id.idStatusNuevo)
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
   // location.href = '/agregar_flujo_status_empleado';
    this.router.navigateByUrl("/agregar_flujo_status_empleado")
  }

  name = 'reporteFlujoEmpleado.xlsx';
  exportToExcel(): void {
    let element = document.getElementById('flujoEmpleado');
    const worksheet: XLSX.WorkSheet = XLSX.utils.table_to_sheet(element);

    const book: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(book, worksheet, 'Sheet1');

    XLSX.writeFile(book, this.name);
  } 

}