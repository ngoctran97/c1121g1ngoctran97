import {Component, OnInit} from '@angular/core';
import {Todo} from '../todo';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {TodoService} from '../service/todo.service';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

let _id = 1;

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent implements OnInit {
  todos: Todo[] = [];
  content = new FormControl();
  todo: any;
  url = 'http://localhost:3000/todo';

  constructor(private todoService: TodoService,
              private http: HttpClient) {
  }

  ngOnInit() {
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }

  change() {
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        id: _id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.content.reset();
    }
  }

  deleteTodo(id: number) {
    this.todoService.deleteTodo(id).subscribe(() => {
      console.log('success!');
      this.getAll();
    }, errors => {
      console.log(errors);
    });
  }

  getAll(): Observable<any> {
    return this.http.get<any>(this.url);
  }
}
