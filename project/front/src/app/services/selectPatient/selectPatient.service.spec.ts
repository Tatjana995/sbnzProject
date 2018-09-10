import { TestBed, inject } from '@angular/core/testing';

import { SelectPatientService } from './selectPatient.service';

describe('SelectPatientService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SelectPatientService]
    });
  });

  it('should be created', inject([SelectPatientService], (service: SelectPatientService) => {
    expect(service).toBeTruthy();
  }));
});
