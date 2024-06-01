import { Component } from '@angular/core';
import { ForoServiceService } from '../../services/foro-service.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { NavServiceService } from '../../services/nav-service.service';
import { Mensaje } from '../../models/mensaje';
import { Observable } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { Foro } from '../../models/foro';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-foro-detalle',
  standalone: true,
  imports: [RouterLink, FormsModule, DatePipe],
  templateUrl: './foro-detalle.component.html',
  styleUrl: './foro-detalle.component.css'
})
export class ForoDetalleComponent {




  public id_foro = this.ruta2.snapshot.params["id"];
  public id_usuario=localStorage["id"]
  public foro: Foro= {} as Foro;

  mensajes!: Mensaje[]

  mensajeNuevo: Mensaje={} as Mensaje
  public id:number =localStorage["id"];
  public resLogin$?: Observable<any>;
  public resLogin = ({
    login: false,
    usuario: "",
    rol: "",
    id: 0

  })

  constructor(private nav: NavServiceService, private ruta: Router, private pajax: ForoServiceService, private ruta2: ActivatedRoute ) {
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

    

   

    this.pajax.listarMensajes(this.id_foro).subscribe(res => {
    
      this.mensajes = res; 
      console.log(res)    


    })

    this.pajax.getForo(this.id_foro).subscribe(res=>{

      console.log(res)

      this.foro=res;
    })


  }



  crearMensaje(){

    this.mensajeNuevo.foro_id=this.id_foro;
    this.mensajeNuevo.usuario_id=this.id_usuario;
    this.mensajeNuevo.titulo="Mensaje"
    
    this.pajax.crearMensaje(this.mensajeNuevo).subscribe({

      next: res=>{
        console.log(res);
        this.mensajes.push(res);
      }
    })


  }

  reply(mensaje:string) {
    this.mensajeNuevo.contenido=mensaje;
  }


  



}
