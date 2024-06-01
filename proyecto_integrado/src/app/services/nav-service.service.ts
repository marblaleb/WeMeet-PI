import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NavServiceService {

  private resLogin: Object;
  private resLogin$= new Subject<any>();

  constructor(){
    this.resLogin={login: false, usuario:"", rol: "", id: 0}
  }

  establecerLogin(res:Object){
    this.resLogin=res;
    this.resLogin$.next(this.resLogin);
  }

  ObtenerLogin$():Observable<any>{
    return this.resLogin$.asObservable();
  }
}
