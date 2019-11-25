import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { forkJoin, Observable } from 'rxjs';
import { MenuSubItem } from 'src/app/domain/MainMenu';
import { TipoUsuario } from 'src/app/domain/TipoUsuario';
import { TipoUsuarioPermiso } from 'src/app/domain/TipoUsuarioPermiso';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'etable/api/usuarios';
  }

  getTiposUsuario() {
    return this.http.get<TipoUsuario[]>(this.url + '/' + 'tipoUsuario' + '/' + 'list');
  }

   /* getPermisosBySubItemForkJoin(subitems: MenuSubItem[]): Observable<any[]> {
    const obs = [];
    subitems.forEach(value => {
      obs.push(this.http.get<Permiso[]>(this.url + '/' + 'permisosBySubItem' + '/' + value.csubitem));
    });
    return forkJoin(obs);
  } */

  actualizarTipoUsuario(tipoUsuario: TipoUsuario) {
    return this.http.put<TipoUsuario>(this.url + '/' + 'tipoUsuario' + '/' + 'editarTipoUsuario', tipoUsuario);
  }

  getTipoUsuarioById(id: number) {
    return this.http.get<TipoUsuario>(this.url + '/' + 'tipoUsuario' + '/' + id);
  }

  crearTipoUsuario(tipoUsuario: TipoUsuario) {
    return this.http.post<TipoUsuario>(this.url + '/' + 'tipoUsuario' + '/' + 'agregarTipoUsuario', tipoUsuario);
  }

  asignarPermisos(tipouspermisos: TipoUsuarioPermiso[]) {
    return this.http.post<boolean>(this.url + '/' + 'tipoUsuarioPermiso' + '/' +
    'asignarPermisos', tipouspermisos);
  }
}
