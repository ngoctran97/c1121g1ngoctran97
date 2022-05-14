import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-contract-create',
  templateUrl: './contract-create.component.html',
  styleUrls: ['./contract-create.component.css']
})
export class ContractCreateComponent implements OnInit {
 contractForm: FormGroup;
  constructor() {
    this.contractForm = new FormGroup( {
      contractStartDate: new FormControl( '', Validators.required),
      contractEndDate: new FormControl( '', Validators.required),
      contractDeposit: new FormControl( '', [Validators.required, Validators.min(0)]),
      contractTotalMoney: new FormControl( '', [Validators.required, Validators.min(0)]),
      employee: new FormControl( '', Validators.required),
      customer: new FormControl( '', Validators.required),
      service: new FormControl( '', Validators.required)
    });
  }

  ngOnInit(): void {
  }
  submitContract(){
    console.log(this.contractForm);
  }
}
