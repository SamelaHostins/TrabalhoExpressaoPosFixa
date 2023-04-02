package view;

import model.listas.ListaEncadeada;

public class TesteLista {

	public static void main(String[] args) {

		ListaEncadeada<String> lista1 = new ListaEncadeada<String>();
		lista1.inserir("L"); // 0
		lista1.inserir("M"); // 1
		lista1.inserir("A"); // 2
		lista1.inserir("B"); // 3
		lista1.inserir("M"); // 4
		lista1.inserir("N"); // 5
		lista1.inserir("O"); // 6
		lista1.inserir("P"); // 7
		lista1.inserir("P"); // 8

		ListaEncadeada<String> lista2 = new ListaEncadeada<String>();
		lista2.inserir("S"); // 0
		lista2.inserir("A"); // 1
		lista2.inserir("M"); // 2
		lista2.inserir("Y"); // 3

		ListaEncadeada<String> lista3 = new ListaEncadeada<String>();
		lista3.inserir("L"); // 0
		lista3.inserir("U"); // 1
		lista3.inserir("N"); // 2

		// lista2.inserir("F"); // 2
		// lista2.inserir("H"); // 2

		System.out.println("Lista: " + lista2.exibir());
		System.out.println("Lista: " + lista3.exibir());
		System.out.println("Lista intercalada: "+ lista2.intercalaSamy(lista3).exibir());
		// System.out.println("Lista: " + lista2.copiar().exibir());
		System.out.println(" O último índice do M deve ser 4: " +
				lista1.ultimoIndiceDe("M"));
		// System.out.println(" O último índice do P deve ser 8: " +
		// lista1.ultimoIndiceDe("P"));
		// System.out.println(" O último índice do K deve ser -1: " +
		// lista1.ultimoIndiceDe("K"));
		// System.out.println("Lista intercalada: "+ lista1.intercala(lista2).exibir());
	}
}
