import { Component, OnInit } from '@angular/core';
import { Symptom } from '../../model/symptom';
import { SymptomService } from '../../services/symptom/symptom.service';
import { angularMath } from 'angular-ts-math';
import { Disease } from 'src/app/model/disease';
import { Patient } from 'src/app/model/patient';
import { FindDiseaseDTO } from '../../model/findDiseaseDTO';
import { Router } from '@angular/router';
import { PatientDiseaseMedicine } from 'src/app/model/patientDiseaseMedicine';

@Component({
  selector: 'app-inputSymptoms',
  templateUrl: './symptom.component.html',
  styleUrls: ['./symptom.component.css']
})
export class SymptomComponent implements OnInit {

  symptoms:Symptom[]=[];
  rowNum:number = 0;
  numbers:number[] = [];
  lastNums:number[] = [];
  selected:Symptom[] = [];
  checked:boolean[] = [];
  dis:PatientDiseaseMedicine = null;
  temperature:number = 0;

  findDiseaseDTO:FindDiseaseDTO={
      symptoms:[],
      patient:null
  };

  public patName:string = "";

  constructor(private ss:SymptomService,private patientDiseaseMedicine: PatientDiseaseMedicine, private patient: Patient,private router:Router) {
      this.patName = patient.name;
   }

  ngOnInit() {
      this.getAllSymptoms();
      this.findDiseaseDTO.patient = this.patient;
      //alert(this.patient.doctor.username);
  }

  getAllSymptoms(){
    this.ss.getSymptoms().subscribe( 
        data => {this.symptoms = data
            var temp = (this.symptoms.length / 3).toFixed(0);
            this.rowNum = parseInt(temp);
            console.log(this.rowNum);
            var i = 0
            for(i = 0; i < this.rowNum; i++){
                this.numbers.push(i);
            }
            for(i = (this.rowNum + this.rowNum); i < this.symptoms.length; i++){
                this.lastNums.push(i);
            }
            console.log(this.numbers);
            this.checked.fill(false,0, this.symptoms.length);
            console.log(this.checked);
        });
  }

  submitSymptoms(){
      //alert("usao");
      var i = 0;
      for(i = 0; i < this.checked.length; i++){
          if(this.checked[i] == true){
            this.findDiseaseDTO.symptoms.push(this.symptoms[i]);
          }
      }
      alert(this.findDiseaseDTO.symptoms.length);
      //this.findDiseaseDTO.symptoms = this.selected;
      this.ss.findDisease(this.findDiseaseDTO, this.temperature).subscribe( 
        data => {this.dis = data
            this.patientDiseaseMedicine.disease = this.dis.disease;
            alert(this.temperature);
            this.router.navigate(['showDiagnosis/']);
        })
      console.log(this.selected);
      
  }

}
