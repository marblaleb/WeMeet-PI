import { Component } from '@angular/core';
import { Actividad } from '../../models/actividad';
import { ActividadServiceService } from '../../services/actividad-service.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { NavServiceService } from '../../services/nav-service.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-editar-actividad',
  standalone: true,
  imports: [FormsModule, RouterLink],
  templateUrl: './editar-actividad.component.html',
  styleUrl: './editar-actividad.component.css'
})
export class EditarActividadComponent {

  evento: Actividad = {} as Actividad;
  id: number = this.ruta2.snapshot.params["id"]


  constructor(private peticion: ActividadServiceService, private ruta: Router, private nav: NavServiceService, private ruta2: ActivatedRoute) { }

  onSubmit() {
    this.Modificar();
  }

  Modificar() {





    this.peticion.editActividad(this.evento).subscribe(res => {


      console.log(res)

      this.ruta.navigate(["actividad-detalle/" + res.id])





    })





  }




  ngOnInit() {


    if (localStorage["rol"] == "ofertante") {



      this.peticion.getActividad(this.id).subscribe(res => {

        this.evento = res
        console.log(res)







      })



    }
  }

}
