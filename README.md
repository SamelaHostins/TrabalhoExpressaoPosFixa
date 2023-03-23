# TrabalhoExpressaoPosFixa
Desenvolva uma aplicação que, a partir de uma expressão informada pelo usuário, exiba 
o resultado da operação.

Utilizando pilha, implemente uma classe Calculadora que compute expressões 
aritméticas, conforme demonstrado abaixo.
Sua aplicação usará a notação pós-fixa, cuja expressão será informada pelo usuário 
através de uma entrada de dados (String), na qual os operandos e operadores possuem ao 
menos um espaço em branco entre eles.

Exemplo: 
Expressão (1-2)*(4+5) em notação pós-fixa 1 2 - 4 5 + *
Expressão ((23.4+12)/7)*(5.8+(3-12)) em notação pós-fixa 23.4 12 + 7 / 3 12 – 5.8 + *
Eventualmente o usuário digitou errado a expressão, fazendo com que não consiga ser 
computada. 
Situações de erro:
1 2 - + : nesta situação não há operandos suficientes para realizar a soma
1 2 3 / : nesta situação faltou algum operador para usar todos os elementos da expressão
Na interface com o usuário, além da entrada para a expressão aritmética pós-fixa, deve 
haver uma forma do usuário escolher qual pilha ele quer usar: baseada em vetor ou 
dinâmica.
