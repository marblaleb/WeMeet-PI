import { Component } from '@angular/core';
import { Observable, map } from 'rxjs';
import { NavServiceService } from '../../services/nav-service.service';
import { Router, RouterLink } from '@angular/router';
import { AuthServiceService } from '../../services/auth-service.service';

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent {

 

  public id_usuario = localStorage["id"];
  public log: boolean = false
  public rol:string ="";
  public resLogin$?: Observable<any>;
  public resLogin = ({
    login: false,
    usuario: "",
    rol: "",
    id: localStorage["id"]

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

  ngOnInit() {





      


      console.log(this.resLogin)
    }
  

  

  logOut() {
    localStorage["JWT"] = ""
    localStorage["nombreUsuario"] = ""
    localStorage["id"]=""
    localStorage["rol"]=""
    this.resLogin.login=false;
    this.nav.establecerLogin({ login: false, usuario: "", rol: "" })
    



    this.ruta.navigate([""])
    //  window.location.reload();






  }



}
