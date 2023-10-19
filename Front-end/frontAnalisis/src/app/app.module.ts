import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
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
import { AsignarRolesComponent } from './asignar-roles/asignar-roles.component';
import { AsignarOpcionesComponent } from './asignar-opciones/asignar-opciones.component';
import { AgregarPreguntasComponent } from './agregar-preguntas/agregar-preguntas.component';
import { AgregaUsuarioComponent } from './agrega-usuario/agrega-usuario.component';
import { EditarUsuarioComponent } from './editar-usuario/editar-usuario.component';
import { PlanillaComponent } from './planilla/planilla.component';
import { ReportePlanillaComponent } from './reporte-planilla/reporte-planilla.component';
import { DetallePlanillaComponent } from './detalle-planilla/detalle-planilla.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ActualizarPasswordComponent,
    HomeComponent,
    EmpresaComponent,
    SucursalComponent,
    GeneroComponent,
    EstatusUsuarioComponent,
    RolesComponent,
    ModuloComponent,
    MenuComponent,
    OpcionesComponent,
    UsuariosComponent,
    AsignarRolesComponent,
    AsignarOpcionesComponent,
    AgregarPreguntasComponent,
    AgregaUsuarioComponent,
    EditarUsuarioComponent,
    PlanillaComponent,
    ReportePlanillaComponent,
    DetallePlanillaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
