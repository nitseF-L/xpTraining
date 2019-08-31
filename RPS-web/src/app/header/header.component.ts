import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  showSideNav: boolean = false;


  constructor() { }

  ngOnInit() {
  }

  toggleSidenav(){
    this.showSideNav = !this.showSideNav;
    console.log(this.showSideNav);
  }

}
