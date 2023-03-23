// package model.Calculadora;

// public class Teste {
    
//     public double comparaElementosExpressao() {
//         String[] arrayExpressao = this.getExpressao().split(" ");
//         double resultado = 0.0;
//         int i = 0;
//         while (i < arrayExpressao.length) {
//             String elemento = arrayExpressao[i];
//             i++;
//             try {
//                 if (isOperador(elemento)) {
//                     double valorDaDireita = pilha.pop();
//                     double valorDaEsquerda = pilha.pop();
//                     resultado = calcular(valorDaEsquerda, valorDaDireita, elemento);
//                     pilha.push(resultado);
//                 } else {
//                     double numero = Double.parseDouble(elemento);
//                     this.pilha.push(numero);
//                 }
//             } catch (Exception e) {
//                 i = 0;
//                 System.out.println(
//                         "Não foi possível realizar a operação. Por favor verifique a expressão e tente novamente.");
//                 getExpressaoUsuario();
//                 arrayExpressao = new String[this.getExpressao().length()];
//                 arrayExpressao = this.getExpressao().split(" ");
//                 resultado = 0.0;
//             }
//         }
//         return resultado;
//     }
// }
