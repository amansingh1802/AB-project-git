import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectService } from '../project.service';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  previousPassword;
  message1="";
  message2="";
  message3="";
  message4="";
  user={
    name:"",
    email:"",
    password:"",
    address:"",
    mobileNo:"",
    role:""
  };

  constructor(private router:Router, private projectService:ProjectService) { }

  ngOnInit() {
    let observableResult = this.projectService.GetPassword(localStorage.getItem("username"));
    observableResult.subscribe((result:any)=>{
      this.previousPassword = result.password;
      this.user.name = result.name;
      this.user.address = result.address;
      this.user.mobileNo = result.mobileNo;
      this.user.role = result.role;
    });
    
  }

  GetPassword(myForm){
    this.message1="";
    this.message2="";
    this.message3="";
    this.message4="";
    let formData = myForm.form.value;
    console.log(formData);
    if(formData.oldPassword === ""){
      this.message1 = "ENTER OLD PASSWORD...";
    }else if(this.previousPassword === formData.oldPassword){
      if(formData.newPassword == ""){
        this.message4 = "ENTER NEW PASSWORD";
      }else if(formData.confirmPassword != ""
        && formData.newPassword === formData.confirmPassword){
        
        this.user.email = localStorage.getItem("username");
        this.user.password = formData.newPassword;
        let observableResult = this.projectService.ChangePassword(this.user);
        observableResult.subscribe((result:any)=>{
          if(result === "SUCCESS")
            window.alert("PASSWORD CHANGED SUCCESSFULLY!!!");
          else if(result === "FAILURE")
            this.message3 = "FAILED TO CHANGE PASSWORD!!!";
          else
            this.message3 = "SOMETHING WENT WRONG!!!";
        });
      }else{
        this.message2 = "PASSWORD DOESN'T MATCH...";
      }
    }else{
      this.message1 = "INVALID PASSWORD...";
    }
    this.router.navigate(['/changePassword']);
  }

  GoToHome(){
    this.router.navigate(['/home']);
  }

}
