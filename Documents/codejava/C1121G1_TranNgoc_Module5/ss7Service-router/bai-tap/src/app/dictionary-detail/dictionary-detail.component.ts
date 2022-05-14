import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {DictionaryServiceService} from '../service/dictionary-service.service';
import {IWord} from '../modle/i-word';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  dictionaryPageList: any;
   dictionary: IWord;

  constructor(private  activatedRouter: ActivatedRoute, private dictionaryService: DictionaryServiceService ) {
    activatedRouter.paramMap.subscribe( (paramMap: ParamMap) => {
      const id = paramMap.get( 'id');
      if (id != null){
        // tslint:disable-next-line:radix
        const temp = this.dictionaryService.findByID(parseInt(id));
        if(temp != null){
          this.dictionary = temp;
        }
      }

    });
  }

  ngOnInit(): void {
  }
}
