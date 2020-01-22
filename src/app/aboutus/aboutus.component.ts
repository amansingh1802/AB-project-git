import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-aboutus',
  templateUrl: './aboutus.component.html',
  styleUrls: ['./aboutus.component.css']
})
export class AboutusComponent implements OnInit {
  welcomeMessage;
  
 constructor() { }

  ngOnInit() {
    this.welcomeMessage = localStorage.getItem("username");
  }

}
