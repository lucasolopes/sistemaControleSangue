# Processo Seletivo Java - WK

## Descrição 

- Este teste consiste em construir uma camada de serviço, para extraçao de dados muito realizada em bancos de sangue.


## Como executar a aplicação 

- Você pode executar a aplicação da maneira que quiser e utilizando a IDE de sua preferência. 
- Caso queira executar a aplicação via linha de comando, execute primeiramente o comando:

                   ./mvnw clean package  para linux.

                   .\mvnw clean package  para windows.

- Inicie o MYSQL
  
                    Padão:(127.0.0.1:8080 Login:root Password:root)
  
- Caso queira configurar o banco `./src/main/resources/application.properties`

- Após isso execute o comando: 

                             java -jar <...caminhoParaSeuJar>

- Após inciar o projeto rode o Config.sql para criar o usuario de moderador
- Caso queira alterar a senha codifique ela para sha256
                             
## Documentação da API

#### Login por Token

```http
  POST /auth
```

 | Tipo       | Descrição                           |
 :--------- | :---------------------------------- |
 | `JSON` | **Obrigatório**. json de login |

```
  {
    "email": "teste@teste.com",
    "senha": "123"
  }
```


#### Cadastra todos candidatos

```http
  POST /candidatos
```


 | Tipo       | Descrição                           |         
 :--------- | :---------------------------------- | 
 | `JSON` | **Obrigatório**. json de candidatos | 
 | `Bearer`| **Obrigatório**. Token|


```
  [
	{
		"nome": "Milena Analu Pires",
		"cpf": "775.256.099-50",
		"rg": "44.084.541-5",
		"data_nasc": "23\/05\/1964",
		"sexo": "Feminino",
		"mae": "Isadora Marli",
		"pai": "Noah Severino César Pires",
		"email": "mmilenaanalupires@keffin.com.br",
		"cep": "39801-678",
		"endereco": "Rua Kurt W. Rothe",
		"numero": 675,
		"bairro": "Castro Pires",
		"cidade": "Teófilo Otoni",
		"estado": "MG",
		"telefone_fixo": "(33) 3611-4613",
		"celular": "(33) 98481-0191",
		"altura": 1.53,
		"peso": 80,
		"tipo_sanguineo": "O-"
	},
	{
		"nome": "Marcos Vinicius Kevin Samuel Santos",
		"cpf": "024.934.035-68",
		"rg": "10.701.456-7",
		"data_nasc": "07\/09\/1992",
		"sexo": "Masculino",
		"mae": "Isabella Andrea",
		"pai": "Lorenzo Marcos André Santos",
		"email": "marcosviniciuskevinsamuelsantos_@dhl.com",
		"cep": "49091-043",
		"endereco": "Rua Manoel de Oliveira França",
		"numero": 634,
		"bairro": "Jardim Centenário",
		"cidade": "Aracaju",
		"estado": "SE",
		"telefone_fixo": "(79) 2686-2642",
		"celular": "(79) 99666-0063",
		"altura": 1.92,
		"peso": 95,
		"tipo_sanguineo": "O-"
	}
]
```

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


