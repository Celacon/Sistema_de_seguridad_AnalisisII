import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";


@Component({
  selector: 'app-estatus-usuario',
  templateUrl: './estatus-usuario.component.html',
  styleUrls: ['./estatus-usuario.component.css']
})
export class EstatusUsuarioComponent implements OnInit{
  statusUsuario: any = [];
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
    this.buscarStatusUsuario();

    this.idOpcion = JSON.parse(localStorage.getItem('opcion') || '{}');
    this.buscarOpcion(this.idOpcion);
  }
  buscarStatusUsuario() {
    this.buscarStatusUsuarioServicio().subscribe(
      (response: any) => (this.statusUsuario = response)
    );
  }

  buscarStatusUsuarioServicio(): Observable<any> {
    return this.http
      .get<any>(this.url.url+'miapp/status-usuario/buscar')
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
    //location.href = '/editar-estatus-usuario';
    this.router.navigateByUrl("/editar-estatus-usuario")
    
  }

  eliminar(datos: any) {
    this.eliminarStatusUsuarioServicio(datos.idStatusUsuario).subscribe((response: any) =>
      this.confirmarEliminacion(response)
    );
  }

  confirmarEliminacion(response: any) {
    alert(response.mensaje);
    this.buscarStatusUsuario();
  }

  eliminarStatusUsuarioServicio(id: any) {
    return this.http
      .delete<any>(this.url.url+'miapp/status-usuario/EliminarEstatusUsuario/' + id)
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
    //location.href = '/agregar-estatus-usuario';
    this.router.navigateByUrl("/agregar-estatus-usuario")
  }


}
