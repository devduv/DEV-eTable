import { Component, OnInit, Input, Output } from '@angular/core';
import { Path } from 'src/app/infrastructure/constans/Path';
import { User } from 'src/app/domain/User';
import { EventEmitter } from 'events';
import { UsuarioService } from 'src/app/services/administracion/administracion-usuarios/usuarios.service';
import { Cliente } from 'src/app/domain/Cliente';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']

})
export class RegisterComponent implements OnInit {


  public logo: string;
  public loading: string;
  public load: boolean;

  public cliente: Cliente;
  public user: User;

  constructor(private service: UsuarioService) {
    this.user = new User();
    this.cliente = new Cliente();
    this.load = false;
    this.loading = Path.loading;
    this.logo = Path.logo;
   }

  ngOnInit() {
  }

  public register() {
    console.log(this.cliente, this.user);
    this.user.ctipousuario = 1;
    this.service.crearCliente(this.user, this.cliente).subscribe(o => {
      console.log('Cliente creado');
      this.navigate();
    });
  }

  public backLogin() {
    this.navigate();
  }

  private navigate() {
    localStorage.setItem('registration', 'false')
  }
}
