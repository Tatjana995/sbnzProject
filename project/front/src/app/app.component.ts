import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoggedUtils } from './utils/logged.utils';
import { Patient } from '../app/model/patient';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'app';

  constructor(private router:Router,private patient:Patient){}

  ngOnInit(){
  }

  isLoggedIn(){
    return !LoggedUtils.isEmpty();
  }

  logout(){
    localStorage.removeItem("loggedUser");
    this.router.navigate(['']);
  }

  getRole(){
    return LoggedUtils.getRole();
  }
}
