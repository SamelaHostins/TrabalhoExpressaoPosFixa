package view;

import model.Calculadora.Calculadora;

public class TesteCalculadora 
{

	public static void main(String[] args)
	{
	  Calculadora calculadora = new Calculadora();

	// 	calculadora.getTipoPilha();
	
	// 	calculadora.getExpressaoUsuario();
		
	// 	System.out.println("Criando pilha!");
	// 	System.out.println("");
		
	// 	calculadora.criaTipoPilha();
		
	// 	System.out.println("O resultado da sua expressão é: " + calculadora.calcularExpressao());

		calculadora.validarExpressao("3 1.5 /");
		// calculadora.validarExpressao("1 2 3 /");
		// calculadora.validarExpressao("1 2 - 4 5 + *");
	}
}
