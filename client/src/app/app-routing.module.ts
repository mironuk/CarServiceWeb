import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ContactComponent } from './contact/contact.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { MyCarsComponent } from './my-cars/my-cars.component';
import { MyServiceItemsComponent } from './my-service-items/my-service-items.component';
import { ViewCarComponent } from './view-car/view-car.component';
import { EditCarComponent } from './edit-car/edit-car.component';
import { ViewServiceItemComponent } from './view-service-item/view-service-item.component';
import { EditServiceItemComponent } from './edit-service-item/edit-service-item.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'contact', component: ContactComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'login', component: LoginComponent },
    { path: 'logout', component: LogoutComponent },
    { path: 'my-cars', component: MyCarsComponent },
    { path: 'my-service-items', component: MyServiceItemsComponent },
    { path: 'car/edit/:id', component: EditCarComponent },
    { path: 'car/new', component: EditCarComponent },
    { path: 'car/:id', component: ViewCarComponent },
    { path: 'service-item/edit/:id', component: EditServiceItemComponent },
    { path: 'service-item/new', component: EditServiceItemComponent },
    { path: 'service-item/:id', component: ViewServiceItemComponent },
    { path: '**', component: PageNotFoundComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes, {useHash: true})],
    exports: [RouterModule]
})
export class AppRoutingModule { }
