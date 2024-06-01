import { Component } from '@angular/core';
import { Actividad } from '../../models/actividad';
import { ActividadServiceService } from '../../services/actividad-service.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { DatePipe } from '@angular/common';
import { ConsumidorServiceService } from '../../services/consumidor-service.service';
import { Consumidor } from '../../models/consumidor';
import { Observable, concatMap, forkJoin } from 'rxjs';
import { NavServiceService } from '../../services/nav-service.service';

@Component({
  selector: 'app-detalle-actividad',
  standalone: true,
  imports: [DatePipe, RouterLink],
  templateUrl: './detalle-actividad.component.html',
  styleUrl: './detalle-actividad.component.css'
})
export class DetalleActividadComponent {


  public id_usuario=localStorage["id"];
  public resLogin$?: Observable<any>;
  public resLogin = ({
    login: false,
    usuario: "",
    rol: "",
    id:0

  })


  evento: Actividad = {} as Actividad
  consumidor: Consumidor = {} as Consumidor;
  boton:boolean;
  ofertante:boolean=false;
  id_actividad!:number;

  constructor(private pajax: ActividadServiceService, private pajaxConsumidor: ConsumidorServiceService, private ruta: Router, private ruta2: ActivatedRoute, private nav: NavServiceService) {

    this.boton=false;

    if(localStorage["rol"]=="ofertante"){
      this.ofertante=true;
    }



    // var id_usuario=0;

    // this.resLogin$ = this.nav.ObtenerLogin$()
    // this.resLogin$.subscribe({
    //     next: res => {  
    //       console.log(res)             
    //       this.id_usuario=res.id;
    //     }

    // })

    


  }



  ngOnInit() {

    const id = this.ruta2.snapshot.params["id"]
    var id_user=parseInt(this.id_usuario);

    
    this.pajax.getActividad(id).subscribe( {
      
        next: res=>{
          this.evento = res
          this.id_actividad=res.id;
         for(var i of this.evento.consumidor){
      
                console.log(i.id, this.id_usuario)
          
                if(i.id == this.id_usuario){
                  this.boton=true;
                }
              }
            
            
            }
      
       })
        
       
  }





  AnadirConsumidor() {

    const id= this.id_usuario
    
    this.evento.consumidorId=id  

    console.log(id)


    this.pajax.updateActividad(this.evento).subscribe({
      next: res => {
        this.evento = res
        this.boton=true;
      }
    })
  }


  QuitarConsumidor() {
    throw new Error('Method not implemented.');
    }




    EliminarAct() {
      this.pajax.deleteActividad(this.evento.id).subscribe({
        
        next: res=>{ console.log(res)
          this.ruta.navigate(["perfil-ofertante/"+this.id_usuario])
        }
      })
    }
    




}









