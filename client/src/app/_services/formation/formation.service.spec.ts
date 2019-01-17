import { TestBed } from '@angular/core/testing';

import { FormationService } from './formation.service';

describe('FormationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FormationService = TestBed.get(FormationService);
    expect(service).toBeTruthy();
  });
});
