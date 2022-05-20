import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ServiceService} from '../../../../service/service.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-service-edit-houne',
  templateUrl: './service-edit-houne.component.html',
  styleUrls: ['./service-edit-houne.component.css']
})
export class ServiceEditHouneComponent implements OnInit {
  serviceForm: FormGroup;
  id: number;

  constructor(private serviceService: ServiceService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe( (paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getService(this.id);
    });
  }

  ngOnInit(): void {
  }

  private getService(id: number) {
    return this.serviceService.findById(id).subscribe(service => {
      console.log(service);
      this.serviceForm = new FormGroup( {
        serviceCode: new FormControl(service.serviceCode),
        serviceName: new FormControl(service.serviceName),
        serviceArea: new FormControl(service.serviceArea),
        serviceCost: new FormControl(service.serviceCost),
        serviceMaxPeople: new FormControl(service.serviceMaxPeople),
        standardRoom: new FormControl(service.standardRoom),
        descritionOtherConvenience: new FormControl(service.descritionOtherConvenience),
        numberOdFloors: new FormControl(service.numberOdFloors),
        rentType: new FormControl(service.rentType),
      });
    });
  }

  updateService(id: number) {
    const service = this.serviceForm.value;
    this.serviceService.updateService(id, service).subscribe( () => {
      alert('Cập nhật thành công');
      this.router.navigate(['/service']);
    });
  }
}
