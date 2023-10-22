import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError} from 'rxjs/operators' 
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-agregar-preguntas',
  templateUrl: './agregar-preguntas.component.html',
  styleUrls: ['./agregar-preguntas.component.css']
})
export class AgregarPreguntasComponent {

  preguntas:any=[];
  pregunta:any={};
  noPreguntas:any=2;
  formularioHabilitado: boolean = true;
  numerosDisponibles: number[] = [];
  preguntasSeleccionadas: number[] = [];
  filtrado: number[] = [];
  temporal:any ={};
  public usuarioMomentaneo:any = {};

  constructor(private http: HttpClient
    , private router: Router, 
    private url:AppComponent) { }

  ngOnInit(): void {
    this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
  
    this.usuarioMomentaneo= this.temporal.usuario;
    this.numerosDisponibles = Array.from({ length: this.noPreguntas }, (_, i) => i + 1);
  }

  agregarPregunta(){
    const p = {
      idUsuario:this.usuarioMomentaneo.idUsuario,
      pregunta: this.pregunta.pregunta,
      respuesta: this.pregunta.respuesta,
      ordenPregunta:this.pregunta.ordenPregunta
    };


    this.preguntas.push(p);
    this.preguntasSeleccionadas.push(this.pregunta.ordenPregunta);

    this.pregunta.pregunta = '';
    this.pregunta.respuesta = '';
   this.pregunta.ordenPregunta = '';

    if (this.preguntas.length >= this.noPreguntas) {
      this.formularioHabilitado = false;
    }
  }


  
  formularioLogin(){
    
    if(this.preguntas.length!==0){
      this.servicioGuardarPreguntas().subscribe(
        (respuesta: any)=>  this.responsePregunta(respuesta)
      )
      
    }

  }



  responsePregunta(res: any){
    let json = JSON.parse(res);
  alert(json.mensaje);
 // location.href=json.pagina;
  this.router.navigateByUrl(json.pagina)
    console.log(json);

    
    
  }

///admin
  
  servicioGuardarPreguntas(){
    let httpOptions ={
      Headers: new HttpHeaders({
        'Accept':'txt/html'
      }),responseType:'text' as 'json'
      
    } 
    return this.http.post<any>(this.url.url+'miapp/usuario-pregunta/guardar',this.preguntas,httpOptions).pipe(
      catchError((error) => {
   
     //  const mensaje =error.error;
       //const objetoJSON = JSON.parse(mensaje);
       //alert(objetoJSON.mensaje);
       throw error;
      }))
    }
    salir(){
      localStorage.clear();
      //location.href="/";
      this.router.navigateByUrl("/")
    }
  


}
