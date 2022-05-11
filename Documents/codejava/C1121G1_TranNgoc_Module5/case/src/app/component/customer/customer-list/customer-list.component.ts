import { Component, OnInit } from '@angular/core';
import {Customer} from '../../../model/customer';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customerList: Array<Customer> = [];

  constructor() {
    this.customerList.push(new Customer(1, 'KH-0001', 'Ngọc Trần', '27/06/1996', 'Nữ', 123456789, '987654321' , 'ngoctran@gmail.com', 'Thừa Thiên Huế', 'Diamond'));
    this.customerList.push(new Customer(2, 'KH-0002', 'Trong Trần', '27/06/1997', 'Nam', 123456789, '987654321' , 'ngoctran@gmail.com', 'Thừa Thiên Huế', 'Diamond'));
    this.customerList.push(new Customer(3, 'KH-0003', 'Thao Trần', '27/06/1998', 'Nữ', 123456789, '987654321' , 'ngoctran@gmail.com', 'Thừa Thiên Huế', 'Diamond'));

  }

  ngOnInit(): void {
  }

  createStuden($event: Event) {

  }
}
