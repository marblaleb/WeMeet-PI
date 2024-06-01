import { Component } from '@angular/core';
import { Actividad } from '../../models/actividad';
import { ActividadServiceService } from '../../services/actividad-service.service';
import { Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Categoria } from '../../models/categoria';

@Component({
  selector: 'app-registro-act',
  standalone: true,
  imports: [FormsModule, RouterLink],
  templateUrl: './registro-act.component.html',
  styleUrl: './registro-act.component.css'
})
export class RegistroActComponent {

  evento: Actividad= {} as Actividad;
  id:number=localStorage["id"];

  categorias: Categoria[]=[];
  error:boolean=false;

  constructor(private peticion:ActividadServiceService, private ruta:Router){}

  ngOnInit(){

    this.peticion.getCategorias().subscribe(res=>{
      console.log(res)
      this.categorias=res;
    })
  }

  registro_actividad(){
    
    this.Register();
  }

  Register(){
    console.log(this.evento)
    this.evento.ofertanteiD=this.id;
    this.peticion.addActividadv(this.evento).subscribe({   
      
      
      next: res=>{
        
      
        
        console.log(res)
        this.ruta.navigate(["perfil-ofertante/"+localStorage["id"]])
      
      },


      error: err=>{

        this.error=true;

      }
  
       
       


     
     
  })
  }

}
