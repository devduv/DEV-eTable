import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Mesa } from 'src/app/domain/Mesa';

@Injectable({
  providedIn: 'root'
})
export class MesasService {

  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'etable/api/mainMesa';
  }

  getMesas() {
    return this.http.get<Mesa[]>(this.url + '/' + 'listMesas');
  }

  


}
