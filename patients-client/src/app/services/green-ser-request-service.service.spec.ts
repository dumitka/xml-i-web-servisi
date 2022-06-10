import { TestBed } from '@angular/core/testing';

import { GreenSerRequestServiceService } from './green-ser-request-service.service';

describe('GreenSerRequestServiceService', () => {
  let service: GreenSerRequestServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GreenSerRequestServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
