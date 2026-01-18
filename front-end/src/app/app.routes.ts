import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { PassosIniciaisComponent } from './pages/passos_iniciais/passos_iniciais.component';
import { PaginaInicialComponent } from './pages/pagina_inicial/pagina_inicial.component';
import { CadastroComponent } from './pages/cadastro/cadastro.component';

export const routes: Routes = [
    { path: 'login', component: LoginComponent },
    // { path: 'meta_detalhes', component: MetaDetalhesComponent },
    { path: 'pagina_inicial', component: PaginaInicialComponent },
    { path: 'cadastro', component: CadastroComponent }

];
