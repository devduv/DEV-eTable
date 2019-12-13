import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Mesa } from 'src/app/domain/Mesa';
import { Cliente } from 'src/app/domain/Cliente';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'etable/api/user';
  }

  public getClientes() {
    return this.http.get<Cliente[]>(this.url + '/' + 'clientes');
  }

}
