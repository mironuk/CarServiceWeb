import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
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

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        ContactComponent,
        RegisterComponent,
        LoginComponent,
        LogoutComponent,
        MyCarsComponent,
        MyServiceItemsComponent,
        ViewCarComponent,
        EditCarComponent,
        ViewServiceItemComponent,
        EditServiceItemComponent,
        PageNotFoundComponent,
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
