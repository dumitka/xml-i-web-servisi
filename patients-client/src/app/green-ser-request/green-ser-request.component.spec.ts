import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GreenSerRequestComponent } from './green-ser-request.component';

describe('GreenSerRequestComponent', () => {
  let component: GreenSerRequestComponent;
  let fixture: ComponentFixture<GreenSerRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GreenSerRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GreenSerRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
