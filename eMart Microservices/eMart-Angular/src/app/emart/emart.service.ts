import { Injectable } from '@angular/core';
import { Category } from './category';
import { SubCategory } from './sub-category';
import { Item } from './item';
import { Bill } from './bill';
import { Buyer } from './buyer';
import { Seller } from './seller';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({   
  providedIn: 'root'
})
export class EmartService {

  allItems: Item[];
  cartItems: Item[];
  allBills: any;
  allSellers: Seller[];
  currentBuyer: any;

  constructor(protected http: HttpClient) {
    this.cartItems = [];
    this.allBills = [];
  }

//------------Retrieving all Items---------//
  getAllItems() {
    return this.http.get("http://localhost:8083/buyer-item-service/emart/item/all");
  }

//------------Retrieving AllBills----------//
  getAllBills(): any {
    return this.allBills;
  }

//-----------storing Buyer and Bill details-------//
  setBuyerAndBills(currentBuyer) {
    this.currentBuyer = currentBuyer;
    this.allBills = currentBuyer.allBills;
  }

//----------Retrieving CurrentBuyer------------//
  getCurrentBuyer() {
    return this.currentBuyer;
  }

//-------------Retrieving particular Item from Database--------//
  getItem(itemId) {
    return this.http.get("http://localhost:8083/buyer-item-service/emart/item/" + itemId);
  }

 //-----------Adding an Item  to CartList-----//
  addToCart(item: any) {
    this.cartItems.push(item);
  }

  //-----------Retrieving CartListItems------//
  getAllCart() {
    return [].concat(this.cartItems);
  }

//---------Deleting Item from CartList--------//
  deleteCartItem(itemNo: number) {
    let size = this.cartItems.length;
    for (let i = 0; i < size; i++) {
      if (this.cartItems[i].id == itemNo) {
        this.cartItems.splice(i, 1);
        break;
      }
    }
  }

//----------Storing BillDetails------//
  addBill(todayDate: Date, total: number) {
    let allBillDetails: any = [];
    for (let i = 0; i < this.cartItems.length; i++) {
      allBillDetails.push({
        id: 0,
        billId: null,
        itemId: this.cartItems[i]

      });
    }
    let bill: any = {
      id: 0,
      type: 'Debit',
      date: todayDate,
      remarks: 'paid',
      amount: total,
      buyerId: {
        id: this.currentBuyer.id
      },
      allBillDetails: allBillDetails
    }
    this.cartItems = [];
    return this.http.post("http://localhost:8083/buyer-item-service/emart/bitem", bill);
  }

//----------Retrieving CurrentBuyer Data-------//
  getBuyer() {
    return this.http.get("http://localhost:8083/login-service/emart/buyer/" + this.currentBuyer.id);
  }

//----------Buyer validation----------//
  validateBuyer(user: string, password: string) {
    let credentials = user + ":" + password;
    let headers = new HttpHeaders();
    headers = headers.set("Authorization", credentials);
    return this.http.get("http://localhost:8083/login-service/emart/validate", { headers });
  }

//----------Seller Validation--------//
  validateSeller(user: string, password: string) {
    let seller: Seller;
    let size = this.allSellers.length;
    for (let i = 0; i < size; i++) {
      if (this.allSellers[i].username == user && this.allSellers[i].password == password) {
        seller = {
          id: this.allSellers[i].id,
          username: this.allSellers[i].username,
          password: this.allSellers[i].password,
          company: this.allSellers[i].company,
          brief: this.allSellers[i].brief,
          gst: this.allSellers[i].gst,
          address: this.allSellers[i].address,
          email: this.allSellers[i].email,
          website: this.allSellers[i].website,
          contact: this.allSellers[i].contact
        }
        break;
      }
    }
    return seller;
  }

}
