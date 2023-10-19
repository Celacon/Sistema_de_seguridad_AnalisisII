import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetallePlanillaComponent } from './detalle-planilla.component';

describe('DetallePlanillaComponent', () => {
  let component: DetallePlanillaComponent;
  let fixture: ComponentFixture<DetallePlanillaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DetallePlanillaComponent]
    });
    fixture = TestBed.createComponent(DetallePlanillaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
