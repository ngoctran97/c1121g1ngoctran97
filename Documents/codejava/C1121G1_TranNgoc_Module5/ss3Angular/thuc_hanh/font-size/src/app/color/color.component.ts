import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
  index?: number;
  color?: string;
  changeColor() {
    switch (this.index) {
      case 1:
        this.color = 'red';
        break;
      case 2:
        this.color = 'blue';
        break;
      case 3:
        this.color = 'yellow';
        break;
      case 4:
        this.color = 'green';
        break;
    }
  }

  constructor() { }

  ngOnInit(): void {
  }

}
