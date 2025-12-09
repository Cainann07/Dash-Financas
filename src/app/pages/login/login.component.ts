import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonModule, Button } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { PasswordModule } from 'primeng/password';


@Component({
  selector: 'app-login',
  imports: [FormsModule, InputTextModule, Button, PasswordModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
    email_input: string | undefined;
    user_input: string | undefined;
    senha_input: string | undefined;

}
