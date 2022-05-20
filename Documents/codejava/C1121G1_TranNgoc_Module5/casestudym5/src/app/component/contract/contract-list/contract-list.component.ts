import { Component, OnInit } from '@angular/core';
import {Contract} from '../../../model/contract';
import {ContractService} from '../../../service/contract.service';
import {CustomerService} from '../../../service/customer.service';
import {ServiceService} from '../../../service/service.service';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
contractList: Contract[] = [];
  p = 1;

  constructor(private contractService: ContractService,
              private customerService: CustomerService,
              private serviceService: ServiceService) {
  }

  ngOnInit(): void {
    this.getAll();
  }
   getAll(){
    this.contractService.getAll().subscribe( data => {
      this.contractList = data;
    });
   }
}
