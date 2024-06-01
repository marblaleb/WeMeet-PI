import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  
  public userRoleSubject: Subject<string>;
  public rol:string;
 


  constructor() {
    this.userRoleSubject = new Subject<string>;
    this.rol="";
   
    
  }

  setUserRole(role: string) {

    this.rol=role;          
    this.userRoleSubject.next(this.rol);
    
  }

  getUserRole(): Observable<string> {
    return this.userRoleSubject.asObservable();
  }

  clearUserRole() {
    this.userRoleSubject.next("");
  }


}
