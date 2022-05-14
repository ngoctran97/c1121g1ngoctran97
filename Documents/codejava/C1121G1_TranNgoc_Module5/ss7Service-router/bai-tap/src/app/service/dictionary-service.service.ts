import { Injectable } from '@angular/core';
import {IWord} from '../modle/i-word';

@Injectable({
  providedIn: 'root'
})
export class DictionaryServiceService {
dictionaryPageList: IWord[] = [
  {id: 1, word: 'red', mean: 'đỏ'},
  {id: 2, word: 'green', mean: 'xanh'},
  {id: 3, word: 'yellow', mean: 'Vàng'},
  {id: 4, word: 'Violet', mean: 'tím'},
];

  constructor() { }

  getAll() {
    return this.dictionaryPageList;
  }
  findByID(id: number) {
    for (const dictionary of this.dictionaryPageList){
      if (dictionary.id === id){
        return dictionary;
      }
    }
    return null;
  }
}
