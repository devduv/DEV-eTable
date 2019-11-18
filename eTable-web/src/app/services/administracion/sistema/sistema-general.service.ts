import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Configuracion } from 'src/app/domain/Configuracion';

@Injectable({
  providedIn: 'root'
})
export class SistemaGeneralService {

  public configuracion: Configuracion;
  public url: string;

  constructor(private http: HttpClient) {
    this.url = 'etable/api/configuracion';
  }

  getConfiguracionSistemaGeneral() {
    return this.http.get<Configuracion>(this.url + '/' + 'configuracionSistema');
  }
}
