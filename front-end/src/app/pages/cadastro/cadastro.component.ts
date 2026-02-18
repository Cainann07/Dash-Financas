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
        this.usuarioService.inserirUsuario(this.usuario).subscribe({
            next: (resposta) => {
                console.log('Sucesso!', resposta);
                alert('Usuário cadastrado com sucesso!');
                this.router.navigate(['/login']);
            },
            error: (erro) => {
                console.error('Erro:', erro);
                if (erro.status === 409) {
                    alert('Erro: ' + erro.error.mensagem); 
                } else {
                    alert('Erro ao cadastrar. Verifique o console.');
                }
            }
        });
    }
}
