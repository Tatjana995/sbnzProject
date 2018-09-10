import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
import { Symptom } from '../../model/symptom';
import { Disease } from '../../model/disease';
import { FindDiseaseDTO } from '../../model/findDiseaseDTO';
import { PatientDiseaseMedicine } from 'src/app/model/patientDiseaseMedicine';

@Injectable()
export class SymptomService {

  constructor(private http:HttpClient) { }

  getSymptoms():Observable<Symptom[]>{
    let headers:HttpHeaders = new HttpHeaders({'Content-Type':'application/json;charset=utf-8'});
    return this.http.get<Symptom[]>("http://localhost:8000/api/symptom/getAll",
    {headers:headers});
  }

  findDisease(findDiseaseDTO:FindDiseaseDTO, temp: number): Observable<PatientDiseaseMedicine> {
    let param = JSON.stringify(findDiseaseDTO);
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    return this.http.post<PatientDiseaseMedicine>("http://localhost:8000/api/disease/find"+`/${temp}`, param, {headers:headers})    
  }

}