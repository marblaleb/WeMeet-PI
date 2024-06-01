import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { Consumidor } from '../models/consumidor';
import { Ofertante } from '../models/ofertante';

@Injectable({
  providedIn: 'root'
})
export class RegisterServiceService {

  constructor(private http:HttpClient) {
    
   }

  url:string="http://localhost:9001/api/v1/auth/register"
  
  


  registro(user: Consumidor){
    const pa=JSON.stringify({
      firstName : user.nombre,
      lastName : user.apellidos,
      email : user.email,
      password : user.password,      
    })

   

    console.log(pa)

     return this.http.post<any>(this.url, pa, this.getJsonHeader())
  }


  registroOfertante(user:Ofertante){
    const pa=JSON.stringify({
      firstName : user.nombre,
      lastName : user.apellidos,
      email : user.email,
      password : user.password
    })

    console.log(pa)

     return this.http.post<any>(this.url+"/ofertante", pa, this.getJsonHeader())
  }

  addImagen(file: File, id: number){
    const formData = new FormData();
    formData.append('file', file);

      return this.http.post<any>('http://localhost:9001/api/v1/auth/imagen/'+id, formData)
  }


  getUserImage(imageName: string) {
    return this.http.get(`http://localhost:9001/api/images/${imageName}`, { responseType: 'blob' });
  }

  



 

  getJsonHeader(){

    return {
      headers: new HttpHeaders({'Content-Type':'application/json; charset=utf-8'})
    }
           

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
