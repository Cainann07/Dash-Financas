import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonModule, Button } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import {  InputNumber } from 'primeng/inputnumber';
import { StepperModule, Stepper, StepList, Step, StepPanels, StepPanel } from 'primeng/stepper';


@Component({
  selector: 'app-tela_inicial',
  imports: [FormsModule, InputTextModule, Button, InputNumber, Stepper, StepList, Step, StepPanels, StepPanel],
  templateUrl: './tela_inicial.component.html',
  styleUrl: './tela_inicial.component.scss',
})
export class TelaInicialComponent {
    orcamento_input = 0;

}
