import { Component } from '@angular/core';
import { User } from '../../models/user';
import { RegisterServiceService } from '../../services/register-service.service';
import { Router, RouterLink } from '@angular/router';
import { NavServiceService } from '../../services/nav-service.service';
import { FormsModule } from '@angular/forms';
import { Ofertante } from '../../models/ofertante';

@Component({
  selector: 'app-register-ofertante',
  standalone: true,
  imports: [RouterLink, FormsModule],
  templateUrl: './register-ofertante.component.html',
  styleUrl: './register-ofertante.component.css'
})
export class RegisterOfertanteComponent {


  user: Ofertante= {} as Ofertante;
  imagenPerfil!: File;

  id!: number;
  error:boolean=false;
  

  constructor(private peticion:RegisterServiceService, private ruta:Router, private nav:NavServiceService){}

  onSubmit(){
    this.Register();
  }

  Register(){
    console.log(this.imagenPerfil)
    this.peticion.registroOfertante(this.user).subscribe({  
      
      
      next: res=>{

        if (this.imagenPerfil != undefined) {
          console.log(res)

          this.peticion.addImagen(this.imagenPerfil, res.usuario.id).subscribe(res => {


            this.ruta.navigate([""])
          })

        }else{

          this.ruta.navigate([""])

        }
        
      },

      error: err=>{

        this.error=true;
      }

        
  
        

     
     
  })
  }

  onFileSelected(event: any) {
    this.imagenPerfil = event.target.files[0];
  }



  


}
