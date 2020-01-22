import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistorvendorComponent } from './registorvendor.component';

describe('RegistorvendorComponent', () => {
  let component: RegistorvendorComponent;
  let fixture: ComponentFixture<RegistorvendorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistorvendorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistorvendorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
