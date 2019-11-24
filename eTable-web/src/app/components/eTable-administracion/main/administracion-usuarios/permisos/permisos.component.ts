import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PermisosService } from 'src/app/services/administracion/administracion-usuarios/permisos.service';
import { Permiso } from 'src/app/domain/Permiso';
import { Path } from 'src/app/infrastructure/constans/Path';
import { MainMenuService } from 'src/app/services/administracion/sistema/main-menu.service';
import { MenuItem, MenuSubItem } from 'src/app/domain/MainMenu';

@Component({
  selector: 'app-permisos',
  templateUrl: './permisos.component.html',
  styleUrls: ['./permisos.component.css']
})
export class PermisosComponent implements OnInit {

  public listPermisos: Permiso[];
  public permisos: any[];
  public items: MenuItem[];
  public subitems: MenuSubItem[];

  public selectedItemId: number;
  permisosLoad: boolean;
  load: boolean;
  loading: string;
  moduloSelected: boolean;
  onEdit: boolean;

  constructor(private router: Router, private servicePermiso: PermisosService, private serviceMainMenu: MainMenuService) {
    this.load = true;
    this.moduloSelected = false;
    this.selectedItemId = 0;
    this.permisosLoad = false;
    this.loading = Path.loading;
    this.onEdit = false;
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
        this.permisos = data;
      }
    });
  }

  editarPermiso(id: number) {
    localStorage.setItem('permisoId', id.toString());
    this.router.navigate(['usuarios/permisos/editar']);
  }

}
