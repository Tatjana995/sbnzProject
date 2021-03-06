import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
import 'rxjs/add/operator/map';
import { User } from '../../model/user'

@Injectable()
export class LoginService {

  constructor(private http:HttpClient) { }

  authenticate(username: string, password: string){
    let authenticationRequest={username: username, password: password};
    let params= JSON.stringify(authenticationRequest); 
    let headers=new HttpHeaders().set('Content-Type','application/json; charset=utf-8');
    return this.http.post("http://localhost:8000/auth",params,
    {
      headers:headers
    }).map(res => res);
  }

  registration(user:User):Observable<string>{
    let params= JSON.stringify(user);
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    return this.http.post<string>("http://localhost:8000/api/user/register",params,{headers:headers});
  }
}
