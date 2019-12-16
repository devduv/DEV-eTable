import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Reservacion } from 'src/app/domain/Reservacion';
import { Cliente } from 'src/app/domain/Cliente';

@Injectable({
  providedIn: 'root'
})
export class ReservacionService {

  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'etable/api/reservacion';
  }

  public crearReservacion(reservacion: Reservacion) {
 
    return this.http.post<Reservacion>(this.url + '/' + 'crearReservacion', reservacion);
  }
  public obtenerClientebyUsuario(id: number) {
    console.log("llego2");
    return this.http.get<Cliente>(this.url + '/' + 'obtenerClientebyUsuario' + '/' + id);
  }
 


}
