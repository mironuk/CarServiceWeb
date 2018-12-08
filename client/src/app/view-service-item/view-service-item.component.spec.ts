import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewServiceItemComponent } from './view-service-item.component';

describe('ViewServiceItemComponent', () => {
  let component: ViewServiceItemComponent;
  let fixture: ComponentFixture<ViewServiceItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewServiceItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewServiceItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
