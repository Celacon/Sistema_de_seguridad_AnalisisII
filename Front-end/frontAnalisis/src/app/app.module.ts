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
import { AgregarGeneroComponent } from './agregar-genero/agregar-genero.component';
import { EditarGeneroComponent } from './editar-genero/editar-genero.component';
import { AgregarAsignarOpcionesComponent } from './agregar-asignar-opciones/agregar-asignar-opciones.component';
import { EditarAsignarOpcionesComponent } from './editar-asignar-opciones/editar-asignar-opciones.component';
import { AgregarEmpresaComponent } from './agregar-empresa/agregar-empresa.component';
import { EditarEmpresaComponent } from './editar-empresa/editar-empresa.component';
import { AgregarAsignarRolesComponent } from './agregar-asignar-roles/agregar-asignar-roles.component';
import { EditarAsignarRolesComponent } from './editar-asignar-roles/editar-asignar-roles.component';
import { AgregarMenuComponent } from './agregar-menu/agregar-menu.component';
import { EditarMenuComponent } from './editar-menu/editar-menu.component';
import { AgregarModuloComponent } from './agregar-modulo/agregar-modulo.component';
import { EditarModuloComponent } from './editar-modulo/editar-modulo.component';
import { AgregarOpcionesComponent } from './agregar-opciones/agregar-opciones.component';
import { EditarOpcionesComponent } from './editar-opciones/editar-opciones.component';
import { AgregarRoleComponent } from './agregar-role/agregar-role.component';
import { EditarRoleComponent } from './editar-role/editar-role.component';
import { BancoComponent } from './banco/banco.component';
import { AgregarBancoComponent } from './agregar-banco/agregar-banco.component';
import { EditarBancoComponent } from './editar-banco/editar-banco.component';
import { DepartamentoComponent } from './departamento/departamento.component';
import { EditarDepartamentoComponent } from './editar-departamento/editar-departamento.component';
import { AgregarDepartamentoComponent } from './agregar-departamento/agregar-departamento.component';
import { EmpleadoComponent } from './empleado/empleado.component';
import { AgregarEmpleadoComponent } from './agregar-empleado/agregar-empleado.component';
import { EditarEmpleadoComponent } from './editar-empleado/editar-empleado.component';
import { DocumentoPersonaComponent } from './documento-persona/documento-persona.component';
import { AgregarDocumentoPersonaComponent } from './agregar-documento-persona/agregar-documento-persona.component';
import { EditarDocumentoPersonaComponent } from './editar-documento-persona/editar-documento-persona.component';
import { PersonaComponent } from './persona/persona.component';
import { EditarPersonaComponent } from './editar-persona/editar-persona.component';
import { AgregarPersonaComponent } from './agregar-persona/agregar-persona.component';
import { TipoDocumentoComponent } from './tipo-documento/tipo-documento.component';
import { AgregarTipoDocumentoComponent } from './agregar-tipo-documento/agregar-tipo-documento.component';
import { EditarTipoDocumentoComponent } from './editar-tipo-documento/editar-tipo-documento.component';
import { CommonModule } from '@angular/common';
import { ReportePlanilla2Component } from './reporte-planilla2/reporte-planilla2.component';
import { ReportePlanillaComponent } from './reporte-planilla/reporte-planilla.component';
import { DetallePlanillaComponent } from './detalle-planilla/detalle-planilla.component';
import { PlanillaComponent } from './planilla/planilla.component';
import { EditarEstatusUsuarioComponent } from './editar-estatus-usuario/editar-estatus-usuario.component';
import { AgregarEstatusUsuarioComponent } from './agregar-estatus-usuario/agregar-estatus-usuario.component';
import { AgregarCuentaBancariaEmpleadoComponent } from './agregar-cuenta-bancaria-empleado/agregar-cuenta-bancaria-empleado.component';
import { AgregarEstadoCivilComponent } from './agregar-estado-civil/agregar-estado-civil.component';
import { AgregarEstatusEmpleadoComponent } from './agregar-estatus-empleado/agregar-estatus-empleado.component';
import { AgregarFlujoStatusEmpleadoComponent } from './agregar-flujo-status-empleado/agregar-flujo-status-empleado.component';
import { EditarFlujoStatusEmpleadoComponent } from './editar-flujo-status-empleado/editar-flujo-status-empleado.component';
import { AgregarInasistenciaComponent } from './agregar-inasistencia/agregar-inasistencia.component';
import { AgregarSucursalComponent } from './agregar-sucursal/agregar-sucursal.component';
import { CuentaBancariaEmpleadoComponent } from './cuenta-bancaria-empleado/cuenta-bancaria-empleado.component';
import { EditarCuentaBancariaEmpleadoComponent } from './editar-cuenta-bancaria-empleado/editar-cuenta-bancaria-empleado.component';
import { EditarEstadoCivilComponent } from './editar-estado-civil/editar-estado-civil.component';
import { EditarEstatusEmpleadoComponent } from './editar-estatus-empleado/editar-estatus-empleado.component';
import { EditarInasistenciaComponent } from './editar-inasistencia/editar-inasistencia.component';
import { PuestoComponent } from './puesto/puesto.component';
import { AgregarPuestoComponent } from './agregar-puesto/agregar-puesto.component';
import { EditarPuestoComponent } from './editar-puesto/editar-puesto.component';
import { EditarSucursalComponent } from './editar-sucursal/editar-sucursal.component';
import { FlujoStatusEmpleadoComponent } from './flujo-status-empleado/flujo-status-empleado.component';
import { StatusEmpleadoComponent } from './status-empleado/status-empleado.component';
import { EstadoCivilComponent } from './estado-civil/estado-civil.component';
import { InasistenciaComponent } from './inasistencia/inasistencia.component';

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
    AgregarGeneroComponent,
    EditarGeneroComponent,
    AgregarAsignarOpcionesComponent,
    EditarAsignarOpcionesComponent,
    AgregarEmpresaComponent,
    EditarEmpresaComponent,
    AgregarAsignarRolesComponent,
    EditarAsignarRolesComponent,
    AgregarMenuComponent,
    EditarMenuComponent,
    AgregarModuloComponent,
    EditarModuloComponent,
    AgregarOpcionesComponent,
    EditarOpcionesComponent,
    AgregarRoleComponent,
    EditarRoleComponent,
    BancoComponent,
    AgregarBancoComponent,
    EditarBancoComponent,
    DepartamentoComponent,
    EditarDepartamentoComponent,
    AgregarDepartamentoComponent,
    EmpleadoComponent,
    AgregarEmpleadoComponent,
    EditarEmpleadoComponent,
    DocumentoPersonaComponent,
    AgregarDocumentoPersonaComponent,
    EditarDocumentoPersonaComponent,
    PersonaComponent,
    EditarPersonaComponent,
    AgregarPersonaComponent,
    TipoDocumentoComponent,
    AgregarTipoDocumentoComponent,
    EditarTipoDocumentoComponent,
    ReportePlanilla2Component,
    ReportePlanillaComponent,
    DetallePlanillaComponent, 
    PlanillaComponent,
    EditarEstatusUsuarioComponent,
    AgregarEstatusUsuarioComponent,
    AgregarCuentaBancariaEmpleadoComponent,
    AgregarEstadoCivilComponent,
    AgregarEstatusEmpleadoComponent,
    AgregarFlujoStatusEmpleadoComponent,
    EditarFlujoStatusEmpleadoComponent,
    AgregarInasistenciaComponent,
    AgregarSucursalComponent,
    CuentaBancariaEmpleadoComponent,
    EditarCuentaBancariaEmpleadoComponent,
    EditarEstadoCivilComponent,
    EditarEstatusEmpleadoComponent,
    EditarInasistenciaComponent,
    EditarPuestoComponent,
    EditarSucursalComponent,
    FlujoStatusEmpleadoComponent,
    StatusEmpleadoComponent,
    PuestoComponent,
    AgregarPuestoComponent,
    EstadoCivilComponent,
    InasistenciaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
