import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ServiceListComponent} from './service-list/service-list.component';
import {ServiceCreateVillaComponent} from './service-create/service-create-villa/service-create-villa.component';
import {ServiceEditVillaComponent} from './service-edit/service-edit-villa/service-edit-villa.component';
import {ServiceCreateHouseComponent} from './service-create/service-create-house/service-create-house.component';


const routes: Routes = [
  {
    path: 'service',
    component: ServiceListComponent
  },  {
    path: 'service/createVilla',
    component: ServiceCreateVillaComponent
  }, {
    path: 'service/edit/:id',
    component: ServiceEditVillaComponent
  }, {
    path: 'service/createHouse',
    component: ServiceCreateHouseComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ServiceRoutingModule { }
