import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; // Importante para ngModel

// PrimeNG Imports
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { Dialog, DialogModule } from 'primeng/dialog'; // O Modal
import { InputTextModule } from 'primeng/inputtext';
import { InputNumber, InputNumberModule } from 'primeng/inputnumber';
import { SelectModule } from 'primeng/select';// import { DropdownModule } from 'primeng/Dropdown';
import { SelectButton, SelectButtonModule } from 'primeng/selectbutton'; // Para escolher Receita/Despesa

@Component({
    selector: 'app-pagina_inicial',
    imports: [
        CommonModule,
        FormsModule,
        SelectModule,
        ButtonModule,
        TableModule,
        DialogModule,
        InputTextModule,
        InputNumberModule,
        SelectButtonModule],
    templateUrl: 'pagina_inicial.component.html',
    styleUrl: 'pagina_inicial.component.scss',
})
export class PaginaInicialComponent {
    resumo = {
        entrada: 5200.00,
        saida: 3100.00,
        saldo: 2100.00
    };

    // Widget: METAS FINANCEIRAS
    metas = [
        { nome: 'Reserva de Emergência', atual: 5000, alvo: 10000, progresso: 50, cor: '#3B82F6' }, // Azul
        { nome: 'Viagem de Férias', atual: 1200, alvo: 5000, progresso: 24, cor: '#10B981' }, // Verde
        { nome: 'Notebook Novo', atual: 4500, alvo: 4500, progresso: 100, cor: '#8B5CF6' } // Roxo
    ];

    // Widget: PRÓXIMAS CONTAS
    contasFuturas = [
        { descricao: 'Netflix', valor: 55.90, data: 'Hoje', status: 'urgente' },
        { descricao: 'Internet', valor: 120.00, data: 'Amanhã', status: 'atencao' },
        { descricao: 'Aluguel', valor: 1500.00, data: '25/08', status: 'normal' }
    ];

    // Widget: ONDE GASTEI MAIS (Categorias)
    topGastos = [
        { categoria: 'Alimentação', valor: 850, icone: 'pi-shopping-cart', corIcone: 'text-orange-500', bgIcone: 'bg-orange-100' },
        { categoria: 'Transporte', valor: 400, icone: 'pi-car', corIcone: 'text-blue-500', bgIcone: 'bg-blue-100' },
        { categoria: 'Lazer', valor: 250, icone: 'pi-ticket', corIcone: 'text-purple-500', bgIcone: 'bg-purple-100' }
    ];

    // Tabela: ÚLTIMAS TRANSAÇÕES
    transacoes = [
        { nome: 'Supermercado Extra', categoria: 'Alimentação', data: '17/08/2025', valor: 450.00, tipo: 'despesa' },
        { nome: 'Pix Recebido (João)', categoria: 'Outros', data: '16/08/2025', valor: 150.00, tipo: 'receita' },
        { nome: 'Uber Viagem', categoria: 'Transporte', data: '15/08/2025', valor: 24.90, tipo: 'despesa' },
        { nome: 'Spotify Mensal', categoria: 'Assinaturas', data: '15/08/2025', valor: 21.90, tipo: 'despesa' },
        { nome: 'Salário Mensal', categoria: 'Salário', data: '05/08/2025', valor: 5200.00, tipo: 'receita' }
    ];

    // --- CONTROLE DO MODAL ---
    modalVisivel: boolean = false;

    // Objeto que segura os dados do formulário
    novaTransacao = {
        descricao: '',
        valor: null,
        categoria: null,
        tipo: 'despesa' // Valor padrão
    };

    // Opções para o Dropdown de Categorias
    categorias = [
        { label: 'Alimentação', value: 'Alimentação' },
        { label: 'Transporte', value: 'Transporte' },
        { label: 'Casa', value: 'Casa' },
        { label: 'Lazer', value: 'Lazer' },
        { label: 'Salário', value: 'Salário' },
        { label: 'Outros', value: 'Outros' }
    ];

    // Opções para o Botão de Tipo
    tipos = [
        { label: 'Despesa', value: 'despesa' },
        { label: 'Receita', value: 'receita' }
    ];

    //   // --- DADOS DA TELA (Mantive os anteriores) ---
    //   transacoes = [
    //     { nome: 'Supermercado Extra', categoria: 'Alimentação', data: '17/08/2025', valor: 450.00, tipo: 'despesa' },
    //     // ... outros dados
    //   ];

    // --- AÇÕES ---

    abrirModal() {
        // Limpa o formulário antes de abrir
        this.novaTransacao = { descricao: '', valor: null, categoria: null, tipo: 'despesa' };
        this.modalVisivel = true;
    }

    salvarTransacao() {
        if (this.novaTransacao.descricao && this.novaTransacao.valor) {
            // Adiciona na lista (Simulação)
            this.transacoes.unshift({
                nome: this.novaTransacao.descricao,
                categoria: this.novaTransacao.categoria || 'Outros',
                data: 'Hoje',
                valor: this.novaTransacao.valor,
                tipo: this.novaTransacao.tipo
            });

            // Fecha o modal
            this.modalVisivel = false;
        }
    }
}
