import { Injectable } from '@angular/core';
import { Oferta } from '../models/oferta';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OfertaServiceService {

  url: string = "http://localhost:9001/api/ofertas"



  constructor(private http: HttpClient) { }

  listarOfertas() {
    return this.http.get<any>(this.url, this.getHttpHeaders())
    // return this.http.get<Actividad[]>(this.url+"/list").pipe(map(res=>res));
  }

  createOferta(oferta: Oferta) {

    const pa = JSON.stringify({
      "titulo": oferta.titulo,
      "descripcion": oferta.descripcion,
      "ofertante_id": oferta.ofertante_id,
      "consumidor_id": oferta.consumidor_id

    })

    console.log(pa)


    return this.http.post<Oferta>(this.url, pa, this.getHttpHeaders())



  }

  getOferta(id: number) {
    return this.http.get<any>(this.url + "/" + id, this.getHttpHeaders())
  }

  deleteActividad(id:number){
    return this.http.delete<any>(this.url+"/"+id, this.getHttpHeaders())
  }

  getHttpHeaders() {
    const token = localStorage.getItem('JWT');

    return {
      headers: new HttpHeaders({
        'Content-Type': 'application/json; charset=utf-8',
        Authorization: `Bearer ${token}`
      })
    };
  }

}
