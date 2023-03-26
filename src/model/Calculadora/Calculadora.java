package model.Calculadora;

import java.util.Scanner;

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

    // Contribuição Gabriel
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

    // Contribuição Samy
    public double calcularExpressao() {
        String[] expressaoPassada = new String[this.getExpressao().length()];
        expressaoPassada = this.getExpressao().split("\\s+");
        double numero1, numero2;
        double resultado = 0.0;
            for (String digito : expressaoPassada) {
                if (validarOperador(digito)) {
                    numero2 = pilha.pop(); 
                    numero1 = pilha.pop(); 
                    resultado = calcular(numero1, numero2, digito);
                    pilha.push(resultado); 
                } else {
                    double numero = Double.parseDouble(digito); // precisa converter pois está como string
                    this.pilha.push(numero); 
                }
            }
        return resultado;
    }

    // Contribuição Gabriel
    public boolean validarExpressao(String expressao) {
        int qtdNumeros = 0;
        int qtdOperadores = 0;
        String digitoAnterior = "";
        String[] expressaoPassada = expressao.split("\\s+"); 
        for (String digito : expressaoPassada) {
            // Regex verifica numero positivo, negativo, double (com 1 '.')
            if (digito.matches("[-+]?\\d+[[.]?\\d+]*")) { 
                digitoAnterior = digito;
                qtdNumeros++;
            } else if (digito.matches("[a-zA-Z]+")) {
                return false;
            } else {
                // Valida se na expressao tem divisao por 0
                if (digito.equals("/") && digitoAnterior.equals("0")) {  
                    System.out.println("Incapaz de realizar divisão por 0!");
                    return false;
                }
                qtdOperadores++;
            }
        }
        if (qtdOperadores + 1 != qtdNumeros) {
            return false;
        }
        return true;
    }

    // Contribuição Samy
    private boolean validarOperador(String digito) {
        boolean operador = false;
        if (digito.length() == 1
                && (digito.equals("+") || digito.equals("-") || digito.equals("/") || digito.equals("*"))) {
            operador = true;
        }
        return operador;
    }

    // Contribuição Samy
    public double calcular(double numero1, double numero2, String operador) {
        switch (operador) {
            case "+":
                return numero1 + numero2;
            case "-":
                return numero1 - numero2;
            case "*":
                return numero1 * numero2;
            case "/":
                return numero1 / numero2;
            default:
                return 0.0;
        }
    }
}
