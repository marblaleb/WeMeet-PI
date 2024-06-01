import { Foro } from "./foro";
import { User } from "./user";

export interface Mensaje {



        id: number,
        titulo: string,
        contenido: string,
        usuario_id: number,
        foro_id: number,
        foro: Foro,
        usuario: User
       
   
     
  
}
