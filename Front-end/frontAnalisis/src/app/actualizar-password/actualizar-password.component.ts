import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError,tap} from 'rxjs/operators' 

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
 

  constructor(private http: HttpClient) { }
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
        //this.session = true;
        //this.mensaje = "Bienvenido " + json.usuario;
        alert(json.mensaje);
        location.href=json.pagina;
  
      }/* else {
        this.session = true;
 
          this.mensaje = "*Intente de nuevo o contáctese con el administrador del sistema";
          alert("Usuario o Contraseña Inválido");
          formularioLogin.reset();
      }*/
  
    }
 
 ///admin
    
    servicioLogin(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'
        
      } 
     
      this.usuarioA.idUsuario = this.usuarioMomentaneo.idUsuario;
      
      return this.http.post<any>('http://localhost:6500/miapp/usuario/actualizarPassword',this.usuarioA,httpOptions).pipe(
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
      }
    
 
 
 }
 
