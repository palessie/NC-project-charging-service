import { Component, OnInit } from '@angular/core';
import {Users} from "../../models/Users";
import {UsersService} from "../../service/users.service"
import {Subscription} from "rxjs/internal/Subscription";
import {Router} from "@angular/router";
import {SubscriptionsService} from "../../service/subscriptions.service";
import {AdminUserService} from "../../service/admin-user.service";
import {LoginEventService} from "../../service/login-event.service";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  public users: Users[] = [];
  private subscriptions: Subscription[] = [];

  constructor(private userService: UsersService,
              private loginEventService: LoginEventService, private adminUserService: AdminUserService,
              private router: Router, private subscriptionsService: SubscriptionsService) { }

  ngOnInit() {
    this.loadUsers();
    this.loginEventService.skipClicked.subscribe( value => {
      if(value == true) {
        this.router.navigate(['']);
      }
    })
  }

  ngOnDestroy() {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  private loadUsers(): void {

    this.subscriptions.push(this.userService.getAllUsers().subscribe(newUsers => {
      this.users = newUsers;

    }))
  }

  public _deleteUser(userId: string): void {
    this.subscriptions.push(this.userService.deleteUser(userId).subscribe(() => {
      this.updateUsers();
    }))
  }

  private updateUsers(): void {
    this.loadUsers();
  }

  public getSubscriptions(login: string): void {
    this.adminUserService.putLogin(login);
    this.router.navigate(['/subscriptions'])
  }
}
