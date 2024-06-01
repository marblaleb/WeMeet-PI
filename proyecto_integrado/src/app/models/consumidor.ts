import { Actividad } from "./actividad";
import { Foro } from "./foro";
import { Oferta } from "./oferta";

export interface Consumidor {

    id:number,
    userName:string,
    password:string,
    email:string,
    nombre: string,
    apellidos:string,
    activo: boolean,
    actividades: Actividad[],
    imagenPerfil: string,
    foro: Foro[],
    telefono: string,
    ciudad: string,
    ofertas: Oferta[]

    
}
