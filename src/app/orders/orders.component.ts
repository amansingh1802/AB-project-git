import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProjectService } from '../project.service';


@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  role;
  constructor(private router:Router,
              private projectService:ProjectService,
              private route:ActivatedRoute) { }

  ngOnInit() {
    this.role = localStorage.getItem("role");
    this.route.paramMap.subscribe((parameter:any)=>{
      let userEmail = parameter.get("userEmail");
    });
  }

  LoginFirst()
  {
    this.router.navigate(["/login"]);
  }

}
