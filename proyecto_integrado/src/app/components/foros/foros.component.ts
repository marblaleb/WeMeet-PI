import { Component } from '@angular/core';
import { NavServiceService } from '../../services/nav-service.service';
import { Router, RouterLink } from '@angular/router';
import { Observable } from 'rxjs';
import { ConsumidorServiceService } from '../../services/consumidor-service.service';
import { Consumidor } from '../../models/consumidor';
import { OfertanteServiceService } from '../../services/ofertante-service.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-foros',
  standalone: true,
  imports: [RouterLink, DatePipe],
  templateUrl: './foros.component.html',
  styleUrl: './foros.component.css'
})
export class ForosComponent {

  public log: boolean = false
  public id:number =localStorage["id"];
  public resLogin$?: Observable<any>;
  public resLogin = ({
    login: false,
    usuario: "",
    rol: "",
    id: 0

  })

  public usuario={} as Consumidor

  constructor(private nav: NavServiceService, private ruta: Router, private pajax: OfertanteServiceService, private pajaxConsumer: ConsumidorServiceService) {
    if ((!localStorage.getItem('JWT')) || ((localStorage.getItem('JWT')) && (localStorage['JWT'].split(".").length != 3))) {
      this.resLogin = { login: false, usuario: "", rol: "", id:0 }
    } else {
      
     
      this.resLogin$ = this.nav.ObtenerLogin$()
      this.resLogin$.subscribe({
        next: res => {

          this.resLogin.rol = res.rol
          this.resLogin.id=res.id
          this.id=res.id

          



     

        }
      })

    }

  }

  ngOnInit() {  
    
    if(localStorage["rol"]=="ofertante"){

      this.pajax.getOfertante(this.id).subscribe(res => {
      
        this.usuario = res; 
        console.log(res)    
  
  
      })

    }else if(localStorage["rol"]=="consumidor"){

      this.pajaxConsumer.getConsumidor(this.id).subscribe(res=>{

        this.usuario=res;
        console.log(res)
      })
    }


    }



  }







