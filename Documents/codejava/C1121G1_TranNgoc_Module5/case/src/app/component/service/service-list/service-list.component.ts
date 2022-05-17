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
  private serviceIdDelete: number;
  private serviceCodeDelete: string;
  private serviceNameDelete: string;

  constructor(private serviceService: ServiceService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.serviceService.getAll().subscribe(data => {
        this.serviceList = data;
        console.log('data');
      }, error => {
        alert('ok');
      });
  }

  sendServiceInfo(id: number, serviceCode: string, serviceName: string) {
    this.serviceIdDelete = id;
    this.serviceCodeDelete = serviceCode;
    this.serviceNameDelete = serviceName;
  }

  deleteService(closeModal: HTMLButtonElement) {
    this.serviceService.deleteService(this.serviceIdDelete);
    closeModal.click();
    this.getAll();
  }
}
