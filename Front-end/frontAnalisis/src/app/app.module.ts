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
import { EditarSucursalComponent } from './editar-sucursal/editar-sucursal.component';
import { AgregarSucursalComponent } from './agregar-sucursal/agregar-sucursal.component';
import { AgregarEstatusUsuarioComponent } from './agregar-estatus-usuario/agregar-estatus-usuario.component';
import { PuestoComponent } from './puesto/puesto.component';
import { EditarPuestoComponent } from './editar-puesto/editar-puesto.component';
import { AgregarPuestoComponent } from './agregar-puesto/agregar-puesto.component';
import { EstadoCivilComponent } from './estado-civil/estado-civil.component';
import { EditarEstadoCivilComponent } from './editar-estado-civil/editar-estado-civil.component';
import { AgregarEstadoCivilComponent } from './agregar-estado-civil/agregar-estado-civil.component';
import { EditarEstatusUsuarioComponent } from './editar-estatus-usuario/editar-estatus-usuario.component';
import { StatusEmpleadoComponent } from './status-empleado/status-empleado.component';
import { EditarEstatusEmpleadoComponent } from './editar-estatus-empleado/editar-estatus-empleado.component';
import { AgregarEstatusEmpleadoComponent } from './agregar-estatus-empleado/agregar-estatus-empleado.component';
import { InasistenciaComponent } from './inasistencia/inasistencia.component';
import { AgregarInasistenciaComponent } from './agregar-inasistencia/agregar-inasistencia.component';
import { EditarInasistenciaComponent } from './editar-inasistencia/editar-inasistencia.component';
import { FlujoStatusEmpleadoComponent } from './flujo-status-empleado/flujo-status-empleado.component';
import { AgregarFlujoStatusEmpleadoComponent } from './agregar-flujo-status-empleado/agregar-flujo-status-empleado.component';
import { EditarFlujoStatusEmpleadoComponent } from './editar-flujo-status-empleado/editar-flujo-status-empleado.component';
import { CuentaBancariaEmpleadoComponent } from './cuenta-bancaria-empleado/cuenta-bancaria-empleado.component';
import { AgregarCuentaBancariaEmpleadoComponent } from './agregar-cuenta-bancaria-empleado/agregar-cuenta-bancaria-empleado.component';
import { EditarCuentaBancariaEmpleadoComponent } from './editar-cuenta-bancaria-empleado/editar-cuenta-bancaria-empleado.component';

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
    EditarSucursalComponent,
    AgregarSucursalComponent,
    AgregarEstatusUsuarioComponent,
    PuestoComponent,
    EditarPuestoComponent,
    AgregarPuestoComponent,
    EstadoCivilComponent,
    EditarEstadoCivilComponent,
    AgregarEstadoCivilComponent,
    EditarEstatusUsuarioComponent,
    StatusEmpleadoComponent,
    EditarEstatusEmpleadoComponent,
    AgregarEstatusEmpleadoComponent,
    InasistenciaComponent,
    AgregarInasistenciaComponent,
    EditarInasistenciaComponent,
    FlujoStatusEmpleadoComponent,
    AgregarFlujoStatusEmpleadoComponent,
    EditarFlujoStatusEmpleadoComponent,
    CuentaBancariaEmpleadoComponent,
    AgregarCuentaBancariaEmpleadoComponent,
    EditarCuentaBancariaEmpleadoComponent
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
