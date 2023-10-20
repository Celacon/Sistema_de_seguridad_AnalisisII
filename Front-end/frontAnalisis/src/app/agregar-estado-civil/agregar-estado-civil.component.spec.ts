import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarEstadoCivilComponent } from './agregar-estado-civil.component';

describe('AgregarEstadoCivilComponent', () => {
  let component: AgregarEstadoCivilComponent;
  let fixture: ComponentFixture<AgregarEstadoCivilComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AgregarEstadoCivilComponent]
    });
    fixture = TestBed.createComponent(AgregarEstadoCivilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
