import { Component, OnInit } from '@angular/core';
import {Products} from "../../models/products";
import {ProductsService} from "../../service/products.service";
import {Subscription} from "rxjs/internal/Subscription";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})

export class ProductsComponent implements OnInit {

  public products: Products[];
  private subscriptions: Subscription[] = [];
  public pages: number[] = [];
  public total: number;
  public currentPage: number = 1;
  public quantity: number = 6;

  constructor(private productsService: ProductsService) { }

  ngOnInit() {
    this.getProductsByPage(1);
    this.getTotalPages();
  }

  ngOnDestroy() {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  private getTotalPages(): void {
    this.subscriptions.push(this.productsService.getTotalPages(this.quantity).subscribe(totalPages => {
      this.total = totalPages;
      console.log(this.total);
      this.pages = [];
      for(let i=1; i<=totalPages; i++) {
        this.pages.push(i);
      }
    }))
  }

  public getProductsByPage(page: number): void {

    this.subscriptions.push(this.productsService.getProductsByPage(page, this.quantity).subscribe(product => {
      this.products = product as Products[];

    }))
  }

  public setQuantity(qt: number): void {
    this.quantity = qt;
    this.getProductsByPage(1);
    this.currentPage = 1;
    this.getTotalPages();
  }
}


