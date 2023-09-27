import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError} from 'rxjs/operators' 

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit{
  public usuario:any = {};
  public session:boolean = false;
  public mensaje:string = "";
  public role:String = "";
  public userOnline:any = [] ;
  browserName:String ="";
 
 
 
 public usuarioInvalido:boolean= false;
 constructor(private http: HttpClient) { }

 ngOnInit(): void {
  const userAgent = window.navigator.userAgent;
  this.browserName = this.detectBrowser(userAgent);

   if (!this.session){
     sessionStorage.clear();
   }
 
 }



   formularioLogin(){
     let formularioValido:any = document.getElementById("login-form");
     
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
       //this.role = json.rol;
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
     this.usuario.sesionActual = this.browserName;
     return this.http.post<any>('http://localhost:6500/miapp/login/logearse',this.usuario,httpOptions).pipe(
       catchError((error) => {
        //console.error('Ocurrió un error:', error);
        const mensaje =error.error;
        const objetoJSON = JSON.parse(mensaje);
        alert(objetoJSON.mensaje);
        throw error;
       }))
     }



     detectBrowser(userAgent: string): string {
      // Realiza alguna lógica para determinar el navegador aquí.
      // Puedes utilizar expresiones regulares o bibliotecas de detección de navegadores, como 'bowser' o 'platform.js'.
      // Aquí hay un ejemplo básico utilizando expresiones regulares:
      if (/MSIE|Trident/.test(userAgent)) {
        return 'Internet Explorer';
      } else if (/Edge/.test(userAgent)) {
        return 'Microsoft Edge';
      } else if (/Chrome/.test(userAgent)) {
        return 'Google Chrome';
      } else if (/Firefox/.test(userAgent)) {
        return 'Mozilla Firefox';
      } else if (/Safari/.test(userAgent)) {
        return 'Apple Safari';
      } else {
        return 'Navegador desconocido';
      }
    }


}
