import { Injectable } from '@angular/core';
import { PerfilMesa } from 'src/app/domain/PerfilMesa';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class PerfilMesasService {
  public perfilMesa: PerfilMesa;
  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'etable/api/perfilMesa';
  }

  getPerfilesMesa() {
    return this.http.get<PerfilMesa[]>(this.url + '/' + 'perfiles');
  }

  actualizarPerfilesMesa(perfil: PerfilMesa) {
    return this.http.put<PerfilMesa>(this.url + '/' + 'actualizarPerfilMesa' + '/' + this.perfilMesa.cperfilmesa, perfil);
  }
}
