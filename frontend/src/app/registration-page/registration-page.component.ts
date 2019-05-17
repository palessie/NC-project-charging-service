import { Component, OnInit } from '@angular/core';
import { Users} from "../models/Users";
import { UsersService} from "../service/users.service";
import { AuthService } from "../service/auth.service";
import { Token } from "../models/token";
import { TokenStorage } from "../storage/token.storage";
import { LoginUser } from "../models/loginUser";
import { Decode } from "../models/decode";
import { Subscription} from "rxjs";

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.css']
})
export class RegistrationPageComponent implements OnInit {

  public user: Decode;
  public role: string;
  private subscriptions: Subscription[] = [];
  public newUser: Users = new Users();
  public registerAccess: boolean = true;
  public exceptionMessage = "";

  constructor(private usersService: UsersService,
              private authService: AuthService, private tokenStorage: TokenStorage,) {
  }

  ngOnInit(

  ) {
    if(this.tokenStorage.getToken()) {
      this.user = this.authService.decodeJwt(this.tokenStorage.getToken());
      this.role = this.user.scopes.split(",")[0];
    }
  }

  public signUp(): void {

    this.registerAccess = true;
    this.subscriptions.push(this.usersService.saveUser(this.newUser).subscribe(authToken => {
      if(authToken.token != "This login already exists" && authToken.token != "This email already exists") {
        let token: Token = authToken as Token;
        this.tokenStorage.saveToken(token.token);

        this.user = this.authService.decodeJwt(token.token);

        console.log(this.user);
        this.role = this.user.scopes.split(",")[0];
        console.log(this.newUser);
      } else {
        this.registerAccess = false;
        this.exceptionMessage = authToken.token;
      }

    }));

  }
}
