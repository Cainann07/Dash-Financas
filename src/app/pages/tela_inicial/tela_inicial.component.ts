import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonModule, Button } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { InputNumber } from 'primeng/inputnumber';
import { StepperModule, Stepper, StepList, Step, StepPanels, StepPanel } from 'primeng/stepper';
import { TableModule } from 'primeng/table';
import { CommonModule } from '@angular/common';

interface Gasto {
  nome: string;
  valor: number;
}

@Component({
  selector: 'app-tela_inicial',
  imports: [CommonModule, TableModule, FormsModule, ButtonModule, InputTextModule, Button, InputNumber, Stepper, StepList, Step, StepPanels, StepPanel],
  templateUrl: './tela_inicial.component.html',
  styleUrl: './tela_inicial.component.scss',
})
export class TelaInicialComponent {
  orcamento_input = 0;
  gasto_mensal: string | undefined;
  // Variáveis dos Inputs
  tempGastoNome: string = '';
  tempGastoValor: number | null = null;

  // O Array que vai segurar a lista enquanto o usuário digita
  listaGastosIniciais: Gasto[] = [];

  // Função que o botão "+" vai chamar
  adicionarGastoNaLista() {
    if (this.tempGastoNome && this.tempGastoValor) {

      // 1. Cria o objeto
      const novoGasto: Gasto = {
        nome: this.tempGastoNome,
        valor: this.tempGastoValor
      };

      // 2. Joga dentro do Array
      this.listaGastosIniciais.push(novoGasto);

      // 3. Limpa os campos para o próximo
      this.tempGastoNome = '';
      this.tempGastoValor = null;
    }
  }

  // Opcional: Permitir remover caso erre
  removerGasto(index: number) {
    this.listaGastosIniciais.splice(index, 1);
  }

}
