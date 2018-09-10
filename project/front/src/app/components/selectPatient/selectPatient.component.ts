import { Component, OnInit, TemplateRef, ElementRef, ViewChild } from '@angular/core';
import { Patient } from '../../model/patient';
import { PatientSearchDTO } from '../../model/patientSearchDTO';
import { SelectPatientService } from '../../services/selectPatient/selectPatient.service';
import { Router } from '@angular/router';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';

@Component({
  selector: 'app-selectPatient',
  templateUrl: './selectPatient.component.html',
  styleUrls: ['./selectPatient.component.css']
})
export class SelectPatientComponent implements OnInit {
    modalRef: BsModalRef;
    @ViewChild('openModal') openModal:ElementRef;

    public isCollapsedID = false;
    public isCollapsedNameAndSurname = true;

    public patients:Patient[] = [];

    patientSearchDTO:PatientSearchDTO={
        name:"",
        surname:""
    };

    public patientID:number;

    constructor(private patient : Patient, private sp: SelectPatientService,private router:Router,private modalService: BsModalService) { 
        
    }

    getAllPatients(){
        this.sp.getAllPatients().subscribe(data => { this.patients = data});
    }

    ngOnInit() {
        this.openModal.nativeElement.click();
        this.getAllPatients();
    }

    selectPatient(i){
        alert(this.patients[i].name);
        this.patient.id = this.patients[i].id
        this.patient.name = this.patients[i].name;
        this.patient.surname = this.patients[i].surname;
        this.patient.doctor = this.patients[i].doctor;
        this.patient.patientChart = this.patients[i].patientChart;
        //set this.patient as selected and redirect to patient profile
    }

    searchById(){
        this.sp.getPatientByID(this.patientID).subscribe(data => {
            this.patients = []
            this.patients.push(data);
        });
    }

    searchByNameAndSurname(){
        //alert("Searching by name and surname");
        if(this.patientSearchDTO.name != "" && this.patientSearchDTO.surname == ""){
            //alert("ime");
            this.sp.getPatientByName(this.patientSearchDTO.name).subscribe(data => {
                this.patients = data;
            });
        }else if(this.patientSearchDTO.surname != "" && this.patientSearchDTO.name == ""){
            //alert("prezime");
            this.sp.getPatientBySurname(this.patientSearchDTO.surname).subscribe(data => {
                this.patients = data;
            });
        }else if(this.patientSearchDTO.name != "" && this.patientSearchDTO.surname != ""){
            //alert("oba");
            this.sp.getPatientByNameAndSurname(this.patientSearchDTO).subscribe(data => {
                this.patients = data;
            });
        }
    }

    CollapsedNameAndSurname(){
        this.isCollapsedID = true;
        this.isCollapsedNameAndSurname = false;
    }

    CollapsedID(){
        this.isCollapsedID = false;
        this.isCollapsedNameAndSurname = true;
    }

}
