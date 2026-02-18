import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

// PrimeNG Imports
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { DialogModule } from 'primeng/dialog';
import { InputTextModule } from 'primeng/inputtext';
import { InputNumberModule } from 'primeng/inputnumber';
import { SelectModule } from 'primeng/select';
import { SelectButtonModule } from 'primeng/selectbutton';
import { ProgressBar } from "primeng/progressbar";

@Component({
    selector: 'app-pagina_inicial',
    imports: [
        CommonModule, FormsModule, SelectModule, ButtonModule,
        TableModule, DialogModule, InputTextModule, InputNumberModule, SelectButtonModule, ProgressBar],
    templateUrl: 'pagina_inicial.component.html',
    styleUrl: 'pagina_inicial.component.scss',
})
export class PaginaInicialComponent implements OnInit {
    nomeUsuario: string = '';    

    ngOnInit(): void {
        this.nomeUsuario = localStorage.getItem('nomeUsuario') || 'Usuário';
    }


    resumo = {
        entrada: 5200.00,
        saida: 3100.00,
        saldo: 2100.00
    };

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

    // --- AÇÕES ---

    abrirModal() {
        // Limpa o formulário antes de abrir
        this.novaTransacao = { descricao: '', valor: null, categoria: null, tipo: 'despesa' };
        this.modalVisivel = true;
    }

    salvarTransacao() {
        if (this.novaTransacao.descricao && this.novaTransacao.valor) {
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

    // --- WIDGET DE METAS ---
    metas = [
        {
            id: 1,
            nome: 'Reserva de Emergência',
            atual: 5000,
            alvo: 10000,
            progresso: 50,
            cor: '#3B82F6', // Azul
            icone: 'pi-shield',
            historico: [{ data: '10/08', valor: 500 }]
        },
        {
            id: 2,
            nome: 'Viagem de Férias',
            atual: 1200,
            alvo: 5000,
            progresso: 24,
            cor: '#10B981', // Verde
            icone: 'pi-compass',
            historico: []
        },
        {
            id: 3,
            nome: 'Notebook Gamer',
            atual: 4500,
            alvo: 9000,
            progresso: 50,
            cor: '#8B5CF6', // Roxo
            icone: 'pi-desktop',
            historico: []
        }
    ];

    // Adiciona dinheiro ao cofre selecionado
    depositarNoCofre() {
        if (this.valorDeposito && this.metaSelecionada) {
            // 1. Atualiza valores
            this.metaSelecionada.atual += this.valorDeposito;

            // 2. Recalcula porcentagem
            this.metaSelecionada.progresso = Math.round((this.metaSelecionada.atual / this.metaSelecionada.alvo) * 100);

            // 3. Adiciona no histórico
            this.metaSelecionada.historico.unshift({
                data: 'Hoje',
                valor: this.valorDeposito
            });

            // 4. Limpa input e fecha (opcional fechar)
            this.valorDeposito = null;
            this.modalMetaVisivel = false;
        }
    }

    // Controle dos Modais
    modalTodasMetasVisivel: boolean = false;
    modalMetaVisivel: boolean = false;

    metaSelecionada: any = null;
    valorDeposito: number | null = null;

    // Abre a lista completa
    exibirTodasMetas() {
        this.modalTodasMetasVisivel = true;
    }

    abrirDetalhesMeta(meta: any) {
        this.metaSelecionada = meta;
        this.valorDeposito = null;
        this.modalMetaVisivel = true;
    }

    // CONTROLE DA NOVA META
    modalCriarMetaVisivel: boolean = false;

    // Dados do formulário
    novaMeta = {
        nome: '',
        alvo: null as number | null,
        inicial: null as number | null,
        temaSelecionado: null as any
    };

    temasDisponiveis = [
        { nome: 'Azul', cor: '#3B82F6', icone: 'pi-shield' },
        { nome: 'Verde', cor: '#10B981', icone: 'pi-money-bill' },
        { nome: 'Roxo', cor: '#8B5CF6', icone: 'pi-gift' },
        { nome: 'Laranja', cor: '#F59E0B', icone: 'pi-car' },
        { nome: 'Rosa', cor: '#EC4899', icone: 'pi-heart' },
        { nome: 'Vermelho', cor: '#EF4444', icone: 'pi-home' }
    ];

    abrirCriarMeta() {
        // Reseta o formulário
        this.novaMeta = {
            nome: '',
            alvo: null,
            inicial: null,
            temaSelecionado: this.temasDisponiveis[0] // Seleciona o primeiro por padrão
        };
        this.modalCriarMetaVisivel = true;
    }

    salvarNovaMeta() {
        if (this.novaMeta.nome && this.novaMeta.alvo && this.novaMeta.temaSelecionado) {

            const valorInicial = this.novaMeta.inicial || 0;
            const progressoCalculado = Math.round((valorInicial / this.novaMeta.alvo) * 100);

            // Cria o objeto final
            const novoObjetivo = {
                id: Date.now(),
                nome: this.novaMeta.nome,
                atual: valorInicial,
                alvo: this.novaMeta.alvo,
                progresso: progressoCalculado,
                cor: this.novaMeta.temaSelecionado.cor,
                icone: this.novaMeta.temaSelecionado.icone,
                historico: valorInicial > 0 ? [{ data: 'Inicial', valor: valorInicial }] : []
            };

            // Adiciona na lista
            this.metas.push(novoObjetivo);

            // Fecha modal
            this.modalCriarMetaVisivel = false;
        }
    }

    // Controle do Modal de Extrato
    modalExtratoVisivel: boolean = false;

    abrirExtratoCompleto() {
        this.modalExtratoVisivel = true;
    }
}
