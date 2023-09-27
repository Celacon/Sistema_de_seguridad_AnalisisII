import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstatusUsuarioComponent } from './estatus-usuario.component';

describe('EstatusUsuarioComponent', () => {
  let component: EstatusUsuarioComponent;
  let fixture: ComponentFixture<EstatusUsuarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EstatusUsuarioComponent]
    });
    fixture = TestBed.createComponent(EstatusUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
