import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyServiceItemsComponent } from './my-service-items.component';

describe('MyServiceItemsComponent', () => {
  let component: MyServiceItemsComponent;
  let fixture: ComponentFixture<MyServiceItemsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyServiceItemsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyServiceItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
