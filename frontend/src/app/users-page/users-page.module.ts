import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from "@angular/router";

import { UsersPageComponent } from './users-page.component';
import { UsersComponent } from "./users/users.component";


@NgModule({
  declarations: [
    UsersPageComponent,
    UsersComponent,

  ],
  imports: [
    CommonModule,
    RouterModule.forRoot([
      {
        path: 'users',
        component: UsersPageComponent
      }
    ])
  ],

})
export class UsersPageModule { }
