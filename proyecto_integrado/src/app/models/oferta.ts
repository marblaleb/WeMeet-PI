import { Consumidor } from "./consumidor";
import { Ofertante } from "./ofertante";

export interface Oferta {

    id: number,
    titulo: string,
    descripcion: string,
    consumidor_id: number,
    ofertante_id: number,
    ofertante: Ofertante,
    consumidor: Consumidor;
}
