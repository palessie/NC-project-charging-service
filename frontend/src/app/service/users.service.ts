import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Users} from "../models/Users";
import {Token} from "../models/token";

@Injectable()
export class UsersService {

  constructor(private http:HttpClient){

  }

  getAllUsers():Observable<Users[]>{
    return this.http.get<Users[]>("/api/fusers");
  }
  getUser(userId: string): Observable<Users> {
    return this.http.get<Users>("/api/fusers/" + userId);
  }
  saveUser(user: Users): Observable<Token> {
    return this.http.post<Token>("/api/fusers",user)
  }
  deleteUser(userId: string): Observable<void> {
    return this.http.delete<void>("/api/fusers/" + userId)
  }
  getUserByLogin(login: string): Observable<Users> {
    return this.http.get<Users>("/api/fusers/?login=" + login);
  }



}
