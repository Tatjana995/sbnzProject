import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
import { Patient } from 'src/app/model/patient';
import { PatientSearchDTO } from '../../model/patientSearchDTO';

@Injectable()
export class SelectPatientService {

  constructor(private http:HttpClient) { }

  getPatientByID(id:number): Observable<Patient>{
    let headers:HttpHeaders = new HttpHeaders({'Content-Type':'application/json;charset=utf-8'});
    return this.http.get<Patient>("http://localhost:8000/api/patient/getById"+`/${id}`,
    {headers:headers}).map(res => res);
  }

  getAllPatients():Observable<Patient[]>{
    let headers:HttpHeaders = new HttpHeaders({'Content-Type':'application/json;charset=utf-8'});
    return this.http.get<Patient[]>("http://localhost:8000/api/patient/getAll",{headers:headers});
  }

  getPatientByName(name:string):Observable<Patient[]>{
    let headers:HttpHeaders = new HttpHeaders({'Content-Type':'application/json;charset=utf-8'});
    return this.http.get<Patient[]>("http://localhost:8000/api/patient/getByName"+`/${name}`,
    {headers:headers}).map(res => res);
  }

  getPatientBySurname(surname:string):Observable<Patient[]>{
    let headers:HttpHeaders = new HttpHeaders({'Content-Type':'application/json;charset=utf-8'});
    return this.http.get<Patient[]>("http://localhost:8000/api/patient/getBySurname"+`/${surname}`,
    {headers:headers}).map(res => res);
  }

  getPatientByNameAndSurname(psd:PatientSearchDTO):Observable<Patient[]>{
    let params= JSON.stringify(psd);
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    return this.http.post<Patient[]>("http://localhost:8000/api/patient/getByNameAndSurname",params,{headers:headers});
  }

}