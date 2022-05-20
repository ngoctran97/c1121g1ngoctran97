import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceCreateVillaComponent } from './service-create-villa.component';

describe('ServiceCreateVillaComponent', () => {
  let component: ServiceCreateVillaComponent;
  let fixture: ComponentFixture<ServiceCreateVillaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceCreateVillaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceCreateVillaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
