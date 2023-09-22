import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable, catchError } from 'rxjs';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
 public  opciones:any=[];
  temporal:any ={};
  public usuarioMomentaneo:any = {};

  constructor(private http: HttpClient ){}

  ngOnInit(): void {

    this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
  
   this.usuarioMomentaneo= this.temporal.usuario;
   let id =this.usuarioMomentaneo.listUsuarioRole[0].id.idRole;
this.opcionesService(id);

console.log(this.opciones);

  
    
  }

opcionesService(id:any){
  this.buscarOpciones(id).subscribe(
    (response:any)=> {
      this.opciones = response; // Asigna los datos a la variable opciones dentro de la función subscribe
     // console.log(this.opciones); // Ahora puedes imprimir los datos aquí y deberían estar disponibles
    } );
 
  

}

  buscarOpciones(id:any):Observable<any>{
    return this.http.get<any>('http://localhost:6500/miapp/modulo/buscarIdRole/'+id).pipe(
      catchError(e=> "error")
    )
  }

  toggleSubMenu(modulo: any): void {
    modulo.showSubmenu = !modulo.showSubmenu;
  }
  
  salir(){
    localStorage.clear();
    location.href="/";
  }

 
  

}
