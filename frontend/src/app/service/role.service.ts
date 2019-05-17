import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Role} from "../models/Role";

@Injectable()
export class RoleService {

  constructor(private http:HttpClient){

  }


  getRole(roleId: string): Observable<Role> {
    return this.http.get<Role>("/api/frole/" + roleId);
  }

}
