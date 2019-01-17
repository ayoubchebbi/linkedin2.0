import { TestBed } from '@angular/core/testing';

import { OffreEmploiService } from './offre-emploi.service';

describe('OffreEmploiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OffreEmploiService = TestBed.get(OffreEmploiService);
    expect(service).toBeTruthy();
  });
});
