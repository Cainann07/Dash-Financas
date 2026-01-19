import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {  Button } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { PasswordModule } from 'primeng/password';
import { LottieComponent, AnimationOptions } from 'ngx-lottie';
import { UsuarioService } from '../../services/usuario';
import { Router } from '@angular/router';


@Component({
    selector: 'app-login',
    imports: [FormsModule, InputTextModule, Button, PasswordModule, LottieComponent],
    templateUrl: './cadastro.component.html',
    styleUrl: './cadastro.component.scss',
})
export class CadastroComponent {
    // email_input: string | undefined;
    // user_input: string | undefined;
    // senha_input: string | undefined;

    options: AnimationOptions = {
        path: '/assets/animacao-dinheiro.json',
        loop: true,
        autoplay: true
    };

    usuario = {
        nome: '',
        sobrenome: '',
        email: '',
        senha: ''
    };

    constructor(
        private usuarioService: UsuarioService,
        private router: Router
    ) { }

    salvarUsuario() {
        // Chama o serviço
        this.usuarioService.cadastrarUsuario(this.usuario).subscribe({
            next: (resposta) => {
                console.log('Sucesso!', resposta);
                alert('Usuário cadastrado com sucesso!');
                // Aqui você pode redirecionar para o login
                this.router.navigate(['/login']);
            },
            error: (erro) => {
                console.error('Erro:', erro);
                // Lembra que criamos exceções no Java? Elas aparecem aqui!
                if (erro.status === 409) {
                    alert('Erro: ' + erro.error.mensagem); // "Já existe um usuário..."
                } else {
                    alert('Erro ao cadastrar. Verifique o console.');
                }
            }
        });
    }
}
