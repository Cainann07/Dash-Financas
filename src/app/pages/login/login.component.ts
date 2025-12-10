import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonModule, Button } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { PasswordModule } from 'primeng/password';
import { LottieComponent, AnimationOptions } from 'ngx-lottie';


@Component({
  selector: 'app-login',
  imports: [FormsModule, InputTextModule, Button, PasswordModule, LottieComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
  email_input: string | undefined;
  user_input: string | undefined;
  senha_input: string | undefined;

  options: AnimationOptions = {
    path: '/assets/animacao-dinheiro.json',
    loop: true,
    autoplay: true
  };
}
