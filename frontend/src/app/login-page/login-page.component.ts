import {Component, OnDestroy, OnInit} from '@angular/core';
import { Users} from "../models/Users";
import { UsersService} from "../service/users.service";
import { AuthService } from "../service/auth.service";
import { Token } from "../models/token";
import { TokenStorage } from "../storage/token.storage";
import { LoginUser } from "../models/loginUser";
import { Decode } from "../models/decode";
import { Subscription} from "rxjs";
@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit,OnDestroy {

  public user: Decode;

  public role: string;

  public loginUser: LoginUser = new LoginUser();
  private subscriptions: Subscription[] = [];

  constructor(private usersService: UsersService,
              private authService: AuthService, private tokenStorage: TokenStorage,) {
  }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.user = this.authService.decodeJwt(this.tokenStorage.getToken());
      this.role = this.user.scopes.split(",")[0];
    }
  }
  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  public authorizate(): void {

    this.subscriptions.push(this.authService.attemptAuth(this.loginUser).subscribe(authToken => {
      if (authToken == null) {
        console.log("Unauthorizate");
      } else {
        let token: Token = authToken as Token;
        this.tokenStorage.saveToken(token.token);
        this.user = this.authService.decodeJwt(token.token);
        console.log(this.user);
        this.role = this.user.scopes.split(",")[0];
      }
    }));
  }
}
