import { Component } from '@angular/core';
import { OfertanteServiceService } from '../../services/ofertante-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Ofertante } from '../../models/ofertante';
import { Oferta } from '../../models/oferta';
import { FormsModule } from '@angular/forms';
import { OfertaServiceService } from '../../services/oferta-service.service';

@Component({
  selector: 'app-ofertantes-panel',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './ofertantes-panel.component.html',
  styleUrl: './ofertantes-panel.component.css'
})
export class OfertantesPanelComponent {


  ofertantes: Ofertante[] = [];
  mostrarVentana:boolean=false;
  oferta:Oferta={} as Oferta;

  public id = this.ruta2.snapshot.params["id"]

  constructor(private pajax: OfertanteServiceService, private ruta: Router, private ruta2: ActivatedRoute, private ofertaS: OfertaServiceService) {

    



    this.pajax.listarOfertante().subscribe(res => {

      this.ofertantes = res
      console.log(res)





    })


  }

  borrarOfertante(id:number){

    this.pajax.deleteOfertante(id).subscribe(res => {

      this.ofertantes = res
      console.log(res)





    })


  }

  cancelar() {
    this.mostrarVentana=false;
    
  }

  asignarIdOfertante(id:number){

    console.log(id);

    this.oferta.ofertante_id=id;
    this.mostrarVentana=true;
  }



  lanzarOferta(){

    this.oferta.consumidor_id=localStorage["id"];
    this.ofertaS.createOferta(this.oferta).subscribe({
        
      next: res=>{
        console.log(res);
        this.mostrarVentana=false;
      }
    })
    

    

  }



  ngOnInit() {

    





  }






}
