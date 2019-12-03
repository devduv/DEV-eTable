import { Component, OnInit, Input, Output } from '@angular/core';
import { Path } from 'src/app/infrastructure/constans/Path';
import { User } from 'src/app/domain/User';
import { EventEmitter } from 'events';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']

})
export class RegisterComponent implements OnInit {


  public logo: string;
  public loading: string;
  public load: boolean;
  public user: User;
  public n: string;

  constructor() {
    this.user = new User();
    this.load = false;
    this.loading = Path.loading;
    this.logo = Path.logo;
   }

  ngOnInit() {
  }

  public register() {
   localStorage.setItem('registration', 'false');
  }
}
