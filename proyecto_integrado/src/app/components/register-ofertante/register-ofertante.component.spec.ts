import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterOfertanteComponent } from './register-ofertante.component';

describe('RegisterOfertanteComponent', () => {
  let component: RegisterOfertanteComponent;
  let fixture: ComponentFixture<RegisterOfertanteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegisterOfertanteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RegisterOfertanteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
