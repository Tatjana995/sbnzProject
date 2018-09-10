import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { PatientChart } from '../model/patientChart';

@Injectable()
export class Patient {
    id:any;
    name:string;
    surname:string;
    doctor:User;
    patientChart:PatientChart;
}