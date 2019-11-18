import { TestBed } from '@angular/core/testing';

import { SistemaGeneralService } from './sistema-general.service';

describe('SistemaGeneralService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SistemaGeneralService = TestBed.get(SistemaGeneralService);
    expect(service).toBeTruthy();
  });
});
