Projeto da Disciplina de DevOps - Professor Rodrigo Barbosa


To Do List - (Dockerizado)
✅ Descrição da Aplicação
Esta é uma aplicação Full Stack para gerenciamento de tarefas, totalmente dockerizada, composta por:


- Frontend: React + Vite
- Backend: Java 17 + Spring Boot
- Banco de Dados: PostgreSQL


🎯 Funcionalidades:
✅ Criar uma tarefa com título e descrição
✅ Marcar uma tarefa como pendente ou concluída
✅ Deletar uma tarefa
✅ Lista todas as tarefas cadastradas


⚙️ Tecnologias Utilizadas
- Docker
- Docker Compose
- PostgreSQL 15
- Spring Boot
- React + Vite
- 

❗ Observações importantes:
A aplicação funciona em qualquer sistema com Docker e Docker Compose.
Toda comunicação entre os serviços é feita via rede interna do Docker (app_network).
Não é necessário rodar npm install ou mvn install manualmente — tudo é feito via build das imagens.

🚀 Como instalar e executar a aplicação
✅ Pré-requisitos:
-  Docker instalado
- Docker Compose instalado
- Java 17 (apenas para desenvolvimento local, não necessário para execução via Docker)

  
 ✅ Passos para executar:
Clone este repositório: https://github.com/orodrigobarbosa/projeto-devops

**Como já tem o arquivo .env,  precisa apenas executar oDocker Compose:
docker-compose up --build -d

🖥️ Acessos da Aplicação rodando com Docker Compose:

Frontend (interface web):
👉 http://localhost:3000

Backend (API REST):
👉 http://localhost:8080/api/tarefas

Banco de dados:
👉 Não há necessidade de acessar diretamente, mas está exposto na porta 5432 caso precise.


Para parar a aplicação e remover os volumes do banco de dados, execute:
docker-compose down -v

