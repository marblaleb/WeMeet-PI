import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Consumidor } from '../models/consumidor';
import { UsuarioEditarComponent } from '../components/usuario-editar/usuario-editar.component';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class ConsumidorServiceService {

  url:string="http://localhost:9001/api/consumidor"

  constructor(private http: HttpClient) { }

  listarConsumidor(){
    return this.http.get<Consumidor[]>(this.url)
  }

  addConsumidor(consumidor: Consumidor){
    return this.http.post<Consumidor>(this.url, consumidor, this.getHttpHeaders())
  }



  editConsumidor(consumidor:User, id_co:number){
    const pa=JSON.stringify({
      "id": id_co,
      "nombre" : consumidor.nombre,
      "apellidos" : consumidor.apellidos,
      "email" : consumidor.email,
      "ciudad": consumidor.ciudad,
      "telefono" : consumidor.telefono      
    })
    console.log(pa)
    console.log(this.url+"/"+id_co)
    return this.http.patch<Consumidor>(this.url+"/"+id_co, pa, this.getHttpHeaders())
  }

  deleteConsumidor(id:number){
    return this.http.delete<any>(this.url+"/"+id, this.getHttpHeaders())
  }

  getConsumidor(id:number){
    return this.http.get<any>(this.url+"/"+id, this.getHttpHeaders())
  }

  

 


  getHttpHeaders() {
    const token = localStorage.getItem('JWT');
    
    return {
      headers: new HttpHeaders({
        'Content-Type':'application/json; charset=utf-8',
        Authorization: `Bearer ${token}`
      })     
    };
  }
}
