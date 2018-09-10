import { Disease } from '../model/disease';
import { Medicine } from '../model/medicine';
import { Injectable } from '@angular/core';

@Injectable()
export class PatientDiseaseMedicine{
    id:any;
    disease:Disease;
    medicine:Medicine;
    tdate:Date;
}