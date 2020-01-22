import { Injectable } from '@angular/core';
import { CanActivate, RouterStateSnapshot, ActivatedRouteSnapshot, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
  import { from } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectService implements CanActivate {

//  url = "http://192.168.43.71:8084/project";

  constructor(private router:Router,
              private http:HttpClient) { }

  url = "http://localhost:8084/project";

  usr:any={};
  welcomeMessage;
  
//LOGIN HANDLER
  ValidateUser(user:any){
    return this.http.post(this.url+"/user/validate", user);
  }
  GetPassword(username:any){
    return this.http.post(this.url+"/user/getPassword", username);
  }
  ChangePassword(user:any){
    console.log("project.service.ts, :"+user);
    return this.http.post(this.url+"/user/changePassword", user);
  }

  canActivate(route:ActivatedRouteSnapshot, state:RouterStateSnapshot){
    if(this.IsLoggedIn()) 
      return true;
    else  
      this.router.navigate(['/login']); 
    return false;    
  }

  IsLoggedIn(){
    if(window.sessionStorage.getItem("isActive") != null && window.sessionStorage.getItem("isActive") == "1")
      return true;
    return false;
  }

  async Register(user:any){
    return this.http.post(this.url+"/user/register", user);
  }

//PRODUCT SERVICE HANDLERS
  SaveOrUpdateProduct(formData){
  //  console.log("ProjectService.SaveOrUpdateProduct()"+formData.image.size)
    return this.http.post(this.url+"/product/addProduct", formData);
  }
  GetProductById(productId){
    return this.http.get(this.url+"/product/"+productId);
  }
  DeleteProductById(productId){
    return this.http.post(this.url+"/product/deleteProductById", productId);
  }

//LOGOUT HANDLER
  Logout(){
    localStorage.removeItem("username");
    this.router.navigate(['/login']);
  }
}
