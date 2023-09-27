import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ActualizarPasswordComponent } from './actualizar-password/actualizar-password.component';
import { HomeComponent } from './home/home.component';
import { EmpresaComponent } from './empresa/empresa.component';
import { SucursalComponent } from './sucursal/sucursal.component';
import { GeneroComponent } from './genero/genero.component';
import { EstatusUsuarioComponent } from './estatus-usuario/estatus-usuario.component';
import { RolesComponent } from './roles/roles.component';
import { ModuloComponent } from './modulo/modulo.component';
import { MenuComponent } from './menu/menu.component';
import { OpcionesComponent } from './opciones/opciones.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { AsignarOpcionesComponent } from './asignar-opciones/asignar-opciones.component';
import { AsignarRolesComponent } from './asignar-roles/asignar-roles.component';
import { AgregarPreguntasComponent } from './agregar-preguntas/agregar-preguntas.component';
import { AgregaUsuarioComponent } from './agrega-usuario/agrega-usuario.component';
import { EditarUsuarioComponent } from './editar-usuario/editar-usuario.component';

const routes: Routes = [
  {path:'', component:LoginComponent},
  {path:'actualizarPassword', component:ActualizarPasswordComponent},
  {path:'home',component:HomeComponent},
  {path:'empresa',component:EmpresaComponent},
  {path:'sucursal',component:SucursalComponent},
  {path:'genero',component:GeneroComponent},
  {path:'status_usuario',component:EstatusUsuarioComponent},
  {path:'role',component:RolesComponent},
  {path:'modulo',component:ModuloComponent},
  {path:'menu',component:MenuComponent},
  {path:'opcion',component:OpcionesComponent},
  {path:'usuario',component:UsuariosComponent},
  {path:'asignacion_role_usuario',component:AsignarRolesComponent},
  {path:'asignacion_opcion_role',component:AsignarOpcionesComponent},
  {path:'agregar_preguntas', component:AgregarPreguntasComponent},
  {path:'agregar_usuario',component:AgregaUsuarioComponent},
  {path:'editar_usuario',component:EditarUsuarioComponent}  

  


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
