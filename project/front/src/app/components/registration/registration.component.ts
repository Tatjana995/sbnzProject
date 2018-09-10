import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user';
import { LoginService } from '../../services/login/login.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user:User={
    name:"",
    surname:"",
    username:"",
    password:"",
    repeatedPassword:"",
    role:""
  };

  constructor(private ls:LoginService) { }

  ngOnInit() {
  }

  registerUser(){
    console.log(this.user);
    if(this.user.password!=this.user.repeatedPassword){
      console.log("passwords don't match");
      return;
    }
    this.ls.registration(this.user).subscribe(data=>{console.log(data)});
  }


}
