import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from "@angular/router";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { StartPageComponent } from './start-page/start-page.component';
import { UserPageComponent } from './user-page/user-page.component';
import { AdminPageComponent } from './admin-page/admin-page.component';

const appRoutes: Routes = [
  {path: '', component:StartPageComponent},
  {path: 'user', component:UserPageComponent},
  {path: 'admin', component:AdminPageComponent},

]

@NgModule({
  declarations: [
    AppComponent,
    StartPageComponent,
    UserPageComponent,
    AdminPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
