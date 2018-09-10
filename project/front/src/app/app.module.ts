import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClient, HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { ModalModule } from 'ngx-bootstrap/modal';
import { CollapseModule } from 'ngx-bootstrap/collapse';
import { AlertModule } from 'ngx-bootstrap/alert';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from '../app/components/login/login.component';
import { LoginService } from '../app/services/login/login.service';
import { SymptomService } from '../app/services/symptom/symptom.service';
import { TokenInterceptorService } from '../app/services/token-interceptor/token-interceptor.service';
import { PageNotFoundComponent } from '../app/components/page-not-found/page-not-found.component';
import { RegistrationComponent } from '../app/components/registration/registration.component';
import { SymptomComponent } from '../app/components/inputSymptoms/symptom.component';
import { SelectPatientComponent } from '../app/components/selectPatient/selectPatient.component';
import { SelectPatientService } from '../app/services/selectPatient/selectPatient.service';
import { ShowDiagnosisComponent } from '../app/components/showDiagnosis/showDiagnosis.component';
import { MedicineService } from '../app/services/medicine/medicine.service';

import { Patient } from '../app/model/patient';
import { PatientDiseaseMedicine } from '../app/model/patientDiseaseMedicine';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PageNotFoundComponent,
    RegistrationComponent,
    SymptomComponent,
    SelectPatientComponent,
    ShowDiagnosisComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AlertModule.forRoot(),
    ModalModule.forRoot(),
    CollapseModule.forRoot(),
    RouterModule.forRoot(
      [
        { path: '', component: LoginComponent},
        { path: 'not-found', component: PageNotFoundComponent},
        { path: 'register', component: RegistrationComponent},
        { path: 'inputSymptoms', component: SymptomComponent},
        { path: 'selectPatient', component: SelectPatientComponent},
        { path: 'showDiagnosis', component: ShowDiagnosisComponent},
        { path: '**', redirectTo:'not-found'}
      ]
    )
  ],
  providers: [
    LoginService,
    TokenInterceptorService,
    SymptomService,
    Patient,
    PatientDiseaseMedicine,
    SelectPatientService,
    MedicineService,
    HttpClient,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
