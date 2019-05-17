import { Component, OnInit } from '@angular/core';
import { Products } from "../../models/products";
import {Subscription} from "rxjs";
import {AuthService} from "../../service/auth.service";
import {ProductsService} from "../../service/products.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {


  private subscriptions: Subscription[] = [];
  public newProduct: Products = new Products();

  constructor(private postService: ProductsService,
              private authService: AuthService, private router: Router,) { }

  ngOnInit() {
  }

  ngOnDestroy() {
    this.subscriptions.forEach(subscription => subscription.unsubscribe())
  }

  public _addProduct(): void {
    this.subscriptions.push(this.postService.saveProduct(this.newProduct).subscribe(() => {
    }))
  }

  private checkUsername(): void {
    if(this.authService.getUsername() == null)
      this.router.navigate(['']);
    else if(this.authService.getRole() != "ADMIN")
      this.router.navigate(['']);
  }

  public disableProductButton(): boolean {
    if(this.newProduct.name == null || this.newProduct.description == null ||
      this.newProduct.monthlyPrice == null) {
      return true;
    }
    return false;
  }

}
