# Documentação do Sistema Android de Cadastro de Alunos

## Visão Geral

Este sistema Android foi desenvolvido em Java e permite o cadastro de alunos, incluindo informações como nome, e-mail e telefone. Os alunos cadastrados são organizados e exibidos em uma lista.

## Requisitos

- **Android Studio**: Versão mais recente.
- **Java JDK**: Versão 8 ou superior.
- **Dispositivo Android**: Emulador ou dispositivo real com Android 5.0 (Lollipop) ou superior.

## Como Executar o Projeto

1. **Clone o repositorio**
     ```bash
         git clone https://github.com/Gustavo-Vinicius-Santana/agenda-android
         cd agenda-android
     ```

2. **Abrir o Projeto no Android Studio**:
   - Abra o Android Studio.
   - Selecione "Open" e navegue até o diretório do projeto para abri-lo.

3. **Executar o Projeto**:
   - Clique no botão "Run" no Android Studio.
   - Selecione um dispositivo emulado ou real para executar o aplicativo.

4. **Interagir com o Sistema**:
   - Na tela principal, visualize a lista de alunos cadastrados.
   - Utilize o botão de adicionar para cadastrar novos alunos.
   - Selecione um aluno da lista para editar suas informações.

## Funcionalidades

### Tela Principal

- **Descrição**: Exibe a lista de alunos cadastrados e oferece botões para adicionar um novo aluno ou editar os existentes.
- **Funcionalidades**:
  - **Listagem de Alunos**: Exibe todos os alunos cadastrados.
  - **Adicionar Aluno**: Redireciona para a tela de cadastro de aluno.
  - **Editar Aluno**: Permite selecionar um aluno da lista e redireciona para a tela de edição com os dados preenchidos.

### Tela de Cadastro/Edicao de Alunos

- **Descrição**: Permite cadastrar ou editar as informações de um aluno.
- **Funcionalidades**:
  - **Campos**:
    - Nome
    - E-mail
    - Telefone
  - **Salvar**: Salva as informações do aluno e retorna à tela principal.
