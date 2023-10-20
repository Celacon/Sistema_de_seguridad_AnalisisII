import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators' 
import { Observable } from 'rxjs';

@Component({
  selector: 'app-editar-puesto',
  templateUrl: './editar-puesto.component.html',
  styleUrls: ['./editar-puesto.component.css']
})
export class EditarPuestoComponent implements OnInit{
  public puesto:any = {};
  public departamento:any = [];
  public usuarioMomentaneo:any = {};
  temporal:any ={};

  constructor(private http: HttpClient) { }
  ngOnInit(): void { 
   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
    this.usuarioMomentaneo= this.temporal.usuario;
    this.puesto=JSON.parse(localStorage.getItem("editar")||'{}');
    this.buscarDepartamento();
   }

   editarPuesto(){
    let formularioValido:any = document.getElementById("editarPuesto");
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
        location.href="/puesto";
    }
 
    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'
      } 
     
      this.puesto.usuarioModificacion = this.usuarioMomentaneo.idUsuario;
      return this.http.post<any>('http://localhost:6500/miapp/puesto/editar',this.puesto,httpOptions).pipe(
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
        location.href="/puesto";
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

}
