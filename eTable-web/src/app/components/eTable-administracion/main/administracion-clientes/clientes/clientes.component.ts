import { Component, OnInit } from '@angular/core';
import { ClientService } from 'src/app/services/administracion/administracion-clientes/clientes.service';
import { Cliente } from 'src/app/domain/Cliente';
import { Router } from '@angular/router';
import { Path } from 'src/app/infrastructure/constans/Path';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  public clientes: Cliente[];
  load: boolean;
  loading: string;

  constructor(private router: Router, private service: ClientService) { 
    this.load = true;
    this.loading = Path.loading;
  }

  ngOnInit() {
    this.getClientes();
  }

  private getClientes() {
    this.service.getClientes().subscribe(data => {
      this.load = false;
      this.clientes = data;
    });
  }

  public editCliente(id: number) {

  }

  public deleteCliente(id: number) {

  }

  public nuevo() {
    this.router.navigate(['clientes/crear']);
  }
}
