import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Injectable } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { ProductsComponent } from './products/products.component';
import { VendorsComponent } from './vendors/vendors.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { RegistorvendorComponent } from './registorvendor/registorvendor.component';
import { CustomerComponent } from './customer/customer.component';
import { RegistrationsuccessComponent } from './registrationsuccess/registrationsuccess.component';
import { OrdersComponent } from './orders/orders.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { DownloadsComponent } from './downloads/downloads.component';
import { AdminComponent } from './admin/admin.component';
import { CartComponent } from './cart/cart.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutusComponent,
    ContactusComponent,
    ProductsComponent,
    VendorsComponent,
    LoginComponent,
    RegisterComponent,
    UpdateProfileComponent,
    ChangePasswordComponent,
    RegistorvendorComponent,
    CustomerComponent,
    RegistrationsuccessComponent,
    OrdersComponent,
    AddproductComponent,
    DownloadsComponent,
    AdminComponent,
    CartComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      { path:'', component:HomeComponent},
      { path:'home', component:HomeComponent},
      { path:'aboutus', component:AboutusComponent},
      { path:'contactus', component:ContactusComponent},
      { path:'products', component:ProductsComponent},
      { path:'vendor', component:VendorsComponent},
      { path:'admin', component:AdminComponent},
      { path:'login', component:LoginComponent},
      { path:'register', component:RegisterComponent},
      { path:'updateProfile', component:UpdateProfileComponent},
      { path:'changePassword', component:ChangePasswordComponent},
      { path:'registorvendor', component:RegistorvendorComponent},
      { path:'registrationsuccess', component:RegistrationsuccessComponent},
      { path:'orders', component:OrdersComponent},
      { path:'addProduct', component:AddproductComponent},
      { path:'downloads', component:DownloadsComponent},
      { path:'logout', component:LoginComponent},
      { path:'cart', component:CartComponent}
    ])
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
@Injectable()
export class AppModule { }
