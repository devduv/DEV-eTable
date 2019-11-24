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

  actualizarConfiguracionSistemaGeneral(configuracion: Configuracion) {
    return this.http.put<Configuracion>(this.url + '/' + 'actualizarConfiguracion' + '/' + configuracion.cconfiguracion, configuracion);
  }

  getConfiguracionParametros() {
    return this.http.get<Configuracion>(this.url + '/' + 'configuracionParametros');
  }

  actualizarParametrosSistemaGeneral(configuracion: Configuracion) {
    return this.http.post<Configuracion>(this.url + '/' + 'actualizarParametros' + '/' + configuracion.cconfiguracion, configuracion);
  }

}
