import { PatientDiseaseMedicine } from '../model/patientDiseaseMedicine';
import { Alergie } from '../model/alergie';

export interface PatientChart{
    id:any,
    history:PatientDiseaseMedicine[],
    alergies:Alergie[]
}