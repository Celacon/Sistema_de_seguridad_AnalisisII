import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-estado-civil',
  templateUrl: './estado-civil.component.html',
  styleUrls: ['./estado-civil.component.css']
})
export class EstadoCivilComponent implements OnInit{
  estadoCivil: any = [];
  paginaActual: number = 1;
  idOpcion: any = {};
  opcion: any = {};
  edit: boolean = true;
  create: boolean = true;
  delete: boolean = true;
  print: boolean = true;
  export: boolean = true;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.buscarEstadoCivil();
    this.idOpcion = JSON.parse(localStorage.getItem('opcion') || '{}');
    this.buscarOpcion(this.idOpcion);
  }
  buscarEstadoCivil() {
    this.buscarEstadoCivilServicio().subscribe(
      (response: any) => (this.estadoCivil = response)
    );
  }

  buscarEstadoCivilServicio(): Observable<any> {
    return this.http
      .get<any>('http://localhost:6500/miapp/estadoCivil/buscar')
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
    location.href = '/editar-estado-civil';
  }

  eliminar(datos: any) {
    this.eliminarEstadoCivilServicio(datos.idEstadoCivil).subscribe((response: any) =>
      this.confirmarEliminacion(response)
    );
  }

  confirmarEliminacion(response: any) {
    alert(response.mensaje);
    this.buscarEstadoCivil();
  }

  eliminarEstadoCivilServicio(id: any) {
    return this.http
      .delete<any>('http://localhost:6500/miapp/estadoCivil/eliminar/' + id)
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

  buscarOpcionServicio(id: any): Observable<any> {
    return this.http
      .get<any>(
        'http://localhost:6500/miapp/role-opcion/buscarId/' +
          id.idRole +
          '/' +
          id.idOpcion
      )
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

  agregar() {
    location.href = '/agregar-estado-civil';
  }

}
