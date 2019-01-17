import { TestBed } from '@angular/core/testing';

import { OffreUtilisateurService } from './offre-utilisateur.service';

describe('OffreUtilisateurService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OffreUtilisateurService = TestBed.get(OffreUtilisateurService);
    expect(service).toBeTruthy();
  });
});
