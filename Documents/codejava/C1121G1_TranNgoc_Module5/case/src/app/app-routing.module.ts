import {NgModule} from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './component/home/home.component';
import {CustomerListComponent} from './component/customer/customer-list/customer-list.component';
import {ContractListComponent} from './component/contract/contract-list/contract-list.component';
import {ServiceListComponent} from './component/service/service-list/service-list.component';
import {CustomerCreateComponent} from './component/customer/customer-create/customer-create.component';
import {CustomerEditComponent} from './component/customer/customer-edit/customer-edit.component';
import {ServiceCreateVillaComponent} from './component/service/service-create/service-create-villa/service-create-villa.component';
import {ServiceEditVillaComponent} from './component/service/service-edit/service-edit-villa/service-edit-villa.component';



const routes: Routes = [{
  path: '',
  component: HomeComponent
}, {
  path: 'customer',
  component: CustomerListComponent
}, {
  path: 'contract',
  component: ContractListComponent
}, {
  path: 'service',
  component: ServiceListComponent
}, {
  path: 'create',
  component: CustomerCreateComponent
}, {
  path: 'customer/edit/:id',
  component: CustomerEditComponent
}, {
  path: 'service/create',
  component: ServiceCreateVillaComponent
}, {
  path: 'service/edit/:id',
  component: ServiceEditVillaComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
