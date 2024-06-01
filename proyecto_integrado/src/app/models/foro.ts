import { Actividad } from "./actividad";
import { Consumidor } from "./consumidor";
import { Mensaje } from "./mensaje";
import { Ofertante } from "./ofertante";

export interface Foro {

     id: number,
     nombre: string,
     descripcion: string,
     ofertante: Ofertante,
     actividad: Actividad,
     consumidores: Consumidor[],
     mensajes: Mensaje[]

  
}
