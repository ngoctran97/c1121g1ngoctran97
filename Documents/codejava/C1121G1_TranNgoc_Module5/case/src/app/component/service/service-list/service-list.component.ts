import { Component, OnInit } from '@angular/core';
import {Service} from '../../../model/service';

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {
  serviceList: Array<Service> = [];

  constructor() {
    this.serviceList.push(new Service(1, 'DV-0001', 'Villa Beach Front', 2500, 1000000, 12, 'vip', 'Có hồ bơi', '500', '4', 'Day'));
    this.serviceList.push(new Service(2, 'DV-0002', 'Villa Beach Front', 2500, 1000000, 12, 'vip', 'co tivi', '500', '4', 'Day'));
    this.serviceList.push(new Service(3, 'DV-0003', 'Villa Beach Front', 2500, 1000000, 12, 'vip', 'Có hồ bơi', 'null', 'null', 'Day'));
  }

  ngOnInit(): void {
  }

}
