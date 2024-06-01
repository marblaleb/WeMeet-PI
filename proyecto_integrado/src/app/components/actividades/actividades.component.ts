import { Component } from '@angular/core';
import { Actividad } from '../../models/actividad';
import { ActividadServiceService } from '../../services/actividad-service.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { DatePipe, DecimalPipe } from '@angular/common';

@Component({
  selector: 'app-actividades',
  standalone: true,
  imports: [RouterLink, FormsModule, DatePipe, DecimalPipe],
  templateUrl: './actividades.component.html',
  styleUrl: './actividades.component.css'
})
export class ActividadesComponent {

  eventos?:Actividad[]

  constructor(private pajax:ActividadServiceService, private ruta:Router, private ruta2:ActivatedRoute){
  
  }

  

  ngOnInit(){

    

    this.listarActividades()
  
  

  }

  listarActividades(){

    this.pajax.listarActividad().subscribe(res=>{
      console.log(res)
      this.eventos=res})
  }


}
