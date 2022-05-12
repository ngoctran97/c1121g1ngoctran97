import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl, Validators, NgForm} from '@angular/forms';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  registrationForm: FormGroup;
  private submitCreateRegistration: any;

  constructor() {
    this.registrationForm = new FormGroup( {
      email: new FormControl( '', [Validators.required, Validators.email]),
      password: new FormControl( '', [Validators.required, Validators.minLength(6)]),
      confirmPassword: new FormControl( '', [Validators.required, Validators.minLength(6)]),
      country: new FormControl( '', Validators.required),
      age: new FormControl( '', [Validators.required, Validators.min(18)]),
      gender: new FormControl( '', Validators.required),
      phone: new FormControl( '', [Validators.required, Validators.pattern( '^\\+84\\d{9,10}$')])
    });
  }

  ngOnInit(): void {
  }

  submitRegistration(registerForm: NgForm){
    this.submitCreateRegistration.emit(registerForm.value);
  }
}
