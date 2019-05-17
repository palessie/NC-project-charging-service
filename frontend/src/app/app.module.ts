import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from "@angular/router";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { LoginPageComponent } from './login-page/login-page.component';

import { NavbarComponent } from './navbar/navbar.component';
import { RegistrationPageComponent } from './registration-page/registration-page.component';

import { MainPageModule } from "./main-page/main-page.module";
import { WalletPageModule} from "./wallet-page/wallet-page.module";
import { UsersPageModule} from "./users-page/users-page.module";
import { SubscriptionsPageModule} from "./subscriptions-page/subscriptions-page.module";
import { ProductPageModule} from "./product-page/product-page.module";
import { NewWalletPageModule} from "./new-wallet-page/new-wallet-page.module";
import { NewProductPageModule} from "./new-product-page/new-product-page.module";
import {ProductsService} from "./service/products.service";
import {UsersService} from "./service/users.service";
import {WalletService} from "./service/wallet.service";
import { TokenStorage } from "./storage/token.storage";
import {AuthService} from "./service/auth.service";
import {Interceptor} from "./service/interceptor.service";
import {RoleService} from "./service/role.service";


const appRoutes: Routes = [
  {path: 'login', component:LoginPageComponent},
  {path: 'registration', component:RegistrationPageComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    NavbarComponent,
    RegistrationPageComponent,


  ],
  imports: [
    WalletPageModule,
    MainPageModule,
    UsersPageModule,
    SubscriptionsPageModule,
    ProductPageModule,
    NewWalletPageModule,
    NewProductPageModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [ProductsService, UsersService, WalletService,AuthService,Interceptor,RoleService,
    TokenStorage],
  bootstrap: [AppComponent]
})
export class AppModule { }
