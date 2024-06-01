import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Ofertante } from '../models/ofertante';

@Injectable({
  providedIn: 'root'
})
export class OfertanteServiceService {

  url:string="http://localhost:9001/api/ofertante"

  constructor(private http: HttpClient) { }

  listarOfertante(){
    return this.http.get<Ofertante[]>(this.url)
  }

  addOfertante(ofertante: Ofertante){
    return this.http.post<Ofertante>(this.url, ofertante, this.getHttpHeaders())
  }

  editOfertante(ofertante:Ofertante, id_ofertante:number){
    const pa=JSON.stringify({
      "id": id_ofertante,
      "nombre" : ofertante.nombre,
      "apellidos" : ofertante.apellidos,
      "email" : ofertante.email,
      "ciudad": ofertante.ciudad,
      "telefono" : ofertante.telefono      
    })
    console.log(pa)
    console.log(this.url+"/"+id_ofertante)
    return this.http.patch<Ofertante>(this.url+"/"+id_ofertante, pa, this.getHttpHeaders())
  }

  deleteOfertante(id:number){
    return this.http.delete<any>(this.url+"/"+id, this.getHttpHeaders())
  }

  getOfertante(id:number){
    return this.http.get<any>(this.url+"/"+id, this.getHttpHeaders())
  }


  getHttpHeaders() {
    const token = localStorage.getItem('JWT');
    
    return {
      headers: new HttpHeaders({
        'Content-Type':'application/json; charset=utf-8',
        Authorization: `Bearer ${token}`,
      
      })     
    };
  }
}
