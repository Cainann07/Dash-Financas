import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { PassosIniciaisComponent } from './pages/passos_iniciais/passos_iniciais.component';
import { PaginaInicialComponent } from './pages/pagina_inicial/pagina_inicial.component';

export const routes: Routes = [
    { path: '', redirectTo: 'pagina_inicial', pathMatch: 'full' }, // Redireciona a home para o login
    // { path: 'meta_detalhes', component: MetaDetalhesComponent },
    { path: 'pagina_inicial', component: PaginaInicialComponent }

];
