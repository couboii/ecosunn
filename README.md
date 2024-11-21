# 🌞 Ecosun - Sistema de Gerenciamento de Instalações e Clientes 🌞

**Ecosunn** é um sistema de gerenciamento desenvolvido para gerenciar clientes, técnicos, instalações de placas solares e formas de pagamento. Ele organiza dados essenciais para uma empresa de energia solar, incluindo clientes, técnicos, supervisores e transações financeiras.

## 🚀 Funcionalidades

- **Cadastro de Clientes**: Registre informações detalhadas de clientes, incluindo CPF/CNPJ, endereço e contato.
- **Gerenciamento de Técnicos e Supervisores**: Controle quais técnicos estão responsáveis por cada instalação e quem supervisiona a equipe.
- **Gestão de Instalações**: Relacione cada instalação com o cliente e os técnicos envolvidos.
- **Formas de Pagamento**: Suporte para pagamentos à vista e parcelados, incluindo registro de descontos e condições de pagamento.

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**: Framework principal para desenvolvimento do backend
- **Spring Data JDBC**: Gerenciamento de dados e consultas SQL com JdbcTemplate
- **MySQL**: Banco de dados para armazenamento das informações
- **Maven**: Gerenciamento de dependências e build do projeto
- **Postman**: Testes de API

# Como Rodar

## Pré-requisitos
- **Java 21** ou superior  
- **JDK** instalado  
- **Banco de Dados MySQL** configurado e rodando localmente ou em um servidor remoto  

## Clone a aplicação no GitHub
Primeiro, clone o repositório do projeto para o seu ambiente local:  
[Repositório no GitHub](https://github.com/couboii/ecosunn.git)

```bash
git clone https://github.com/couboii/ecosunn.git
cd <diretório do projeto>
```

## Configurar o Banco de Dados
Você precisa de um banco de dados configurado para rodar a aplicação. Caso ainda não tenha configurado, siga os passos abaixo:

1. Acesse a pasta `scripts sql`.  
   - Na pasta, você encontrará dois arquivos:  
     - **`script_de_criacao.sql`**: Execute este script para criar a estrutura do banco de dados.  
     - **`script_de_insercao.sql`**: Execute este script para inserir os dados iniciais e povoar as tabelas criadas.
     - (Recomenda-se o uso do DBeaver para execução dos scripts)  

## Executando a Aplicação

### 1. Criando o Arquivo `.env`
Crie o arquivo `.env` na pasta `ecosunn` com o seguinte conteúdo:

```env
DATABASE_URL=jdbc:mysql://localhost:3306/bancoecosun
DATABASE_USERNAME={Seu Usuário}
DATABASE_PASSWORD={Sua Senha}
```

### 2. Rodando no Terminal

#### 2.1 MacOS ou Linux
1. Certifique-se de que o terminal esteja na pasta `ecosunn`.  
2. Prepare o script para execução, modificando as permissões:  
   ```bash
   chmod +x mvnw
3. Instale as dependências do frontend:  
   ```bash
   npm install
4. Inicie a aplicação:  
   ```bash
   ./mvnw spring-boot:run

#### 2.2 Windows
1. Instale as dependências do frontend:
   ```bash
   npm install
2. Inicie a aplicação:
   ```bash
   ./mvnw spring-boot:run

### Rodando no IntelliJ IDEA
1. Abra o projeto na IDE.  
2. Clique no ícone de **play** para rodar a aplicação.  
3. A IDE cuidará de compilar e executar automaticamente. Certifique-se de que o arquivo `.env` está na pasta correta para evitar erros.


