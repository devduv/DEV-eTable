import { Component, OnInit } from '@angular/core';
import { Path } from 'src/app/infrastructure/constans/Path';
import { Router } from '@angular/router';
import { TipoUsuario } from 'src/app/domain/TipoUsuario';
import { MenuItem, MenuSubItem } from 'src/app/domain/MainMenu';
import { MainMenuService } from 'src/app/services/administracion/sistema/main-menu.service';
import { PermisosService } from 'src/app/services/administracion/administracion-usuarios/permisos.service';
import { Permiso } from 'src/app/domain/Permiso';
import { UsuariosService } from 'src/app/services/administracion/administracion-usuarios/usuarios.service';
import { TipoUsuarioPermiso } from 'src/app/domain/TipoUsuarioPermiso';

@Component({
  selector: 'app-crear-tipo-usuario',
  templateUrl: './crear-tipo-usuario.component.html',
  styleUrls: ['./crear-tipo-usuario.component.css']
})
export class CrearTipoUsuarioComponent implements OnInit {

  public items: MenuItem[];
  public permisos: any[];
  public listPermisos: any[];
  public permisosSelects: Permiso[];
  public subitems: MenuSubItem[];
  public selectedItemId: number;
  public permisoSelected: boolean[];
  public listTipoUsuarioPermiso: TipoUsuarioPermiso[];

  empty: boolean;
  load: boolean;
  loading: string;
  permisosLoad: boolean;
  moduloSelected: boolean;
  tipousuario: TipoUsuario;
  emptyText: string;
  permisoItemSelected: boolean;

  constructor(
    private router: Router,
    private serviceUsuario: UsuariosService,
    private servicePermiso: PermisosService,
    private serviceMainMenu: MainMenuService) {
    this.load = true;
    this.loading = Path.loading;
    this.selectedItemId = 0;
    this.tipousuario = new TipoUsuario();
    this.permisosSelects = [];
    this.permisos = [];
    this.subitems = [];
    this.emptyText = 'Cargando...';
    this.empty = false;
    this.permisoItemSelected = false;
    this.permisoSelected = [];
    this.listPermisos = [];
  }

  ngOnInit() {
    this.getModuloMenuItems();
  }

  getModuloMenuItems() {
    this.serviceMainMenu.getListMenuItems().subscribe(data => {
      this.load = false;
      if (data.length !== 0) {
        this.items = data;
      }
    });
  }

  getModuloMenuSubItems() {
    if (this.selectedItemId === 0) {
      this.permisosLoad = false;
      this.moduloSelected = false;
    } else {
      this.permisosLoad = false;
      this.moduloSelected = true;
      this.load = true;
      this.permisoSelected = [];
      this.listPermisos = [];
      this.getModuloMenuSubItemsByItem(this.selectedItemId);
    }
  }

  getModuloMenuSubItemsByItem(id: number) {
    this.serviceMainMenu.getListMenuSubItemsByItem(id).subscribe(data => {
      if (data.length !== 0) {
        this.subitems = data;
        this.getPermisosBySubItems(this.subitems);
      }
    });
  }

  getPermisosBySubItems(subitems: MenuSubItem[]) {
    this.servicePermiso.getPermisosBySubItemForkJoin(subitems).subscribe(data => {
      this.load = false;
      if (data.length !== 0) {
        this.permisosLoad = true;
        data.forEach(val => {
          val.forEach(v => {
            v.selected = false;
          });
        });
        this.permisos = data;
        this.setPermisosSelected();
      }

    });
  }

  setPermisosSelected() {
    this.permisos.forEach(val => {
      val.forEach(v => {
        this.permisosSelects.forEach(p => {
          if (p.cpermiso === v.cpermiso) {
            v.selected = true;
          }
        });
      });
    });
  }

  seleccionarPermiso(citem: number) {
    this.permisoItemSelected = !this.permisoItemSelected;
  }

  crearTipoUsuario() {
    if (!this.estaVacio()) {
      this.load = true;
      this.serviceUsuario.crearTipoUsuario(this.tipousuario).subscribe(data => {
        if (data !== null) {
          this.load = false;
          this.tipousuario = data;
          this.asignarPermisosAlTipoUsuario();
        } else {
          this.load = false;
          this.empty = true;
          this.emptyText = 'Nombre de Tipo de usuario ya existe';
        }
      });
    }
  }

  estaVacio() {
    if (this.tipousuario.tiponombre === undefined || this.tipousuario.tiponombre.trim().length === 0) {
      this.empty = true;
      this.emptyText = 'Ingrese nombre del tipo de usuario';
      return true;
    }
    if (this.tipousuario.tipodescripcion === undefined || this.tipousuario.tipodescripcion.trim().length === 0) {
      this.empty = true;
      this.emptyText = 'Ingrese descripción del tipo de usuario';
      return true;
    }
    if (this.permisosSelects.length === 0) {
      this.empty = true;
      this.emptyText = 'Asigne permisos al tipo de usuario';
      return true;
    }
  }

  agregarPermiso(id: number, permiso: Permiso) {
    const index: number = this.permisos[id].indexOf(permiso);
    this.permisos[id].splice(index, 1);
    this.permisosSelects.push(permiso);
  }

  removerPermiso(permiso: Permiso) {
    const index: number = this.permisosSelects.indexOf(permiso);
    this.permisosSelects.splice(index, 1);
  }

  asignarPermisosAlTipoUsuario() {
    this.listTipoUsuarioPermiso = [];
    let tipouspermiso: TipoUsuarioPermiso;
    this.permisosSelects.forEach(value => {
      tipouspermiso = new TipoUsuarioPermiso();
      tipouspermiso.ctipousuario = this.tipousuario.ctipousuario;
      tipouspermiso.cpermiso = value.cpermiso;
      this.listTipoUsuarioPermiso.push(tipouspermiso);
    });
    console.log(this.listTipoUsuarioPermiso);
    this.serviceUsuario.asignarPermisos(this.listTipoUsuarioPermiso).subscribe(data => {
      this.router.navigate(['usuarios/tipos']);
    });
  }
}
