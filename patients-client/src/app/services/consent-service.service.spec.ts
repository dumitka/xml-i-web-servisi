import { TestBed } from '@angular/core/testing';

import { ConsentServiceService } from './consent-service.service';

describe('ConsentServiceService', () => {
  let service: ConsentServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConsentServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
