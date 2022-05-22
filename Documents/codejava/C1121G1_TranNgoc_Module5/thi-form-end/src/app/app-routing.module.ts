import {NgModule} from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BlogComponent} from './component/blogg/blog/blog.component';
import {BlogCreateComponent} from './component/blogg/blog-create/blog-create.component';
import {SearchComponent} from './component/search/search.component';
import {BlogEditComponent} from './component/blogg/blog-edit/blog-edit.component';

const routes: Routes = [{
  path: '',
  component: BlogComponent
}, {
  path: 'create',
  component: BlogCreateComponent
}, {
  path: 'search',
  component: SearchComponent
}, {
  path: 'blog/edit/:id',
  component: BlogEditComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
