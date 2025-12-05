# 📚 Sistema de Gestão de Livraria

Este projeto consiste no desenvolvimento de um **Sistema de Gestão de Livraria**, permitindo o controle completo de livros, clientes e vendas. O sistema será desenvolvido em **Java (NetBeans)** com interface gráfica e armazenará seus dados em um **banco SQL**.


### 👨‍💻 Desenvolvido por:
- **André Luiz Souza dos Santos**
- **Lelio Victor de Faro Coelho Vieira**

---

## 🚀 Tecnologias Utilizadas

- **Java SE**  
- **NetBeans IDE**
- **JDBC**
- **SQL (MySQL ou MariaDB)**
- **Swing (Interface gráfica)**

---

## ⚙️ Funcionalidades

| Funcionalidade | Descrição |
|----------------|-----------|
| 📚 Cadastro e gerenciamento de livros | Adicionar, editar, remover e listar livros |
| 👥 Cadastro e consulta de clientes | Registrar dados de clientes e visualizar lista |
| 💰 Registro de vendas | Selecionar cliente, funcionário e itens vendidos |
| 🧾 Histórico de vendas | Visualização detalhada de vendas realizadas |
| 🔐 Login de funcionário | Acesso controlado ao sistema |

---

## 🔑 Autenticação

O sistema conta com tela de login, utilizando a tabela **Funcionario** para validação de usuário e senha.

---

## 📦 Script SQL

O sistema utiliza um banco de dados baseado em uma estrutura SQL. Para configurar seu banco, utilize as queries:

create database DBLibrary;

use DBLibrary;

create table if not exists funcionario (
    idFuncionario int unsigned not null auto_increment primary key,
    nome varchar(60),
    login varchar(30) unique,
    senha varchar(30)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

create table if not exists livro (
    idLivro int unsigned not null auto_increment primary key,
    titulo text,
    autor varchar(100),
    editora varchar(100),
    preco decimal,
    quantidade int
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

create table if not exists cliente (
    idCliente int unsigned not null auto_increment primary key,
    nome varchar(60),
    telefone varchar(20),
    email varchar(100)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

create table if not exists venda (
    idVenda int unsigned not null auto_increment primary key,
    data_venda DATE,
    total decimal,
    idCliente int not null,
    idFuncionario int not null,
    foreign key (idCliente) references cliente(idCliente),
    foreign key (idFuncionario) references funcionario(idFuncionario)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

create table if not exists itens_venda (
    idItem int unsigned not null auto_increment primary key,
    quantidade int,
    subtotal decimal,
    idVenda int not null,
    idLivro int not null,
    foreign key (idVenda) references venda(idVenda),
    foreign key (idLivro) references livro(idLivro)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;
