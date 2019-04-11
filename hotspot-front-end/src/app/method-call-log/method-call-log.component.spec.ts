import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MethodCallLogComponent } from './method-call-log.component';

describe('MethodCallLogComponent', () => {
  let component: MethodCallLogComponent;
  let fixture: ComponentFixture<MethodCallLogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MethodCallLogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MethodCallLogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
