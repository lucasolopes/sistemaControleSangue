# Processo Seletivo Java - WK

## Descrição 

- Este teste consiste em construir uma camada de serviço, para extraçao de dados muito realizada em bancos de sangue.


## Como executar a aplicação 

- Você pode executar a aplicação da maneira que quiser e utilizando a IDE de sua preferência. 
- Caso queira executar a aplicação via linha de comando, execute primeiramente o comando:

                   ./mvnw clean package  para linux.

                   .\mvnw clean package  para windows.
- Após isso execute o comando: 

                             java -jar <...caminhoParaSeuJar>
                             
                             

## Documentação da API

#### Cadastra todos candidatos

```http
  POST /candidatos
```

 | Tipo       | Descrição                           |
 :--------- | :---------------------------------- |
 | `JSON` | **Obrigatório**. json de candidatos |


#### Retorna os 10 primeiros candidatos.

```http
  GET /candidatos
```

#### Retorna quantidade de candidatos na lista em cada estado do Brasil.

```http
  GET /candidatos/estado
```

#### Retorna o percentual de obesos entre os homens e entre as mulheres.
```http
  GET /candidatos/percentualObesidade
```

#### Retorna IMC médio em cada faixa de idade de dez em dez anos: 0 a 10; 11 a 20; 21 a 30, etc.

```http
  GET /candidatos/imcmedio
```

#### Retorna a média de idade para cada tipo sanguíneo.

```http
  GET /candidatos/mediaIdadeTipoSanguineo
```

#### Retorna a quantidade de possíveis doadores para cada tipo sanguíneo receptor.

```http
  GET /candidatos/quantidadeReceptores
```


