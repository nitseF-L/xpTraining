import { Component, OnInit, Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  
@Output() closeSideNav : EventEmitter<void> = new EventEmitter<void>();
  constructor() { }

  ngOnInit(): void {
   console.log("opened side bar component")
  }

}
