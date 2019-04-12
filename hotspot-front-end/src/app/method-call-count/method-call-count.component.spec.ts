import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MethodCallCountComponent } from './method-call-count.component';

describe('MethodCallCountComponent', () => {
  let component: MethodCallCountComponent;
  let fixture: ComponentFixture<MethodCallCountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MethodCallCountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MethodCallCountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
