import { Component } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { ConsumidorServiceService } from '../../services/consumidor-service.service';
import { Consumidor } from '../../models/consumidor';
import { RegisterServiceService } from '../../services/register-service.service';
import { DatePipe, DecimalPipe } from '@angular/common';
import { Observable } from 'rxjs';
import { NavServiceService } from '../../services/nav-service.service';

@Component({
  selector: 'app-perfil-consumidor',
  standalone: true,
  imports: [RouterLink, DecimalPipe, DatePipe],
  templateUrl: './perfil-consumidor.component.html',
  styleUrl: './perfil-consumidor.component.css'
})
export class PerfilConsumidorComponent {



  consumidor: Consumidor = {} as Consumidor
  borrar: boolean = false;
  // id: number = this.ruta2.snapshot.params["id"]
  id: number = localStorage["id"]

  public resLogin$?: Observable<any>;
  public resLogin = ({
    login: false,
    usuario: "",
    rol: "",
    id: localStorage["id"]

  })

  constructor(private pajax: ConsumidorServiceService, private nav: NavServiceService, private ruta: Router, private ruta2: ActivatedRoute, private peticion: RegisterServiceService) {
   



    this.pajax.getConsumidor(this.id).subscribe(res => {

      this.consumidor = res

      if (this.consumidor.imagenPerfil) {

        this.getUserImage();
      }





    })

  }



  ngOnInit() {





  }


  getUserImage() {

    this.peticion.getUserImage(this.consumidor.imagenPerfil).subscribe(
      (data) => {
        const reader = new FileReader();
        reader.onload = (e: any) => {
          this.consumidor.imagenPerfil = e.target.result;
        };
        reader.readAsDataURL(data);
      },
      (error) => {
        console.error('Error al obtener la imagen:', error);
      }
    );

  }


  borrarVentana() {

    console.log(this.borrar)

    this.borrar = !this.borrar;

  }

  borrarUsuario() {

    this.pajax.deleteConsumidor(this.id).subscribe({

      next: res=>{
        localStorage["JWT"] = ""
        localStorage["nombreUsuario"] = ""
        localStorage["id"]=""
        localStorage["rol"]=""
        this.resLogin.login=false;
        this.nav.establecerLogin({ login: false, usuario: "", rol: "" })
        
    
    
    
        this.ruta.navigate([""])



      }

        
        


    })
    

  }

}
