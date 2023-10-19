import { Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators'
import { Observable } from 'rxjs';

@Component({
  selector: 'app-editar-asignar-opciones',
  templateUrl: './editar-asignar-opciones.component.html',
  styleUrls: ['./editar-asignar-opciones.component.css']
})
export class EditarAsignarOpcionesComponent implements OnInit {
  public asignaropciones:any = {};
  public opcion:any = [];
  public role:any = [];
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient) { }
  ngOnInit(): void {
   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
    this.usuarioMomentaneo= this.temporal.usuario;
    this.asignaropciones=JSON.parse(localStorage.getItem("editar")||'{}');

    this.buscarOpcion();

    this.buscarRole();
   }


   editarAsignarOpciones(){
    let formularioValido:any = document.getElementById("editarAsignarOpciones");

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

        location.href="/asignacion_opcion_role";



    }



    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'

      }

      this.asignaropciones.usuarioModificacion = this.usuarioMomentaneo.idUsuario;

      return this.http.post<any>('http://localhost:6500/miapp/role-opcion/editar',this.asignaropciones,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
        }))
      }

      cancelar(){
        localStorage.removeItem("editar")
        location.href="/asignacion_opcion_role";
      }


      buscarOpcion(){

        this.buscarOpcionServicio().subscribe(
          (response:any)=> this.opcion=response


        )

      }

      buscarOpcionServicio():Observable<any>{
        return this.http.get<any>('http://localhost:6500/miapp/opcion/buscar').pipe(
          catchError((error) => {
            console.log(error);
            const mensaje =error.error;
            const objetoJSON = JSON.parse(mensaje);
            alert(objetoJSON.mensaje);
            throw error;
            })
        )
      }

      buscarRole(){

        this.buscarRoleServicio().subscribe(
          (response:any)=> this.role=response


        )

      }

      buscarRoleServicio():Observable<any>{
        return this.http.get<any>('http://localhost:6500/miapp/role/buscar').pipe(
          catchError((error) => {
            console.log(error);
            const mensaje =error.error;
            const objetoJSON = JSON.parse(mensaje);
            alert(objetoJSON.mensaje);
            throw error;
            })
        )
      }
}
