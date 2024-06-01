import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RegisterServiceService } from '../../services/register-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NavServiceService } from '../../services/nav-service.service';
import { Ofertante } from '../../models/ofertante';
import { User } from '../../models/user';
import { OfertanteServiceService } from '../../services/ofertante-service.service';
import { ConsumidorServiceService } from '../../services/consumidor-service.service';

@Component({
  selector: 'app-usuario-editar',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './usuario-editar.component.html',
  styleUrl: './usuario-editar.component.css'
})
export class UsuarioEditarComponent {

  user: User = {} as User;
  id: number = this.ruta2.snapshot.params["id"]


  constructor(private peticion: OfertanteServiceService, private ruta: Router, private nav: NavServiceService, private ruta2: ActivatedRoute, private pajaxCo: ConsumidorServiceService) { }

  onSubmit() {
    this.Modificar();
  }

  Modificar() {

    if (localStorage["rol"] == "ofertante") {



      this.peticion.editOfertante(this.user, this.id).subscribe(res => {

        
        console.log(res)

        this.ruta.navigate(["perfil-ofertante/"+res.id])





      })
    } else if (localStorage["rol"] == "consumidor") {

      this.pajaxCo.editConsumidor(this.user, this.id).subscribe(res => {

       
        console.log(res)

        this.ruta.navigate(["perfil-consumidor/"+res.id])





      })


  }

}

 


  ngOnInit() {
    

    if (localStorage["rol"] == "ofertante") {



      this.peticion.getOfertante(this.id).subscribe(res => {

        this.user = res
        console.log(res)

       





      })
    } else if (localStorage["rol"] == "consumidor") {

      this.pajaxCo.getConsumidor(this.id).subscribe(res => {

        this.user = res
        console.log(res)

     





      })

    }


  }








}



