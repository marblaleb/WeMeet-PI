import { Categoria } from "./categoria";
import { Consumidor } from "./consumidor";
import { Foro } from "./foro";
import { Ofertante } from "./ofertante";

export interface Actividad {


    id:number,
    nombre:string,
    descripcion: string,
    fecha: Date,
    hora:String,
    duracion?: number,
    lugar:string,
    tarifa?:number,
    dificultad?:number;
    categorias?: Categoria[],
    consumidor: Consumidor[],
    consumidorId?: number,
    ofertante: Ofertante,
    ofertanteiD?: number,
    foro: Foro,
    categoria_id:number
   
}
