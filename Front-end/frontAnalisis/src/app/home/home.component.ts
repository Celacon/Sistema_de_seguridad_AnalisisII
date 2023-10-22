import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { AppComponent } from '../app.component';
import { Router } from "@angular/router";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
 public  opciones:any=[];
  temporal:any ={};
  public usuarioMomentaneo:any = {};

  constructor(private http: HttpClient
    , private router: Router, 
    private url:AppComponent) { }


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
      this.opciones = response;
    } );
 
  

}

  buscarOpciones(id:any):Observable<any>{
    return this.http.get<any>(this.url.url+'miapp/modulo/buscarIdRole/'+id).pipe(
      catchError(e=> "error")
    )
  }

  toggleSubMenu(modulo: any): void {
    modulo.showSubmenu = !modulo.showSubmenu;
  }
  
  salir(){
    localStorage.clear();
    //location.href="/";
    this.router.navigateByUrl("/")
this.salirSer();

  }

  usuarioOpcion(idOpcion:any){
    const p = {
      idRole:this.usuarioMomentaneo.listUsuarioRole[0].id.idRole,
     idOpcion:idOpcion
    };

 localStorage.setItem("opcion",JSON.stringify(p))    

  }





  salirSer(){
    
    
   
      this.servicioSalir().subscribe(
        (respuesta: any)=>  this.responseSalir(respuesta)
      )
      
    

  }

  responseSalir(res: any){
      let json = JSON.parse(res);
  
      if(json.ususario != "none"){

        localStorage.setItem("usu",JSON.stringify(json))        
        //this.session = true;
        //this.mensaje = "Bienvenido " + json.usuario;
        alert(json.mensaje);
     //   location.href=json.pagina;
     this.router.navigateByUrl(json.pagina)
      }
  
    }
 

    
    servicioSalir(){
      let httpOptions ={
        Headers: new HttpHeaders({
          'Accept':'txt/html'
        }),responseType:'text' as 'json'
        
      } 
     
     
      
      return this.http.post<any>(this.url.url+'miapp/login/cerrar',this.usuarioMomentaneo,httpOptions).pipe(
        catchError((error) => {
          console.log(error);
          const mensaje =error.error;
          const objetoJSON = JSON.parse(mensaje);
          alert(objetoJSON.mensaje);
          throw error; 
          }))
      }


      direccion(page:string){
        
        
        this.router.navigateByUrl("/"+page)
      
      }
  

}
