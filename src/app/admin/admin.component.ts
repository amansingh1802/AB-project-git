import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../project.service';
import { Router } from '@angular/router';
  import { from } from 'rxjs';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  message;

  constructor(private projectService:ProjectService,
              private router:Router) { }

  ngOnInit() {
  }

  SaveOrUpdateProduct(productForm){
    let product = productForm.form.value;
    let observableResult = this.projectService.SaveOrUpdateProduct(product);
    observableResult.subscribe((result:any)=>{
       this.message = result;
       this.router.navigate(['/product']);
    });
  }

  DeleteProduct(productId){
    let observableResult = this.projectService.DeleteProductById(productId);
    observableResult.subscribe((result:any)=>{
      this.message = result;
      this.router.navigate(['/product']);
   });
  }
}
