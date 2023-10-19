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
import { AgregarEstatusUsuarioComponent } from './agregar-estatus-usuario/agregar-estatus-usuario.component';
import { AgregarSucursalComponent } from './agregar-sucursal/agregar-sucursal.component';
import { EditarPuestoComponent } from './editar-puesto/editar-puesto.component';
import { EditarSucursalComponent } from './editar-sucursal/editar-sucursal.component';
import { PuestoComponent } from './puesto/puesto.component';
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
  {path:'editar_usuario',component:EditarUsuarioComponent},
  {path:'agregar-estatus-usuario',component:AgregarEstatusUsuarioComponent},  
  {path:'agregar-sucursal',component:AgregarSucursalComponent},
  {path:'editar-puesto',component:EditarPuestoComponent},
  {path:'editar-sucursal',component:EditarSucursalComponent},
  {path:'puesto',component:PuestoComponent},
  {path:'agregar-puesto',component:AgregarPuestoComponent},
  {path:'estado_civil',component:EstadoCivilComponent},
  {path:'editar-estado-civil',component:EditarEstadoCivilComponent},
  {path:'agregar-estado-civil',component:AgregarEstadoCivilComponent},
  {path:'editar-estatus-usuario',component:EditarEstatusUsuarioComponent},
  {path:'status_empleado',component:StatusEmpleadoComponent},
  {path:'editar-estatus-empleado',component:EditarEstatusEmpleadoComponent},
  {path:'agregar-estatus-empleado',component:AgregarEstatusEmpleadoComponent},
  {path:'inasistencia',component:InasistenciaComponent},
  {path:'agregar-inasistencia',component:AgregarInasistenciaComponent},
  {path:'editar-inasistencia',component:EditarInasistenciaComponent},
  {path:'flujo_status_empleado',component:FlujoStatusEmpleadoComponent},
  {path:'agregar_flujo_status_empleado',component:AgregarFlujoStatusEmpleadoComponent},
  {path:'editar_flujo_status_empleado',component:EditarFlujoStatusEmpleadoComponent},
  {path:'cuenta_bancaria_empleado',component:CuentaBancariaEmpleadoComponent},
  {path:'agregar_cuenta_bancaria_empleado',component:AgregarCuentaBancariaEmpleadoComponent},
  {path:'editar_cuenta_bancaria_empleado',component:EditarCuentaBancariaEmpleadoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
