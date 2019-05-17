import { Component, OnInit } from '@angular/core';
import {Products} from "../../models/products";
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {ProductsService} from "../../service/products.service";
import {AuthService} from "../../service/auth.service";
import {TokenStorage} from "../../storage/token.storage";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  public products: Products;
  private subscriptions: Subscription[] = [];
  public product_id: number;

  constructor(private productsService: ProductsService, private route: ActivatedRoute, private tokeStorage: TokenStorage,
               private authService: AuthService,) { }

  ngOnInit() {

  }

  ngOnDestroy() {

  }

  private loadProduct(productId: string): void {

    this.subscriptions.push(this.productsService.getProduct(productId).subscribe(product => {
      this.products = product as Products;
      console.log("Product: " + this.products);

    }))
  }

  public _deleteProduct(postId: string): void {

    this.subscriptions.push(this.productsService.deleteProduct(postId).subscribe(() => {
    }))
  }

  public _getRole(): string {
    if(this.tokeStorage.getToken())
      return this.authService.getRole();
  }



}
