import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login/login.service';
import { Router } from '@angular/router';
import { LoggedUtils } from '../../utils/logged.utils';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:string;
  password:string;

  constructor(private ls: LoginService, private router:Router) {
    this.username="";
    this.password="";
   }

  ngOnInit() {
  }

  login(){

    this.ls.authenticate(this.username,this.password).subscribe(
      data=>{ 
        localStorage.setItem("loggedUser",JSON.stringify(data));
        if(LoggedUtils.getRole()=="ADMINISTRATOR"){
          this.router.navigate(['/**/']);
        }else if(LoggedUtils.getRole()=="DOCTOR"){
          this.router.navigate(['selectPatient/']);
        }
        this.username="";
        this.password="";
      }
    );

  }

}
