import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MatListModule} from '@angular/material/list';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/eTable-autenticacion/login/login.component';
import { UsuariosComponent } from './components/eTable-administracion/main/administracion-usuarios/usuarios/usuarios.component';
import { MainComponent } from './components/eTable-administracion/main/main.component';

// tslint:disable-next-line: max-line-length
import { CrearUsuarioComponent } from './components/eTable-administracion/main/administracion-usuarios/usuarios/crear-usuario/crear-usuario.component';
import { GeneralComponent } from './components/eTable-administracion/main/administracion-sistema/general/general.component';
import { ConfiguracionComponent } from './components/eTable-administracion/main/administracion-sistema/configuracion/configuracion.component';
import { RolesComponent } from './components/eTable-administracion/main/administracion-usuarios/roles/roles.component';
import { PermisosComponent } from './components/eTable-administracion/main/administracion-usuarios/permisos/permisos.component';
import { MesasComponent } from './components/eTable-administracion/main/administracion-mesas/mesas/mesas.component';
import { PerfilMesaComponent } from './components/eTable-administracion/main/administracion-mesas/perfil-mesa/perfil-mesa.component';
import { ProgramacionMesaComponent } from './components/eTable-administracion/main/administracion-mesas/programacion-mesa/programacion-mesa.component';
import { ClientesComponent } from './components/eTable-administracion/main/administracion-clientes/clientes/clientes.component';
import { TipoClientesComponent } from './components/eTable-administracion/main/administracion-clientes/tipo-clientes/tipo-clientes.component';
import { HistorialClienteComponent } from './components/eTable-administracion/main/administracion-clientes/historial-cliente/historial-cliente.component';
import { ReservacionesComponent } from './components/eTable-administracion/main/dashboard/reservaciones/reservaciones.component';
import { ImportarExportarComponent } from './components/eTable-administracion/main/reportes/importar-exportar/importar-exportar.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'sistema/general', component: GeneralComponent},
  { path: 'sistema/configuracion', component: ConfiguracionComponent},

  { path: 'usuarios/roles', component: RolesComponent},
  { path: 'usuarios/permisos', component: PermisosComponent},
  { path: 'usuarios/list', component: UsuariosComponent},
  { path: 'usuarios/crear', component: CrearUsuarioComponent},

  { path: 'mesas/list', component: MesasComponent},
  { path: 'mesas/perfiles', component: PerfilMesaComponent},
  { path: 'mesas/programacion', component: ProgramacionMesaComponent},

  { path: 'clientes/list', component: ClientesComponent},
  { path: 'clientes/tipos', component: TipoClientesComponent},
  { path: 'clientes/historial', component: HistorialClienteComponent},

  { path: 'dashboard/reservaciones', component: ReservacionesComponent},

  { path: 'reportes/importar-exportar', component: ImportarExportarComponent},
  { path: 'main', component: MainComponent}

];

@NgModule({
  imports: [BrowserAnimationsModule, RouterModule.forRoot(routes, {useHash: true}), MatSidenavModule],
  exports: [RouterModule,
    MatListModule,
    MatSidenavModule,
    MatToolbarModule]
})
export class AppRoutingModule { }
