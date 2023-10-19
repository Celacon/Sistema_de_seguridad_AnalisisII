import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarBancoComponent } from './agregar-banco.component';

describe('AgregarBancoComponent', () => {
  let component: AgregarBancoComponent;
  let fixture: ComponentFixture<AgregarBancoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AgregarBancoComponent]
    });
    fixture = TestBed.createComponent(AgregarBancoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
