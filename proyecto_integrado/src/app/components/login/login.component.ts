import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { LoginServiceService } from '../../services/login-service.service';
import { NavServiceService } from '../../services/nav-service.service';
import { AuthServiceService } from '../../services/auth-service.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterLink, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  email: string = ""
  clave: string = ""
  error: boolean = false;
  public resLogin$?: Observable<any>;
  public resLogin = ({
    login: false,
    usuario: "",
    rol: "",
    id: 0

  })

  constructor(private peticion: LoginServiceService, private ruta: Router, private nav: NavServiceService, private auth: AuthServiceService) {

  }

  onSubmit() {
    this.sendLogin();
  }

  sendLogin() {
    this.peticion.iniciarSesion(this.email, this.clave).subscribe({

      next: res => {
        console.log(res)


        localStorage.setItem("nombreUsuario", res.usuario.userName)
        localStorage.setItem("JWT", res.token)
        localStorage.setItem("id", res.usuario.id)
        localStorage.setItem("rol", "consumidor")



        this.nav.establecerLogin({ login: true, usuario: res.usuario.userName, rol: "consumidor", id: res.usuario.id })



        this.ruta.navigate(["perfil-consumidor/" + res.usuario.id])


      },

      error: err => {
        this.error = true

      }










    })
  }

}


