
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
import { PlanillaComponent } from './planilla/planilla.component';
import { ReportePlanillaComponent } from './reporte-planilla/reporte-planilla.component';
import { DetallePlanillaComponent } from './detalle-planilla/detalle-planilla.component';
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
import { AgregarDepartamentoComponent } from './agregar-departamento/agregar-departamento.component';
import { EditarDepartamentoComponent } from './editar-departamento/editar-departamento.component';
import { EmpleadoComponent } from './empleado/empleado.component';
import { AgregarEmpleadoComponent } from './agregar-empleado/agregar-empleado.component';
import { EditarEmpleadoComponent } from './editar-empleado/editar-empleado.component';
import { DocumentoPersonaComponent } from './documento-persona/documento-persona.component';
import { AgregarDocumentoPersonaComponent } from './agregar-documento-persona/agregar-documento-persona.component';
import { EditarDocumentoPersonaComponent } from './editar-documento-persona/editar-documento-persona.component';
import { PersonaComponent } from './persona/persona.component';
import { AgregarPersonaComponent } from './agregar-persona/agregar-persona.component';
import { EditarPersonaComponent } from './editar-persona/editar-persona.component';
import { TipoDocumentoComponent } from './tipo-documento/tipo-documento.component';
import { AgregarTipoDocumentoComponent } from './agregar-tipo-documento/agregar-tipo-documento.component';
import { EditarTipoDocumentoComponent } from './editar-tipo-documento/editar-tipo-documento.component';
import { CuentaBancariaEmpleadoComponent } from './cuenta-bancaria-empleado/cuenta-bancaria-empleado.component';
import { AgregarCuentaBancariaEmpleadoComponent } from './agregar-cuenta-bancaria-empleado/agregar-cuenta-bancaria-empleado.component';
import { EditarCuentaBancariaEmpleadoComponent } from './editar-cuenta-bancaria-empleado/editar-cuenta-bancaria-empleado.component';
import { EstadoCivilComponent } from './estado-civil/estado-civil.component';
import { AgregarEstadoCivilComponent } from './agregar-estado-civil/agregar-estado-civil.component';
import { EditarEstadoCivilComponent } from './editar-estado-civil/editar-estado-civil.component';
import { FlujoStatusEmpleadoComponent } from './flujo-status-empleado/flujo-status-empleado.component';
import { AgregarFlujoStatusEmpleadoComponent } from './agregar-flujo-status-empleado/agregar-flujo-status-empleado.component';
import { EditarFlujoStatusEmpleadoComponent } from './editar-flujo-status-empleado/editar-flujo-status-empleado.component';
import { InasistenciaComponent } from './inasistencia/inasistencia.component';
import { AgregarInasistenciaComponent } from './agregar-inasistencia/agregar-inasistencia.component';
import { EditarInasistenciaComponent } from './editar-inasistencia/editar-inasistencia.component';
import { PuestoComponent } from './puesto/puesto.component';
import { AgregarPuestoComponent } from './agregar-puesto/agregar-puesto.component';
import { EditarPuestoComponent } from './editar-puesto/editar-puesto.component';
import { StatusEmpleadoComponent } from './status-empleado/status-empleado.component';
import { AgregarEstatusEmpleadoComponent } from './agregar-estatus-empleado/agregar-estatus-empleado.component';
import { EditarEstatusEmpleadoComponent } from './editar-estatus-empleado/editar-estatus-empleado.component';
import { AgregarSucursalComponent } from './agregar-sucursal/agregar-sucursal.component';
import { EditarSucursalComponent } from './editar-sucursal/editar-sucursal.component';


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
  {path:'editar_usuario',component:EditarUsuarioComponent} ,
  {path:'calculo_planilla',component:PlanillaComponent},
  {path:'reporte_planilla',component:ReportePlanillaComponent},
  {path: 'detalle_planilla', component:DetallePlanillaComponent},
  {path:'InserteGenero',component:AgregarGeneroComponent },
  {path: 'editar_genero',component:EditarGeneroComponent},
  {path: 'AgregueAsignarOpciones',component:AgregarAsignarOpcionesComponent},
  {path:'editar_asignaropciones', component: EditarAsignarOpcionesComponent},
  {path: 'AgregueEmpresa', component: AgregarEmpresaComponent},
  {path: 'editar_empresa', component: EditarEmpresaComponent},
  {path: 'agregarAsignarRoles', component: AgregarAsignarRolesComponent},
  {path: 'editar_asignarroles', component: EditarAsignarRolesComponent},
  {path: 'InserteMenu', component: AgregarMenuComponent},
  { path :'editar_menu', component: EditarMenuComponent},
  {path: 'AgregueModulo', component: AgregarModuloComponent},
  {path: 'editar_modulo', component: EditarModuloComponent},
  {path: 'AgregueOpciones', component: AgregarOpcionesComponent},
  {path: 'editar_opciones', component: EditarOpcionesComponent},
  {path: 'AgregueRole', component: AgregarRoleComponent},
  {path: 'editar_roles', component: EditarRoleComponent},
  {path: 'banco', component: BancoComponent},
  {path: 'agregarBanco', component: AgregarBancoComponent},
  {path: 'editar_banco', component: EditarBancoComponent},
{path: 'departamento', component: DepartamentoComponent},
{path: 'agregarDepartamento', component: AgregarDepartamentoComponent},
{path: 'editarDepartamento', component: EditarDepartamentoComponent},
{path: 'empleado', component: EmpleadoComponent},
{path: 'agregarEmpleado', component: AgregarEmpleadoComponent},
{path: 'editarEmpleado', component: EditarEmpleadoComponent},
{path: 'documento_persona', component:DocumentoPersonaComponent},
{path: 'agregarDocumentoPersona', component:AgregarDocumentoPersonaComponent},
{path: 'editarDocumentoPersona', component:EditarDocumentoPersonaComponent},
{path: 'personas',component:PersonaComponent},
{path: 'agregarPersona', component:AgregarPersonaComponent},
{path: 'editarPersona', component:EditarPersonaComponent},
{path: 'tipos_documento', component:TipoDocumentoComponent},
{path: 'agregarTipoDocumento',component:AgregarTipoDocumentoComponent},
{path: 'editarTipoDocumento', component:EditarTipoDocumentoComponent},
{path:'cuenta_bancaria_empleado',component:CuentaBancariaEmpleadoComponent},
{path:'agregar_cuenta_bancaria_empleado',component:AgregarCuentaBancariaEmpleadoComponent},
{path:'editar_cuenta_bancaria_empleado',component:EditarCuentaBancariaEmpleadoComponent},
{path:'estado_civil',component:EstadoCivilComponent},
{path:'agregar-estado-civil',component:AgregarEstadoCivilComponent},
{path:'editar-estado-civil',component:EditarEstadoCivilComponent},
{path:'flujo_status_empleado',component:FlujoStatusEmpleadoComponent},
{path:'agregar_flujo_status_empleado',component:AgregarFlujoStatusEmpleadoComponent},
{path:'editar_flujo_status_empleado',component:EditarFlujoStatusEmpleadoComponent},
{path:'inasistencia',component:InasistenciaComponent},
{path:'agregar-inasistencia',component:AgregarInasistenciaComponent},
{path:'editar-inasistencia',component:EditarInasistenciaComponent},
{path:'puesto',component:PuestoComponent},
{path:'agregar-puesto',component:AgregarPuestoComponent},
{path:'editar-puesto',component:EditarPuestoComponent},
{path:'status_empleado',component:StatusEmpleadoComponent},
{path:'agregar-estatus-empleado',component:AgregarEstatusEmpleadoComponent},
{path:'editar-estatus-empleado',component:EditarEstatusEmpleadoComponent},
{path:'agregar-sucursal',component:AgregarSucursalComponent},
{path:'editar-sucursal',component:EditarSucursalComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
