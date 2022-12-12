
# sistemaControleSangue

para iniciar ele é bem simples logo após abrir o projeto você
precisará configurar as configurações para
o projeto se conectar ao banco de dados para isso abra
o arquivo application.properties e informe a string do banco,
usuário e senha, com isso tudo já está configurado basta só 
rodar a aplicação.

/candidatos
(post)
Efetua o cadastro de uma lista de candidatos
/candidatos

(get)
Lista candidatos cadastrados (padrao 10 primeiros)

/candidatos/estado
(get)
Retorna quantidade de candidatos na lista em cada estado do Brasil.

/candidatos/imcmedio
(get)
Retorna  IMC médio em cada faixa de idade de dez em dez anos: 0 a 10; 11 a 20; 21 a 30, etc.

/candidatos/percentualObesidade
(get)
Retorna  o percentual de obesos entre os homens e entre as mulheres.

/candidatos/mediaIdadeTipoSanguineo
(get)
Retorna  a média de idade para cada tipo sanguíneo.

/candidatos/quantidadeReceptores
(get)
Retorna  a quantidade de possíveis doadores para cada tipo sanguíneo receptor.
