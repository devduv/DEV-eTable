import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from 'src/app/domain/User';
import { Path } from 'src/app/infrastructure/constans/Path';
import { Cliente } from 'src/app/domain/Cliente';
import { TipoUsuario } from 'src/app/domain/TipoUsuario';
import { UsuarioService } from 'src/app/services/administracion/administracion-usuarios/usuarios.service';
import { TipoUsuarioService } from 'src/app/services/administracion/administracion-usuarios/tipo-usuario.service';

@Component({
  selector: 'app-editar-usuario',
  templateUrl: './editar-usuario.component.html',
  styleUrls: ['./editar-usuario.component.css']
})
export class EditarUsuarioComponent implements OnInit {
  public tiposUsuario: TipoUsuario[];
  public id: number;
  public user: User;
  public cliente: Cliente;
  public load: boolean;
  public loading: string;
  public passDiferente: boolean;
  public selectedTypeId: number;
  public esCliente: boolean;
  public passw: string;
  public changePassword: boolean;

  constructor(
    private router: Router,
    private activedRouter: ActivatedRoute,
    private servicesTipoUsuario: TipoUsuarioService,
    private serviceUsuario: UsuarioService) {
      this.load = true;
      this.loading = Path.loading;
      this.passDiferente = false;
      this.user = new User();
      this.cliente = new Cliente();
      this.changePassword = false;
     }

  ngOnInit() {
    this.getTiposUsuario();
    this.getIdUsuario();
  }

  private getIdUsuario() {
    this.activedRouter.params.subscribe(data => {
      if (data.id !== 0) {
        this.id = data.id;
        this.serviceUsuario.getUsuarioById(this.id).subscribe(o => {
          if (o !== null) {
            this.user = o;
            this.selectedTypeId = this.user.ctipousuario;
            this.passw = this.user.password;
          } else {
            this.navigateList();
          }
        });
      } else {
        this.navigateList();
      }
    });
  }

  public selectedTipoUsuario() {
    if (this.selectedTypeId === 2) {
      this.esCliente = true;
    } else {
      this.esCliente = false;
    }
  }

  public guardar() {
    /*this.serviceUsuario.editUserById().subscribe(data => {

    });*/
  }

  public cancelar() {
    this.navigateList();
  }

  private navigateList() {
    this.router.navigate(['usuarios/list']);
  }

  private getTiposUsuario() {
    this.servicesTipoUsuario.getTiposUsuario().subscribe(data => {
      this.tiposUsuario = data;
      this.load = false;
    });
  }

  public newPassword() {
    this.changePassword = true;
    this.user.password = '';
    this.passw = '';
  }
}
