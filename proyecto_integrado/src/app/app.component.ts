import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { NavComponent } from './components/nav/nav.component';
import { NavServiceService } from './services/nav-service.service';
import { AuthServiceService } from './services/auth-service.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NavComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'proyecto_integrado';
  public id_usuario = 0;
  public log: boolean = false
  public rol:string ="";
  public resLogin$?: Observable<any>;
  public resLogin = ({
    login: false,
    usuario: "",
    rol: "",
    id:0

  })

  constructor(private nav: NavServiceService, private ruta: Router, private auth: AuthServiceService) {

    if ((!localStorage.getItem('JWT')) || ((localStorage.getItem('JWT')) && (localStorage['JWT'].split(".").length != 3))) {
      this.resLogin = { login: false, usuario: "", rol: "", id:0 }
    } else {     


      this.resLogin.login = true;
      this.resLogin.usuario = localStorage["nombreUsuario"]
      this.resLogin.rol = localStorage["rol"]
      this.resLogin.id= localStorage["id"]
     
      this.resLogin$ = this.nav.ObtenerLogin$()
      this.resLogin$.subscribe({
        next: res => {
          

          console.log(res)
          this.resLogin.login = true;
          this.resLogin.usuario = localStorage["nombreUsuario"]
          this.resLogin.rol = res.rol
          this.resLogin.id= res.id

          




        }
      })

      // location.reload();
  }


}

}
