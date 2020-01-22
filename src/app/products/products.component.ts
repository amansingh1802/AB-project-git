import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }

  SetActionADD(){
    localStorage.setItem("action","ADD");
    this.router.navigate(['/addproduct']);
  }
  SetActionEDIT(){
    localStorage.setItem("action","EDIT");
    this.router.navigate(['/addproduct']);
  }
}
