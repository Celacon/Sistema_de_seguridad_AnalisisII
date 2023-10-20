import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportePlanilla2Component } from './reporte-planilla2.component';

describe('ReportePlanilla2Component', () => {
  let component: ReportePlanilla2Component;
  let fixture: ComponentFixture<ReportePlanilla2Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReportePlanilla2Component]
    });
    fixture = TestBed.createComponent(ReportePlanilla2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
