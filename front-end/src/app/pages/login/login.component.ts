import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Button } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { PasswordModule } from 'primeng/password';
import { LottieComponent, AnimationOptions } from 'ngx-lottie';
import { UsuarioService } from '../../services/usuario';
import { Router, RouterLink } from '@angular/router';


@Component({
  selector: 'app-login',
  imports: [FormsModule, InputTextModule, RouterLink, Button, PasswordModule, LottieComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {

  options: AnimationOptions = {
    path: '/assets/animacao-dinheiro.json',
    loop: true,
    autoplay: true
  };

  dadosLogin = {
    email: '',
    senha: ''
  };

  constructor(
    private usuarioService: UsuarioService,
    private router: Router
  ) { }

  fazerLogin() {
    this.usuarioService.fazerLogin(this.dadosLogin).subscribe({
      next: (resposta) => {
        console.log('Login com sucesso!', resposta);
        localStorage.setItem('nomeUsuario', resposta.nome);
        this.router.navigate(['/pagina_inicial']); 
      },
      error: (erro) => {
        console.error(erro);
        alert('Email ou senha incorretos!');
      }
    });
  }


}
