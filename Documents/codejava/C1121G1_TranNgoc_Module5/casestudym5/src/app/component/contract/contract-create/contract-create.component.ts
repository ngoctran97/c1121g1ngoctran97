import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../../service/customer.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ContractService} from '../../../service/contract.service';

@Component({
  selector: 'app-contract-create',
  templateUrl: './contract-create.component.html',
  styleUrls: ['./contract-create.component.css']
})
export class ContractCreateComponent implements OnInit {
 contractForm: FormGroup = new FormGroup( {
   contractStartDate: new FormControl( '', Validators.required),
   contractEndDate: new FormControl( '', Validators.required),
   contractDeposit: new FormControl( '', [Validators.required, Validators.min(0)]),
   contractTotalMoney: new FormControl( '', [Validators.required, Validators.min(0)]),
   employee: new FormControl( '', Validators.required),
   customer: new FormControl( '', Validators.required),
   service: new FormControl( '', Validators.required)
 });

  constructor(private contractService: ContractService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
  }
  submitContract(){
    const contract = this.contractForm.value;
    this.contractService.saveContract(contract).subscribe(data => {
        this.contractForm.reset();
        this.router.navigate(['/contract']);
    });
  }
}
