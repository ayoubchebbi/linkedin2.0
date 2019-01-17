import { TestBed } from '@angular/core/testing';

import { JAimeService } from './j-aime.service';

describe('JAimeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: JAimeService = TestBed.get(JAimeService);
    expect(service).toBeTruthy();
  });
});
