import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RegisterServiceService } from '../../services/register-service.service';
import { Router } from '@angular/router';
import { NavServiceService } from '../../services/nav-service.service';
import { User } from '../../models/user';
import { Consumidor } from '../../models/consumidor';

@Component({
  selector: 'app-register-consumidor',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register-consumidor.component.html',
  styleUrl: './register-consumidor.component.css'
})
export class RegisterConsumidorComponent {


  user: Consumidor = {} as Consumidor;

  imagenPerfil!: File;

  id!: number;

  error:boolean=false;





  constructor(private peticion: RegisterServiceService, private ruta: Router, private nav: NavServiceService) { }

  onSubmit() {
    this.Register();
  }

  Register() {


    this.peticion.registro(this.user).subscribe({

      next: res => {
        console.log(res)

        if (this.imagenPerfil != undefined) {

          this.peticion.addImagen(this.imagenPerfil, res.usuario.id).subscribe({


            next: res=>{
              this.ruta.navigate([""])
            }
          })

        }else{

          this.ruta.navigate([""])

        }

      },

      error: err=>{

        this.error=true

      }





    })

    // this.ruta.navigate([""])      
  }



  onFileSelected(event: any) {
    this.imagenPerfil = event.target.files[0];
  }

}
