import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
import { FindDiseaseDTO } from '../../model/findDiseaseDTO';
import { PatientDiseaseMedicine } from 'src/app/model/patientDiseaseMedicine';
import { Medicine } from '../../model/medicine';

@Injectable()
export class MedicineService {

  constructor(private http:HttpClient) { }

  getMedicines():Observable<Medicine[]>{
    let headers:HttpHeaders = new HttpHeaders({'Content-Type':'application/json;charset=utf-8'});
    return this.http.get<Medicine[]>("http://localhost:8000/api/medicine/getAll",
    {headers:headers});
  }

}