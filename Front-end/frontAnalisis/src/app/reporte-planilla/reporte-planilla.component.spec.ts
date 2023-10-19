import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportePlanillaComponent } from './reporte-planilla.component';

describe('ReportePlanillaComponent', () => {
  let component: ReportePlanillaComponent;
  let fixture: ComponentFixture<ReportePlanillaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReportePlanillaComponent]
    });
    fixture = TestBed.createComponent(ReportePlanillaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
