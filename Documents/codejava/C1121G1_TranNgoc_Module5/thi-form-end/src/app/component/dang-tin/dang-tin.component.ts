import { Component, OnInit } from '@angular/core';
import {DangTin} from '../../model/dangTin';
import {DangTinService} from '../../service/dang-tin.service';

@Component({
  selector: 'app-dang-tin',
  templateUrl: './dang-tin.component.html',
  styleUrls: ['./dang-tin.component.css']
})
export class DangTinComponent implements OnInit {
dangTinList: DangTin[] = [];
id: number;
  constructor(private dangTinService: DangTinService) { }

  ngOnInit(): void {
  }

}
