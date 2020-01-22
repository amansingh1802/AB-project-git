import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../project.service';
import { from } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  welcomeMessage:string;
  isActive:string;
  role:string;

  constructor(private projectService:ProjectService ) { }

  ngOnInit() {
    this.welcomeMessage = "Welcome, "+localStorage.getItem("username");
    this.isActive = localStorage.getItem("isActive");
    this.role = localStorage.getItem('role')
  }

}
