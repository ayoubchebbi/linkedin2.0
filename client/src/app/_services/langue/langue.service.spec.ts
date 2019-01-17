import { TestBed } from '@angular/core/testing';

import { LangueService } from './langue.service';

describe('LangueService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LangueService = TestBed.get(LangueService);
    expect(service).toBeTruthy();
  });
});
