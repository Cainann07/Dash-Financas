import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { ProgressBarModule } from 'primeng/progressbar';
import { TableModule } from 'primeng/table';
import { DialogModule } from 'primeng/dialog';
import { InputNumberModule } from 'primeng/inputnumber';

@Component({
  selector: 'app-meta_detalhes',
  standalone: true,
  imports: [CommonModule, FormsModule, ButtonModule, ProgressBarModule, TableModule, DialogModule, InputNumberModule],
  templateUrl: './meta_detalhes.component.html',
  styleUrl: './meta_detalhes.component.scss'
})
export class MetaDetalhesComponent implements OnInit {

  // Dados Mockados
  meta = {
    id: 101,
    nome: 'Reserva de Emergência',
    atual: 5000,
    alvo: 10000,
    progresso: 50,
    icone: 'pi-shield',
    
    // O JEITO SIMPLES: Apenas o nome da classe do tema
    classe: 'tema-azul', 
    
    historico: [
      { data: '15/08/2025', valor: 500 },
      { data: '10/07/2025', valor: 200 },
      { data: '05/06/2025', valor: 1000 }
    ]
  };

  exibirModal: boolean = false;
  valorDeposito: number | null = null;

  constructor(private router: Router) {}

  ngOnInit() {}

  voltar() {
    this.router.navigate(['/home']);
  }

  abrirCofre() {
    this.valorDeposito = null;
    this.exibirModal = true;
  }

  confirmarDeposito() {
    if (this.valorDeposito) {
      this.meta.historico.unshift({ data: 'Hoje', valor: this.valorDeposito });
      this.meta.atual += this.valorDeposito;
      this.meta.progresso = Math.round((this.meta.atual / this.meta.alvo) * 100);
      this.exibirModal = false;
    }
  }
}