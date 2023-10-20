import { Component , OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators'
import { Observable } from 'rxjs';

@Component({
  selector: 'app-agregar-departamento',
  templateUrl: './agregar-departamento.component.html',
  styleUrls: ['./agregar-departamento.component.css']
})
export class AgregarDepartamentoComponent implements OnInit {
  public departamento:any = {};
  public empresa:any = [];
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient) { }
  ngOnInit(): void {



   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');

   this.usuarioMomentaneo= this.temporal.usuario;

   this.buscarEmpresa();
  }


  agregarDepartamento(){
    let formularioValido:any = document.getElementById("agregarDepartamento");

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

        location.href="/departamento";



    }



    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'

      }

      this.departamento.usuarioCreacion = this.usuarioMomentaneo.idUsuario;

      return this.http.post<any>('http://localhost:6500/miapp/departamento/guardar',this.departamento,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; // Propaga el error para que pueda ser manejado por quien llame a esta función
        }))
      }

      cancelar(){
        location.href="/departamento";
      }

      buscarEmpresa(){

        this.buscarEmpresaServicio().subscribe(
          (response:any)=> this.empresa=response


        )

      }

      buscarEmpresaServicio():Observable<any>{
        return this.http.get<any>('http://localhost:6500/miapp/empresa/buscar').pipe(
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
