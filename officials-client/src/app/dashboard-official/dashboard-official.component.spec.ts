import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardOfficialComponent } from './dashboard-official.component';

describe('DashboardOfficialComponent', () => {
  let component: DashboardOfficialComponent;
  let fixture: ComponentFixture<DashboardOfficialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardOfficialComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardOfficialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
