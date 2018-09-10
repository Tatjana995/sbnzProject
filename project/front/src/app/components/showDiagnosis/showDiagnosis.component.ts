import { Component, OnInit } from '@angular/core';
import { Patient } from 'src/app/model/patient';
import { PatientDiseaseMedicine } from 'src/app/model/patientDiseaseMedicine';
import { Medicine } from '../../model/medicine';
import { MedicineService } from '../../services/medicine/medicine.service';

@Component({
  selector: 'app-showDiagnosis',
  templateUrl: './showDiagnosis.component.html',
  styleUrls: ['./showDiagnosis.component.css']
})
export class ShowDiagnosisComponent implements OnInit {

    medicines:Medicine[] = []

    constructor(private ms: MedicineService, private patient: Patient, private patientDiseaseMedicine: PatientDiseaseMedicine) {
        
    }

    ngOnInit() {
        this.getAllMedicines();
    }

    getAllMedicines(){
        this.ms.getMedicines().subscribe( data => { this.medicines = data
            alert(this.medicines[0].group_med);
        });
    }

}
