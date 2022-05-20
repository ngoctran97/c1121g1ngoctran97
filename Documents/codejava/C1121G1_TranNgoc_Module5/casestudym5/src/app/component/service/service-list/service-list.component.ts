import {Component, OnInit} from '@angular/core';
import {Service} from '../../../model/service';
import {ServiceService} from '../../../service/service.service';

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {
  serviceList: Service[] = [];
  serviceIdDelete: number;
  serviceCodeDelete: string;
  serviceNameDelete: string;
  p = 1;

  constructor(private serviceService: ServiceService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.serviceService.getAll().subscribe(data => {
        this.serviceList = data;
        console.log('data');
      }
      );
  }

  sendServiceInfo(id: number, serviceCode: string, serviceName: string) {
    this.serviceIdDelete = id;
    this.serviceCodeDelete = serviceCode;
    this.serviceNameDelete = serviceName;
  }

  deleteService(closeModal: HTMLButtonElement) {
    this.serviceService.deleteService(this.serviceIdDelete).subscribe( data => {
      closeModal.click();
      this.getAll();
      }
    );
  }
  search(serviceName: string){
    this.serviceService.findByName(serviceName).subscribe( data => {
      this.serviceList = data;
      console.log(data);
      this.p = 1;
    });
  }
}
