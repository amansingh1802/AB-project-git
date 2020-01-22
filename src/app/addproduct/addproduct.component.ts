import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProjectService } from '../project.service';
import { ReactiveFormsModule } from '@angular/forms';


@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {

  product={
    gtin:"00007777",
	  name:"nobita",
	  category:"PORCELAIN",
	  material:"CLAY",
	  shape:"MASAIC",
	  finish:"GLAZED",
	  image:File=null,
	  description:"this is porcelain tile made from clay",
    price:899
  };
  oldProduct;
  message;
  role;
    //FILE UPLOADING
    fileData: File = null;
    previewUrl:any = null;
    fileUploadProgress: string = null;
    uploadedFilePath: string = null;

  constructor(private route:ActivatedRoute,
              private router:Router,
              private projectService:ProjectService) 
  { }

  ngOnInit() {
    this.role = localStorage.getItem("role");
    if(this.role == "ADMIN" || this.role == "VENDOR")
    {
      this.route.paramMap.subscribe((parameter)=>{
        let productId = parameter.get("id");
        console.log("AddproductComponent.ngOnInit() : "+productId);
        if(productId!=null){
          console.log("test : bheshaj")
          let observableResult = this.projectService.GetProductById(productId);
          observableResult.subscribe((result:any)=>{
            this.oldProduct = result;
          });
        }
      });
    }
  }

  fileProgress(fileInput: any) {
    console.log("fileProgress")
    console.log("fileInput: "+fileInput);
    this.fileData = <File>fileInput.target.files[0];
    console.log(this.fileData)
    console.log("file name : "+this.fileData.name)
    console.log("file size : "+this.fileData.size)
    this.preview();
  }
  preview() {
    // Show preview 
    console.log("preview()")
    var mimeType = this.fileData.type;
    console.log("mimeType : "+ mimeType)
    if (mimeType.match(/image\/*/) == null) {
      console.log("if=>true")
      return;
    }
 
    var reader = new FileReader();      
    reader.readAsDataURL(this.fileData); 
    reader.onload = (_event) => { 
      this.previewUrl = reader.result; 
      //console.log("this.previewUrl "+ this.previewUrl)
    }
  }
  onSubmit() {
    console.log("onSubmit()")
    const formData = new FormData();
    formData.append('file', this.fileData);
    console.log(formData)
  }  

  SaveOrUpdateProduct(productForm){
    if(this.oldProduct !== undefined){
      console.log("if :SaveOrUpdateProduct");
      let observableResult = this.projectService.SaveOrUpdateProduct(this.product);
      observableResult.subscribe((result:any)=>{
        if( result == "SUCCESS"){
          window.alert("PRODUCT DETAILS UPDATED SUCCESSFULLY!");
          this.router.navigate(['/product']);
        }
        else{
          window.alert("FAILED TO UPDATE PRODUCT DETAILS!");
          this.router.navigate(['/addProduct']);
        }
      });
    }else{
      //this.product.image.append('image', this.fileData)
      console.log("else : ")
      const formData = new FormData();
      formData.append('name', this.product. name);
      formData.append('gtin', this.product. gtin);
      formData.append('category', this.product. category);
      formData.append('material', this.product. material);
      formData.append('shape', this.product. shape);
      formData.append('finish', this.product. finish);
      formData.append('image', this.product.image);
      formData.append('description', this.product. description);
      formData.append('price', this.product.price.toString());

//      formData.append('file', this.fileData);
//      console.log("l = "+Object.keys(formData.get('file')).length)

      console.log("else :SaveOrUpdateProduct");
//      let product = productForm.form.value;
//      console.log("product.name : "+product.name)
//      product.image = this.fileData
      console.log("product : "+this.product.name)
      // console.log("image : "+product.image.name)
      // console.log("length : "+product.image.size)
      this.product.image = this.fileData
      let observableResult = this.projectService.SaveOrUpdateProduct(formData);
      observableResult.subscribe((result:any)=>{
          window.alert("PRODUCT ADDED SUCCESSFULLY!");
          this.router.navigate(['/product']);
          }, err =>{
            console.log(err)
            window.alert("FAILED TO ADD PRODUCT!");
            this.router.navigate(['/addProduct']);
      });
    }

  }

}

