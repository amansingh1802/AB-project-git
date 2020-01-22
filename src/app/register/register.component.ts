import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../project.service';
import { Router} from '@angular/router';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  role='';
  usr:any; 
  message;

  constructor(private projectService:ProjectService, private router:Router) { }

  ngOnInit() {
/*     setTimeout(() => {
      this.router.navigate)(['/home']);
    }, 2000); */
  }
  
  async Register(formdata)
  {
    let user = formdata.form.value;
    console.log("Register.Component.ts, user = "+user);

    if(this.role=="VENDOR")
    {
      console.log("VENDOR");
      var myWindow = window.open("", "", "width=200, height=100");
      myWindow.document.write("<p>This is 'myWindow'</p>");
      setTimeout(function(){ myWindow.close() }, 3000);
      this.router.navigate(['/registorvendor']);
    }    
    else if(this.role=="CUSTOMER")
    {
      console.log("CUSTOMER");
      let observableResult = await this.projectService.Register(user);
      console.log(observableResult);
      observableResult.subscribe((result : any)=>{
          if(result !== undefined)
          {
            this.message = "User registered successfully!";
            this.router.navigate(['/register']);
          }
          else
          {
            this.message = "User registration failed!";
            this.router.navigate(['/register']);
          }
      });
    }
  }

  GoToHome(){
    this.router.navigate(['/home']);
  }
}
