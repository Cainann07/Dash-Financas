import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { TelaInicialComponent } from './pages/tela_inicial/tela_inicial.component';

export const routes: Routes = [
    { path: '', redirectTo: 'tela_inicial', pathMatch: 'full' }, // Redireciona a home para o login
    { path: 'tela_inicial', component: TelaInicialComponent }
];
