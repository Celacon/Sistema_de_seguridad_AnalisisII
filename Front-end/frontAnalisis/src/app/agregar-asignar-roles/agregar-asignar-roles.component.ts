import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators'
import { Observable } from 'rxjs';

@Component({
  selector: 'app-agregar-asignar-roles',
  templateUrl: './agregar-asignar-roles.component.html',
  styleUrls: ['./agregar-asignar-roles.component.css']
})
export class AgregarAsignarRolesComponent  implements OnInit{
  public asignarroles:any = {id: { idRole: null, idUsuario: null }};
  public role:any = [];
  public usuario:any = [];
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient) { }
  ngOnInit(): void {



   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');

   this.usuarioMomentaneo= this.temporal.usuario;

   this.buscarRole();
   this.buscarUsuario();
    }


  agregarAsignarRoles(){
    let formularioValido:any = document.getElementById("agregarAsignarRoles");

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

        location.href="/asignacion_role_usuario";



    }



    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'

      }

      this.asignarroles.usuarioCreacion = this.usuarioMomentaneo.idUsuario;

      return this.http.post<any>('http://localhost:6500/miapp/usuario-role/guardar',this.asignarroles,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
        }))
      }

      cancelar(){
        location.href="/asignacion_role_usuario";
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


      buscarUsuario(){

        this.buscarUsuarioServicio().subscribe(
          (response:any)=> this.usuario=response


        )

      }

      buscarUsuarioServicio():Observable<any>{
        return this.http.get<any>('http://localhost:6500/miapp/usuario/buscar').pipe(
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
