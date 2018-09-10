import { Symptom } from '../model/symptom';
import { Patient } from 'src/app/model/patient';

export interface FindDiseaseDTO{
    symptoms:Symptom[],
    patient:Patient
}