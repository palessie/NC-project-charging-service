import {Role} from "./Role";
import {Wallet} from "./Wallet";

export class Users{
  idUser: string;
  email: string;
  login: string;
  password: string;
  wallet: Wallet;
  lastDateLogin: string;
  role: Role;
  name: string;
  surname: string;


}
