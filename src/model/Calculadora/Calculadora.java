package model.Calculadora;

import java.util.Scanner;

import model.Lista.ListaEncadeada;
import model.Pilha.Pilha;
import model.Pilha.PilhaLista;
import model.Pilha.PilhaVetor;

public class Calculadora {

    private Pilha<Double> pilha;
    private String respostaUsuario;
    private Scanner teclado = new Scanner(System.in);
    private String expressao;

    public String getExpressao() {
        return expressao;
    }

    public void setExpressao(String expressao) {
        this.expressao = expressao;
    }

    public String getRespostaUsuario() {
        return respostaUsuario;
    }

    public void setRespostaUsuario(String respostaUsuario) {
        this.respostaUsuario = respostaUsuario;
    }

    public Pilha<Double> getPilha() {
        return pilha;
    }

    public void setPilha(Pilha<Double> pilhaVetor) {
        this.pilha = pilhaVetor;
    }

    public void iniciarCalculadora() {
        System.out.println("========= CALCULADORA =========");
        System.out.println();
        System.out.println("Para utilizar uma pilha baseada em vetor, digite 'V'.");
        System.out.println("Para utilizar uma pilha baseada em lista dinâmica, digite 'D'.");
        System.out.println();
    }

    public void getTipoPilha() {
        String resp = "";
        this.iniciarCalculadora();
        while (true) {
            System.out.println("Escolha o tipo de pilha que deseja implementar: ");
            resp = teclado.nextLine();
            if (resp.toUpperCase().equals("V") || resp.toUpperCase().equals("D")) {
                this.setRespostaUsuario(resp);
                break;
            }
        }
    }

    public void criaTipoPilha() {
        switch (respostaUsuario.toUpperCase()) {
            case "V":
                this.setPilha(new PilhaVetor<>(expressao.length()));
                break;
            case "D":
                this.setPilha(new PilhaLista<>());
                break;
            default:
                System.out.println("Não foi possível criar a pilha.");
        }
    }

    public void getExpressaoUsuario() {
        boolean expressaoValida = false;

        while (!expressaoValida) {
            System.out.println("Digite a expressão aritmétrica: ");
            String expressaoUsuario = teclado.nextLine();

            if (this.validarExpressao(expressaoUsuario)) {
                expressaoValida = true;
                this.setExpressao(expressaoUsuario);
            } else {
                System.out.println("Expressão inválida.");
            }
        }
    }

    // metodo para calcular qd for pilha vetor não finalizado nem testado
    public double calcularExpressao() {
        String[] expressaoPassada = new String[this.getExpressao().length()];
        expressaoPassada = this.getExpressao().split("\\s+");
        double numero1, numero2;
        double resultado = 0.0;
        try {
            for (String digito : expressaoPassada) {
                if (validarOperador(digito)) {
                    numero2 = pilha.pop(); // precisa retirar do final para o inicio
                    numero1 = pilha.pop();
                    resultado = calcular(numero1, numero2, digito);
                    pilha.push(resultado); // retorna resultado
                } else {
                    double numero = Double.parseDouble(digito); // precisa converter pois está como string
                    this.pilha.push(numero); // retorna resultado
                }
            }
            // return pilha.pop();
        } catch (Exception e) {
            System.out.println(
                    "Não foi possível realizar a operação. Por favor verifique a expressão e tente novamente.");
            getExpressaoUsuario();
            expressaoPassada = new String[this.getExpressao().length()];
            expressaoPassada = this.getExpressao().split(" ");
            resultado = 0.0;
        }
        return resultado;
    }

    // metodo novo
    public boolean validarExpressao(String expressao) {
        int qtdNumeros = 0;
        int qtdOperadores = 0;
        String[] expressaoPassada = expressao.split("\\s+"); // cria um vetor dividindo pelo espaço
        for (String digito : expressaoPassada) {
            if (digito.matches("\\d+")) {
                qtdNumeros++;
            } else if (digito.matches("[a-zA-Z]+")) {
                return false;
            } else {
                qtdOperadores++;
            }
        }
        if (qtdOperadores + 1 != qtdNumeros) {
            return false;
        }
        return true;
    }

    //metodo novo
    private boolean validarOperador(String digito) {
    boolean operador = false;
    if (digito.length() == 1
    && (isOperador(digito))) {
    operador = true;
    }
    return operador;
    }

    private boolean isOperador(String element) {
    return new ListaEncadeada<>(new String[] { "-", "+", "/", "*"
    }).contains(element);
    }

    // private boolean validarOperador(String digito) {
    //     boolean operador = false;
    //     if (digito.length() == 1
    //             && (digito.equals("+") || digito.equals("-") || digito.equals("/") || digito.equals("*"))) {
    //         operador = true;
    //     }
    //     return operador;
    // }

    public double calcular(double numero1, double numero2, String operador) {
        switch (operador) {
            case "+":
                return numero1 + numero2;
            case "-":
                return numero1 - numero2;
            case "*":
                return numero1 * numero2;
            case "/":
                if (numero2 == 0) {
                    System.out.println(
                            "Não é possível realizar divisão por zero. Por favor verifique a expressão e tente novamente.");
                }
                return numero1 / numero2;
            default:
                return 0.0;
        }
    }

    // public double calculo(double resultado1, double resultado2, String operador)
    // {
    // if (operador.equals("/")) {
    // return resultado1 / resultado2;
    // } else if (operador.equals("*")) {
    // return resultado1 * resultado2;
    // } else if (operador.equals("-")) {
    // return resultado1 - resultado2;
    // } else if (operador.equals("+")) {
    // return resultado1 + resultado2;
    // } else {
    // return 0.0;
    // }
    // }
}
