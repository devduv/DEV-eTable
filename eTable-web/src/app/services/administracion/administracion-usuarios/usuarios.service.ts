import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { forkJoin, Observable } from 'rxjs';
import { MenuSubItem } from 'src/app/domain/MainMenu';
import { TipoUsuario } from 'src/app/domain/TipoUsuario';
import { TipoUsuarioPermiso } from 'src/app/domain/TipoUsuarioPermiso';
import { Cliente } from 'src/app/domain/Cliente';
import { User } from 'src/app/domain/User';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'etable/api/user';
  }

  public crearUsuario(user: User) {
    return this.http.post<User>(this.url + '/' + 'crearUsuario', user);
  }

  public crearCliente(user: User, cliente: Cliente) {
    return this.http.post<Cliente>(this.url + '/crearCliente', {'user': user, 'cliente': cliente});
  }

  public getUsuarioByAuthentication(user: User) {
    return this.http.post<User>(this.url + '/obtenerUsuario', user);
  }

  public getUsarios() {
    return this.http.get<User[]>(this.url + '/' + 'obtenerUsuarios');
  }
}
