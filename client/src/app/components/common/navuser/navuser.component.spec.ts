import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavuserComponent } from './navuser.component';

describe('NavuserComponent', () => {
  let component: NavuserComponent;
  let fixture: ComponentFixture<NavuserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavuserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavuserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
