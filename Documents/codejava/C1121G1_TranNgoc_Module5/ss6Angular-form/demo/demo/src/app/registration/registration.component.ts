import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, NgForm, Validators} from '@angular/forms';
import {Registration} from '../registration';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {
  registrationForm: FormGroup;

  constructor() {
    this.registrationForm = new FormGroup( {
      email: new FormControl( '', [Validators.required, Validators.pattern('^$|[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)')]),
      password: new FormControl( '', [Validators.required, Validators.minLength(6)]),
      confirmPassword: new FormControl( '', [Validators.required, Validators.minLength(6)]),
      country: new FormControl( '', Validators.required),
      age: new FormControl( '', [Validators.required, Validators.minLength(18)]),
      gender: new FormControl( '', Validators.required),
      phone: new FormControl( '', [Validators.required, Validators.pattern( '^\\+84\\d{9,10}$')])
    });
  }

  ngOnInit(): void {
  }
  submitRegistration(){
  }

}
