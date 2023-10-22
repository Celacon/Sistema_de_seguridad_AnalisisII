import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators' 
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

@Component({
  selector: 'app-actualizar-password',
  templateUrl: './actualizar-password.component.html',
  styleUrls: ['./actualizar-password.component.css']
})
export class ActualizarPasswordComponent implements OnInit{

  public usuarioA:any = {};
  public usuarioMomentaneo:any = {};
  temporal:any ={};
  public session:boolean = false;
  public mensaje:string = "";
  public role:String = "";
  public userOnline:any = [] ;
 

  constructor(private http: HttpClient,  private router: Router, private url:AppComponent) { }
  ngOnInit(): void {

    
   
   this.temporal=JSON.parse(localStorage.getItem("usu")||'{}');
  
   this.usuarioMomentaneo= this.temporal.usuario;


  
  
  }


  formularioActualizarPassword(){
    let formularioValido:any = document.getElementById("actualizarPassword-form");
    
    if(formularioValido.reportValidity()){
      this.servicioLogin().subscribe(
        (respuesta: any)=>  this.loginAdmin(respuesta)
      )
      
    }

  }

  loginAdmin(res: any){
    // console.log("res -->" + res);
      let json = JSON.parse(res);
      //let formularioLogin:any = document.getElementById("login-form");
      console.log(json);
 
      
      if(json.ususario != "none"){
     
 
        localStorage.setItem("usu",JSON.stringify(json))        
  
        alert(json.mensaje);
        location.href=json.pagina;
  
      }
  
    }
 
 ///admin
    
    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'
        
      } 
     
      this.usuarioA.idUsuario = this.usuarioMomentaneo.idUsuario;
      
      return this.http.post<any>(this.url.url+'miapp/usuario/actualizarPassword',this.usuarioA,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; 
          }))
      }

      salir(){
        localStorage.clear();
        location.href="/";
        this.router.navigateByUrl("/")
      }
    
 
 
 }
 
