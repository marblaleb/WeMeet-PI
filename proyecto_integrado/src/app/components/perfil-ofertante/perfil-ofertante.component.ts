import { Component } from '@angular/core';
import { Ofertante } from '../../models/ofertante';
import { OfertanteServiceService } from '../../services/ofertante-service.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { DatePipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs';
import { NavServiceService } from '../../services/nav-service.service';
import { Oferta } from '../../models/oferta';
import { OfertaServiceService } from '../../services/oferta-service.service';

@Component({
  selector: 'app-perfil-ofertante',
  standalone: true,
  imports: [DatePipe, FormsModule, RouterLink],
  templateUrl: './perfil-ofertante.component.html',
  styleUrl: './perfil-ofertante.component.css'
})
export class PerfilOfertanteComponent {


  ofertante: Ofertante = {} as Ofertante
  ofertaAceptada: boolean=false;
  ofertas: Oferta[]=[];

  public resLogin$?: Observable<any>;
  public resLogin = ({
    login: false,
    usuario: "",
    rol: "",
    id: localStorage["id"]

  })

  borrar: boolean = false;
  id: number = this.ruta2.snapshot.params["id"]

  constructor(private pajax: OfertanteServiceService, private nav: NavServiceService, private ruta: Router, private ruta2: ActivatedRoute, private peticion: OfertaServiceService) {

    



    this.pajax.getOfertante(this.id).subscribe(res => {

      this.ofertante = res
      console.log(res)





    })

    this.listarOfertas();


  }

  aceptar() {
   
    this.ofertaAceptada=true;
    

  }


  borrarVentana() {

    this.borrar = !this.borrar;
    console.log(this.borrar)

  }

  borrarUsuario() {

    this.pajax.deleteOfertante(this.id).subscribe({

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

  listarOfertas(){

    this.peticion.getOferta(this.id).subscribe({

      next: res=>{

        console.log(res)

        this.ofertas=res;
      }
    })

  }





}



