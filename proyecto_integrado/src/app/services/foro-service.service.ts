import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Mensaje } from '../models/mensaje';

@Injectable({
  providedIn: 'root'
})
export class ForoServiceService {

  url:string="http://localhost:9001/api/foro"

 

  constructor(private http: HttpClient) { }

  listarMensajes(id_foro:number){
    return this.http.get<any>(this.url+"/mensajes/"+id_foro, this.getHttpHeaders())
    // return this.http.get<Actividad[]>(this.url+"/list").pipe(map(res=>res));
  }


  crearMensaje(mensaje: Mensaje){

    

      const pa=JSON.stringify({   
        "titulo": mensaje.titulo,
        "contenido": mensaje.contenido,
        "usuario_id":mensaje.usuario_id,
        "foro_id": mensaje.foro_id,
       
       
      })
  
      console.log(pa)
  
  
      return this.http.post<Mensaje>(this.url, pa, this.getHttpHeaders())
    }

    getForo(id:number){

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
