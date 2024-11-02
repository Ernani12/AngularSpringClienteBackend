# Aplicação de Cadastro de Clientes via Coordenadas Geográficas

## Descrição do Projeto

Esta aplicação permite o cadastro de clientes com localização geográfica (latitude e longitude) usando uma API REST. O backend é desenvolvido em Java Spring Boot e integrado a um frontend Angular, com contêineres Docker e implementação na AWS usando EC2, ECR, VPN e EKS (Kubernetes).

---

## Tecnologias Utilizadas

| Tecnologia      | Versão  | Descrição                                                                                   |
|-----------------|---------|-----------------------------------------------------------------------------------------------|
| Java            | 17      | Linguagem de programação principal para a aplicação backend                                   |
| Maven           | -       | Gerenciador de dependências e build da aplicação                                             |
| Lombok          | -       | Biblioteca para simplificação de código (auto geração de getters, setters, etc.)             |
| JPA             | -       | Mapeamento de dados e persistência                                                           |
| Spring Boot     | -       | Framework principal para criação do backend                                                  |
| Docker          | -       | Contêiner para empacotamento e execução da aplicação                                         |
| SonarQube       | -       | Ferramenta para análise estática e verificação da qualidade do código                        |
| JUnit           | -       | Biblioteca de testes para assegurar a funcionalidade do código                               |

---

## Estrutura do Projeto

### Backend (Java Spring Boot)

- **API REST para Cadastro de Clientes**:
  - Cadastro de clientes por coordenadas geográficas (latitude e longitude).
  - Persistência com JPA e modelo de entidade `Cliente`.
  - Lombok para simplificação de código com getters, setters e construtores automáticos.

- **Estrutura de Pastas**:
  - `src/main/java/com/seuprojeto/cliente`:
    - `controller`: Controladores REST.
    - `model`: Modelos de entidades.
    - `repository`: Repositórios JPA.
    - `service`: Lógica de negócio.

- **Execução e Build**:
  - Para rodar o backend, utilize:
    ```bash
    mvn spring-boot:run
    ```
  - Para criar e rodar a imagem Docker:
    ```bash
    docker build -t seu-projeto/cliente-app .
    docker run -p 8080:8080 seu-projeto/cliente-app
    ```

### Frontend (Angular)

- **Estrutura do Projeto Angular**:
  - Aplicação em Angular com componentes reativos para comunicação com a API.
  - Lista e formulário de cadastro de clientes.

- **Execução do Angular**:
  - Rodar o frontend na pasta do projeto Angular:
    ```bash
    npm install
    ng serve --open
    ```
  - O Angular estará acessível em `http://localhost:4200`.

---

## Integração com AWS

| Serviço AWS       | Descrição                                                                                                        |
|-------------------|------------------------------------------------------------------------------------------------------------------|
| **EC2**           | Instâncias de servidor para hospedar e rodar a aplicação backend e frontend                                     |
| **ECR**           | Repositório de contêineres para armazenar as imagens Docker                                                     |
| **EKS (Kubernetes)** | Cluster de Kubernetes gerenciado pela AWS para orquestração de contêineres, garantindo escalabilidade          |
| **VPN**           | Rede privada virtual para proteger a comunicação entre os serviços                                              |

### Passos para Deploy

1. **Deploy do Backend e Frontend**:
   - Fazer o build do backend Spring Boot e frontend Angular.
   - Subir a imagem Docker para o **AWS ECR**.

2. **Execução no EKS**:
   - Autenticar e fazer o push da imagem Docker no ECR:
     ```bash
     aws ecr get-login-password --region [sua-região] | docker login --username AWS --password-stdin [seu-repo-ecr]
     docker tag cliente-app:latest [seu-repo-ecr]:latest
     docker push [seu-repo-ecr]:latest
     ```
   - Aplicar a configuração no EKS para rodar a imagem:
     ```bash
     kubectl apply -f deployment.yaml
     ```

---

## Testes e Qualidade de Código

| Ferramenta   | Descrição                                                                                           |
|--------------|-----------------------------------------------------------------------------------------------------|
| **SonarQube**| Análise estática para avaliar a qualidade do código, detectando erros, vulnerabilidades e melhorias |
| **JUnit**    | Testes unitários para garantir que cada módulo funcione como esperado                               |

### Execução dos Testes

- **JUnit**:
  - Executar os testes com o comando:
    ```bash
    mvn test
    ```

- **SonarQube**:
  - Configurar a aplicação para enviar os dados ao servidor SonarQube:
    ```bash
    mvn sonar:sonar -Dsonar.projectKey=[seu-project-key]
    ```

---

## Resumo de Comandos Importantes

| Comando                                | Descrição                                                                                          |
|----------------------------------------|----------------------------------------------------------------------------------------------------|
| `mvn spring-boot:run`                  | Executa a aplicação backend                                                                       |
| `docker build -t cliente-app .`        | Builda a imagem Docker da aplicação                                                                |
| `docker run -p 8080:8080 cliente-app`  | Executa o contêiner Docker localmente                                                              |
| `npm install && ng serve --open`       | Instala dependências e executa o frontend Angular                                                  |
| `aws ecr get-login-password ...`       | Comando para autenticar e fazer push da imagem Docker no ECR                                       |
| `kubectl apply -f deployment.yaml`     | Aplica o deploy no cluster EKS                                                                     |

---

Esse README fornece uma visão completa da aplicação, facilitando o desenvolvimento, teste e deployment na AWS. A estrutura modular permite adicionar mais funcionalidades e escalar no EKS conforme necessário.
