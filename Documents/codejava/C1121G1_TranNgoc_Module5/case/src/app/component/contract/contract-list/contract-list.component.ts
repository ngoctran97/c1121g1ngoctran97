import { Component, OnInit } from '@angular/core';
import {Contract} from '../../../model/contract';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
contractList: Array<Contract> = [];
  constructor() {
    this.contractList.push(new Contract(1, '01/01/2022', '01/02/2022', 5000000, 15000000, 'Thanh Long', 'Ngọc Trần', 'Villa'));
    this.contractList.push(new Contract(2, '01/01/2022', '01/02/2022', 5000000, 15000000, 'Đình Văn', 'Thanh Trần', 'House'));
    this.contractList.push(new Contract(3, '01/01/2022', '01/02/2022', 5000000, 15000000, 'Hồng Phạm', 'Mỹ Trần', 'Room'));
  }

  ngOnInit(): void {
  }

}
