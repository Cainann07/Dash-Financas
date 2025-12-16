# 💰 FinanceControl - Dashboard Financeiro Pessoal

<div align="center">
   <br>

   ![Angular](https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white)
   ![PrimeNG](https://img.shields.io/badge/PrimeNG-E6E6E6?style=for-the-badge&logo=primeng&logoColor=red)
   ![TypeScript](https://img.shields.io/badge/TypeScript-007ACC?style=for-the-badge&logo=typescript&logoColor=white)
   ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
   ![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)

   <p>
      Um gerenciador financeiro moderno focado em simplicidade e visualização clara de dados. 
      Desenvolvido para auxiliar no controle de orçamento mensal através de um Wizard interativo.
   </p>
</div>

<br>

## 🖼️ Visualização do Projeto

<div align="center">
  <img src="./assets/print-dashboard.png" alt="Tela de Resumo" width="700">
</div>

<div align="center" style="display: flex; gap: 10px; justify-content: center; margin-top: 10px;">
  <img src="./assets/print-stepper-1.png" alt="Passo 1" width="300">
  <img src="./assets/print-stepper-2.png" alt="Passo 2" width="300">
</div>

---

## 🚀 Tecnologias Utilizadas

O projeto foi desenvolvido aplicando conceitos modernos de Front-end e arquitetura limpa:

### Front-end
- **Angular 17+**: Utilizando **Standalone Components** (sem NgModules), nova sintaxe de controle de fluxo (`@if`, `@for`) e Signals.
- **PrimeNG**: Biblioteca de componentes de UI (Table, Stepper, InputNumber, Buttons).
- **PrimeIcons & PrimeFlex**: Para ícones e sistema de grid/layout responsivo.
- **CSS3 Moderno**: Uso extensivo de Flexbox para layout fluído e design responsivo.

### Back-end (Em desenvolvimento)
- **Java 21** com **Spring Boot 3**
- **Spring Data JPA** para persistência.
- **Bean Validation** para regras de negócio.

---

## ✨ Funcionalidades

- **🧙‍♂️ Wizard de Configuração (Stepper):** - Passo a passo guiado para configuração inicial de perfil.
  - Validação de campos obrigatórios antes de avançar.
- **📊 Gestão de Orçamento:**
  - Input monetário com formatação brasileira (R$) automática.
  - Lista dinâmica de gastos fixos com opção de adicionar/remover itens.
- **📈 Resumo Financeiro Inteligente:**
  - Cálculo automático de saldo (Renda - Despesas) em tempo real.
  - Feedback visual (Verde/Vermelho) dependendo da saúde financeira.
  - Layout "Clean" inspirado em bancos digitais modernos.
- **📱 Design Responsivo:** Sidebar e layouts adaptáveis a diferentes tamanhos de tela.

---

## 📦 Como rodar o projeto

### Pré-requisitos
- Node.js (v18+)
- Angular CLI
- Java JDK 17+ (para a API)

### Passos para o Front-end

```bash
# 1. Clone o repositório
git clone [https://github.com/SEU-USUARIO/NOME-DO-PROJETO.git](https://github.com/SEU-USUARIO/NOME-DO-PROJETO.git)

# 2. Entre na pasta do projeto
cd frontend

# 3. Instale as dependências
npm install

# 4. Rode o servidor de desenvolvimento
ng serve
