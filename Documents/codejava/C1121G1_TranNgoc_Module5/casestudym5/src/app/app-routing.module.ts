import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeRoutingModule} from './component/home/home-routing.module';
import {CustomerRoutingModule} from './component/customer/customer-routing.module';
import {ContractRoutingModule} from './component/contract/contract-routing.module';
import {ServiceRoutingModule} from './component/service/service-routing.module';


const routes: Routes = [{
    path: 'home',
    loadChildren: () => import('./component/home/home.module').then(module => module.HomeModule)
}, {
    path: 'customer',
    loadChildren: () => import('./component/customer/customer.module').then(module => module.CustomerModule)
}, {
    path: 'service',
    loadChildren: () => import('./component/service/service.module').then(module => module.ServiceModule)
}, {
    path: 'contract',
    loadChildren: () => import('./component/contract/contract.module').then(module => module.ContractModule)
}
];

@NgModule({
    imports: [RouterModule.forRoot(routes), HomeRoutingModule, CustomerRoutingModule, ContractRoutingModule, ServiceRoutingModule],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
