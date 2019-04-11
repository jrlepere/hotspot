import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MethodCallCounterComponent } from './method-call-counter.component';

describe('MethodCallCounterComponent', () => {
  let component: MethodCallCounterComponent;
  let fixture: ComponentFixture<MethodCallCounterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MethodCallCounterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MethodCallCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
