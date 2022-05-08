import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  num1 = 0;
  num2 = 0;
  calculator?: string ;
  result?: number;

  calculate() {
    switch (this.calculator) {
      case 'cong':
        this.result = this.num1 + this.num2;
        break;
      case 'tru':
        this.result = this.num1 - this.num2;
        break;
      case 'nhan':
        this.result = this.num1 * this.num2;
        break;
      case 'chia':
        if (this.num2 === 0) {
          return 'num2 must not be 0';
        }
        this.result = this.num1 / this.num2;
        break;
    }
  }

  constructor() { }

  ngOnInit(): void {
  }
}
