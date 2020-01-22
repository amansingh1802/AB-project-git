import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../project.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email='';
  password='';
  message;
  username;

  constructor(private projectService:ProjectService, private router:Router) { }

  ngOnInit() {
    if(localStorage.getItem("username")!= null){
      localStorage.removeItem("username");
      localStorage.removeItem("isActive");
    }
  }

  Login(formdata)
  {
    let user = formdata.form.value;
    console.log("user = "+user);

    let observableResult = this.projectService.ValidateUser(user);

    observableResult.subscribe((result:any)=>{

      console.log("res");
      if(result !== undefined )
      {
        console.log("login.component.ts, result = "+result.name);
        localStorage.setItem("username", user.email);
        localStorage.setItem("isActive","1");
        localStorage.setItem("role", result.role);
        console.log("username : "+localStorage.getItem("username"));
        if(user.role == 'ADMIN')
          this.router.navigate(['/admin']);
        else if(user.role == 'VENDOR')
          this.router.navigate(['/vendor']);
        this.router.navigate(['/home']);
      }
      else{
        this.message = "UserName or Password is Invalid";
        this.router.navigate(['/login']);
      }
    },(error)=>{
      window.alert("Invalid Username or Password...");
      this.router.navigate(['/login']);
    });
  }

  Register(){
    this.router.navigate(['/register']);
  }
  GoToHome(){
    this.router.navigate(['/home']);
  }

}
