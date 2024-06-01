import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../models/login';
import { AuthServiceService } from './auth-service.service';
import { BehaviorSubject, catchError, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private http:HttpClient, private auth:AuthServiceService) { }

  url:string="http://localhost:9001/api/v1/auth/authenticate"
  user:Login={} as Login;

  


  iniciarSesion(email:string, clave:string){

  
    
    const pa=JSON.stringify({   
      email: email,
      password: clave
     
    })

    console.log(pa)
    

    return this.http.post<any>(this.url, pa, this.getJsonHeader())
  }

  iniciarSesionOfertante(email:string, clave:string){

  
    
    const pa=JSON.stringify({   
      email: email,
      password: clave
     
    })

    console.log(pa)
    

    return this.http.post<any>(this.url+"/ofertante", pa, this.getJsonHeader())
  }


  getJsonHeader(){

    return {
      headers: new HttpHeaders({'Content-Type':'application/json; charset=utf-8'})
    }
           

  }



  validarLogin(){
    return this.http.post<any>(this.url, '{"servicio:nada"}', this.getHttpHeaders())
  }


  getHttpHeaders() {
    const token = localStorage.getItem('JWT');
    return {
      headers: new HttpHeaders({
        Authorization: `Bearer ${token}`
      })     
    };
  }
}
