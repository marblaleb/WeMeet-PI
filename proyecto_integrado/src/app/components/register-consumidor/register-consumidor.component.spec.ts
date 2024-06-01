import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterConsumidorComponent } from './register-consumidor.component';

describe('RegisterConsumidorComponent', () => {
  let component: RegisterConsumidorComponent;
  let fixture: ComponentFixture<RegisterConsumidorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegisterConsumidorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RegisterConsumidorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
