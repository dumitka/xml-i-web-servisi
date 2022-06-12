import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImmunisationComponent } from './immunisation.component';

describe('ImmunisationComponent', () => {
  let component: ImmunisationComponent;
  let fixture: ComponentFixture<ImmunisationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImmunisationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImmunisationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
