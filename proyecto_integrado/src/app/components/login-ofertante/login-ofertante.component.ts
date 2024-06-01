import { Component } from '@angular/core';
import { LoginServiceService } from '../../services/login-service.service';
import { Router } from '@angular/router';
import { NavServiceService } from '../../services/nav-service.service';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login-ofertante',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login-ofertante.component.html',
  styleUrl: './login-ofertante.component.css'
})
export class LoginOfertanteComponent {

  email:string=""
  clave:string=""

  error:boolean=false;
  public resLogin$?: Observable<any>;
  public resLogin = ({
    login: false,
    usuario: "",
    rol: "",
    id:0

  })

  constructor(private peticion:LoginServiceService, private ruta:Router, private nav:NavServiceService){
    
  }

  onSubmit(){
    this.sendLogin();
  }

  sendLogin(){
    this.peticion.iniciarSesionOfertante(this.email, this.clave).subscribe(res=>{
      console.log(res)
  

      localStorage.setItem("nombreUsuario", res.usuario.userName)
      localStorage.setItem("JWT", res.token)
      localStorage.setItem("id", res.usuario.id)
      localStorage.setItem("rol", "ofertante")
      
      
      this.nav.establecerLogin({login:true, usuario: res.usuario.userName, rol: "ofertante", id: res.usuario.id}) 
      
      this.resLogin$ = this.nav.ObtenerLogin$()
      this.resLogin$.subscribe({
        next: res => {
          

          console.log(res)
          this.resLogin.login = true;
          this.resLogin.usuario = localStorage["nombreUsuario"]
          this.resLogin.rol = res.rol
          this.resLogin.id= res.id

          
         




        },

        error: err=>{
          this.error=true;
        }
      })

      this.ruta.navigate(["perfil-ofertante/"+res.usuario.id])
     
    
      
     

      


     

  })
  }


}
