import { Routes } from '@angular/router';
import { IndexComponent } from './components/index/index.component';
import { ActividadesComponent } from './components/actividades/actividades.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterConsumidorComponent } from './components/register-consumidor/register-consumidor.component';
import { RegistroActComponent } from './components/registro-act/registro-act.component';
import { DetalleActividadComponent } from './components/detalle-actividad/detalle-actividad.component';
import { RegisterOfertanteComponent } from './components/register-ofertante/register-ofertante.component';
import { PerfilConsumidorComponent } from './components/perfil-consumidor/perfil-consumidor.component';
import { PerfilOfertanteComponent } from './components/perfil-ofertante/perfil-ofertante.component';
import { LoginOfertanteComponent } from './components/login-ofertante/login-ofertante.component';
import { ForosComponent } from './components/foros/foros.component';
import { ForoDetalleComponent } from './components/foro-detalle/foro-detalle.component';
import { OfertantesPanelComponent } from './components/ofertantes-panel/ofertantes-panel.component';
import { UsuarioEditarComponent } from './components/usuario-editar/usuario-editar.component';
import { EditarActividadComponent } from './components/editar-actividad/editar-actividad.component';

export const routes: Routes = [


    {
       path: "",
       component: IndexComponent

    },

    {

        path:"actividades",
        component: ActividadesComponent

    
    },

    {

        path:"login",
        component: LoginComponent

    
    },

    {

        path:"login-ofertante",
        component: LoginOfertanteComponent

    
    },

    {

        path:"register-consumidor",
        component: RegisterConsumidorComponent

    
    },

    {

        path:"register-ofertante",
        component: RegisterOfertanteComponent

    
    },

    {

        path:"reg-actividad",
        component: RegistroActComponent

    
    },

    {

        path:"actividad-detalle/:id",
        component: DetalleActividadComponent

    
    },

    {

        path:"perfil-consumidor/:id",
        component: PerfilConsumidorComponent

    
    },

    {

        path:"perfil-ofertante/:id",
        component: PerfilOfertanteComponent

    
    },

    {

        path:"foro",
        component: ForosComponent

    
    },
    {

        path:"foro-detalle/:id",
        component: ForoDetalleComponent

    
    }
    ,
    {

        path:"ofertantes-panel",
        component: OfertantesPanelComponent

    
    },
    {

        path:"editar-usuario/:id",
        component: UsuarioEditarComponent

    
    },
    {

        path:"editar-actividad/:id",
        component: EditarActividadComponent

    
    }
   


];
