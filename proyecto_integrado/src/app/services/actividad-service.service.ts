import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Actividad } from '../models/actividad';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ActividadServiceService {

  url:string="http://localhost:9001/api/actividad"

 

  constructor(private http: HttpClient) { }

  listarActividad(){
    return this.http.get<any>(this.url, this.getHttpHeaders())
    // return this.http.get<Actividad[]>(this.url+"/list").pipe(map(res=>res));
  }

  addActividadv(actividad: Actividad){

    const pa=JSON.stringify({   
      "nombre": actividad.nombre,
      "descripcion": actividad.descripcion,
      "fecha":actividad.fecha,
      "hora": actividad.hora,
      "lugar": actividad.lugar,
      "tarifa": actividad.tarifa,
      "dificultad": actividad.dificultad,
      "ofertanteid": 1
     
    })

    console.log(pa)


    return this.http.post<Actividad>(this.url, pa, this.getHttpHeaders())
  }

  editActividad(actividad:Actividad){

    const pa=JSON.stringify({
      "id": actividad.id,   
      "nombre": actividad.nombre,
      "descripcion": actividad.descripcion,
      "fecha":actividad.fecha,
      "hora": actividad.hora,
      "lugar": actividad.lugar,
      "tarifa": actividad.tarifa,
      "dificultad": actividad.dificultad,
      "consumidor": actividad.consumidor,
      "ofertanteid": actividad.ofertante.id,
      
     
    })

    console.log(pa)
    
    return this.http.patch<Actividad>(this.url+"/"+actividad.id, pa, this.getHttpHeaders())
  }


  updateActividad(actividad:Actividad){

    const pa=JSON.stringify({
      "id": actividad.id,   
      "nombre": actividad.nombre,
      "descripcion": actividad.descripcion,
      "fecha":actividad.fecha,
      "hora": actividad.hora,
      "lugar": actividad.lugar,
      "tarifa": actividad.tarifa,
      "dificultad": actividad.dificultad,
      "consumidor": actividad.consumidor,
      "ofertanteid": actividad.ofertante.id,
      "consumidorid": actividad.consumidorId
      
     
    })

    console.log(pa)
    
    return this.http.put<Actividad>(this.url+"/update/"+actividad.id, pa, this.getHttpHeaders())
  }

  deleteActividad(id:number){
    return this.http.delete<any>(this.url+"/"+id, this.getHttpHeaders())
  }


  getActividad(id:number){
    return this.http.get<any>(this.url+"/"+id, this.getHttpHeaders())
  }

  getCategorias(){
    return this.http.get<any>(this.url+"/categorias", this.getHttpHeaders())

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
