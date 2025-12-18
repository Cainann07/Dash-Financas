import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonModule, Button } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { InputNumber } from 'primeng/inputnumber';
import { Stepper, StepList, Step, StepPanels, StepPanel } from 'primeng/stepper';
import { TableModule } from 'primeng/table';
import { CommonModule } from '@angular/common';

interface Gasto {
  nome: string;
  valor: number;
}

@Component({
  selector: 'app-passos_iniciais',
  imports: [CommonModule, TableModule, FormsModule, ButtonModule, InputTextModule, Button, InputNumber, Stepper, StepList, Step, StepPanels, StepPanel],
  templateUrl: './passos_iniciais.component.html',
  styleUrl: './passos_iniciais.component.scss',
})
export class PassosIniciaisComponent {
  orcamento_input = 0;
  gasto_mensal: string | undefined;
  tempGastoNome: string = '';
  tempGastoValor: number | null = null;

  listaGastosIniciais: Gasto[] = [];

  adicionarGastoNaLista() {
    if (this.tempGastoNome && this.tempGastoValor) {

      const novoGasto: Gasto = {
        nome: this.tempGastoNome,
        valor: this.tempGastoValor
      };

      this.listaGastosIniciais.push(novoGasto);

      this.tempGastoNome = '';
      this.tempGastoValor = null;
    }
  }

  removerGasto(index: number) {
    this.listaGastosIniciais.splice(index, 1);
  }

  get totalGastos(): number {
    return this.listaGastosIniciais.reduce((total, item) => total + item.valor, 0);
  }

  get saldoFinal(): number {
    const renda = this.orcamento_input || 0;
    return renda - this.totalGastos;
  }

  finalizarSetup() {
    const dadosFinais = {
      renda: this.orcamento_input,
      gastosFixos: this.listaGastosIniciais,
      saldoPrevisto: this.saldoFinal
    };

    console.log('Enviando para o Back-end:', dadosFinais);
    alert('Configuração concluída com sucesso!');
  }
}
