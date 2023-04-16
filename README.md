
# Ganho de Capitais

Projeto responsável por calcular o imposto a ser pago sobre lucros ou prejuízos de operações no mercado financeiro de ações.


## Como funciona?

Com base nas informações recebidas através do fluxo de entrada padrão (stdin), o programa irá ler todas as linhas fornecidas e armazená-las em uma Lista que manterá os dados na mesma ordem de entrada. Em seguida, a entrada será convertida em um objeto e, a partir daí, o cálculo do ganho de capital será realizado. Ao término da execução, o programa retornará o valor do imposto cobrado pelas operações realizadas.

## Pré-requisitos
* [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
* [Maven](https://maven.apache.org/install.html)
* [Docker](https://docs.docker.com/engine/install/ubuntu/) ou [WSL](https://learn.microsoft.com/pt-br/windows/wsl/install)


## Rodando localmente

1. Extraia o arquito capital-gains.zip para uma pasta e entre no diretório do projeto

```bash
  cd capital-gains
```

2. Instale as dependências

```bash
  mvn clean install
```

3. Acesse a pasta de target
```bash
  cd target/
```
4. Inicie o servidor atraves do jar

```bash
  java -jar capital-gains-1.0.0-jar-with-dependencies.jar
```
5.Ou execute atraves da classe Application.class


## Rodando via Docker (Ubuntu)

1. Extraia o arquito capital-gains.zip para uma pasta e entre no diretório do projeto

```bash
  cd capital-gains
```

2. Execute o seguinte comando para criar a imagem no docker:
```bash
  sudo docker build -t capital-gains .
```

3. Executando o container

```bash
  sudo docker run -i capital-gains
```

4. Após a execução do comando a cima, o programa já estará rodando.


## Informando Operações para o Processamento
O programa recebe os objetos de entrada por meio do _stdin_ e aguarda a inserção dos dados para processamento. Após inserir os dados, pressione a tecla **enter** para continuar. Ao final da execução, o imposto cobrado para a operação inserida será retornado.

## Rodando os testes

Para rodar os testes, rode o seguinte comando:

```bash
  mvn test
```

## Arquitetura
No código que foi desenvolvido, foi utilizada a transparência referencial, um conceito importante em programação funcional.

Ao utilizar a transparência referencial, tornamos o código mais funcional possível, independente da linguagem de programação utilizada. Mesmo em Java 11, que é uma linguagem orientada a objetos, é possível escrever código funcional com a utilização de técnicas e conceitos da programação funcional.

## Bibliotecas utilizadas
Durante o desenvolvimento da solução, utilizamos algumas bibliotecas para simplificar e otimizar o processo. Uma delas foi o GSON, que nos permitiu converter o objeto de entrada através do stdin em um Json, facilitando a manipulação dos dados.

Além disso, também utilizamos a biblioteca Lombok para nos auxiliar na criação de um Builder e Getter da Entidade, tornando o código mais simples e fácil de entender.

Por fim, para os testes unitários, escolhemos utilizar o JUnit 5, que nos proporcionou um conjunto completo de recursos e funcionalidades para garantir a qualidade e a confiabilidade do código.