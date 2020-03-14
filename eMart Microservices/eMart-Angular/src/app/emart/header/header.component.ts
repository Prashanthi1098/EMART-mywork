import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { EmartService } from '../emart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  currentBuyer: any;
  constructor(protected loginService: LoginService, protected emartService: EmartService) { }

  ngOnInit(): void {
    this.currentBuyer = this.emartService.getCurrentBuyer();
  }

//----------validating login------//
  getLoggedIn() {
    return this.loginService.loggedIn;

  }
}
