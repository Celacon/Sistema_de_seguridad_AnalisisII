import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators'
import { Observable } from 'rxjs';

@Component({
  selector: 'app-agregar-menu',
  templateUrl: './agregar-menu.component.html',
  styleUrls: ['./agregar-menu.component.css']
})
export class AgregarMenuComponent implements OnInit{
  public menu:any = {};
  public modulos:any = [];

  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient) { }
  ngOnInit(): void {



   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');

   this.usuarioMomentaneo= this.temporal.usuario;

   this.buscarModulos();

  }


  agregarMenu(){
    let formularioValido:any = document.getElementById("agregarMenu");

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

        location.href="/menu";



    }



    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'

      }

      this.menu.usuarioCreacion = this.usuarioMomentaneo.idUsuario;

      return this.http.post<any>('http://localhost:6500/miapp/menu/guardar',this.menu,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
        }))
      }

      cancelar(){
        location.href="/menu";
      }

      buscarModulos(){

        this.buscarModulosServicio().subscribe(
          (response:any)=> this.modulos=response


        )

      }

      buscarModulosServicio():Observable<any>{
        return this.http.get<any>('http://localhost:6500/miapp/modulo/buscar').pipe(
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
