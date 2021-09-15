# Bem-vindo ao AgendamentoApp

Serviço responsável por cadastrar agendamentos de serviços para clientes

---

# Ambiente de desenvolvimento

Existem alguns passos para execução do projeto em ambiente local, necessário que alguns programas estejam corretamente instalados.

Framework/lib | Versão Recomendada | S.O Utilizado
--- | --- | ---
[Maven](https://maven.apache.org/download.cgi) | 3.6.3 | Windows
[JDK](https://openjdk.java.net/projects/jdk/11/) | 11 | Windows
[Docker](https://docs.docker.com/docker-for-windows/install/) | 19.03.13 | Windows
[Docker Compose](https://docs.docker.com/compose/install/) | 1.27.4 | Windows
[Intellij](https://www.jetbrains.com/pt-br/idea/)| - | Windows

## Execução do projeto

### Passo 1
Faça o clone do projeto
```shell script
$ git clone https://github.com/Maikoncanuto/mcp-ml.git agendamentoapp
```

### Passo 2
Entre na pasta raiz do projeto

```shell script
$ cd agendamentoapp
```

### Passo 3 (opcional, já contém o target)
Executar o comando do maven para gerar o artefato que será publicado no docker

```shell script
$ cd mvn clean install
```

### Passo 4
Execute o comando para levantar toda infraestrutura necessária

```shell script
$ docker-compose up --build
```

Acompanhar logs:
```shell script
$ docker-compose logs -f
```

# Serviços do mcp-ml

Serviço | URL | Status | Descrição
--- | --- | --- | ---
Clientes | http://localhost:8080/api/v1/clientes| :white_check_mark: | Endpoint de cliente
Serviços | http://localhost:8080/api/v1/servicos | :white_check_mark: | Endpoint de serviço
Agendamentos | http://localhost:8080/api/v1/agendamentos | :white_check_mark: | Endpoint para agendamento

# Exemplo de requisições para os Endpoints

## Endpoint de clientes
**Url de requisição:**
```
http://localhost:8080/api/v1/clientes
```

**Envio**
```json
{
    "valor": "100.0",
    "descricao": "Atendimento",
    "codigo": "01"
}
```

**Retorno:**
``` json
  {
    "data": [
        {
            "id": 1,
            "codigo": "01",
            "descricao": "Atendimento",
            "valor": "100.0"
        }
    ]
}
```
---
