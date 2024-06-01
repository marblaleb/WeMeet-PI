import { Component } from '@angular/core';
import { Actividad } from '../../models/actividad';
import { ActividadServiceService } from '../../services/actividad-service.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { DatePipe, DecimalPipe } from '@angular/common';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-index',
  standalone: true,
  imports: [RouterLink, DecimalPipe, DatePipe],
  templateUrl: './index.component.html',
  styleUrl: './index.component.css'
})
export class IndexComponent {

  public log: boolean=false
  public resLogin$?: Observable<any>;
  public resLogin=({
    login:false,
    usuario:""
  })

  eventos?:Actividad[]

  constructor(private pajax:ActividadServiceService, private ruta:Router, private ruta2:ActivatedRoute){
  
  }

  

  ngOnInit(){

    if ((!localStorage.getItem('JWT')) || ((localStorage.getItem('JWT')) && (localStorage['JWT'].split(".").length != 3))) {
      this.resLogin={login: false, usuario:""}
    }else{
      this.resLogin.login=true,
      this.resLogin.usuario=localStorage["nombreUsuario"]

    }

    
  
  

  }






}
