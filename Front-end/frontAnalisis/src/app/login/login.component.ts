import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {catchError} from 'rxjs/operators' 
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";

//this.router.navigateByUrl(json.pagina)

//this.router.navigateByUrl("/")

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
 
 constructor(private http: HttpClient
  , private router: Router, 
  private url:AppComponent) { }

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
 
     let json = JSON.parse(res);

     if(json.ususario != "none"){
    

       localStorage.setItem("usu",JSON.stringify(json))        
    //copiar esto 
    //
    //
    //
    //
       this.router.navigateByUrl(json.pagina)
 ///
 ///
 ///

     }
   }

///admin
   
   servicioLogin(){
     let httpOptions ={
       Headers: new HttpHeaders({
         'Accept':'txt/html'
       }),responseType:'text' as 'json'
       
     } 
     this.usuario.sesionActual = this.browserName;
     return this.http.post<any>(this.url.url+'miapp/login/logearse',this.usuario,httpOptions).pipe(
       catchError((error) => {
        const mensaje =error.error;
        const objetoJSON = JSON.parse(mensaje);
        alert(objetoJSON.mensaje);
        throw error;
       }))
     }



     detectBrowser(userAgent: string): string {
      console.log(userAgent);
    
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
