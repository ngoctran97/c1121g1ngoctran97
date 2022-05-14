import { Component, OnInit } from '@angular/core';
import {IWord} from '../modle/i-word';
import {DictionaryServiceService} from '../service/dictionary-service.service';




@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {
  dictionaryPageList: IWord[] = [];


  constructor(private dictionaryServiceService: DictionaryServiceService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this.dictionaryPageList = this.dictionaryServiceService.getAll();
  }

  // detailDictionary(dictionary: IWord) {
  //   this.dictionaryPageList = dictionary;
  // }
}
