package view;

import model.Calculadora.Calculadora;

public class TesteCalculadora 
{

	public static void main(String[] args)
	{
	 Calculadora calculadora = new Calculadora();

		// calculadora.getTipoPilha();
	
		// calculadora.getExpressaoUsuario();
		
		// System.out.println("Criando pilha!");
		
		// calculadora.criaTipoPilha();
		
		// System.out.println("O resultado da sua expressão é: " + calculadora.comparaElementosExpressao());

		// calculadora.validarExpressao("1 2  - +");
		calculadora.validarExpressao("1 0  - ");
		// calculadora.validarExpressao("1 2 3 /");
		// calculadora.validarExpressao("1 2 - 4 5 + *");
	}
}
