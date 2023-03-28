package view;

import model.listas.ListaEncadeada;

public class TesteLista {

	public static void main(String[] args) {
		
		ListaEncadeada<String> lista1 = new ListaEncadeada<String>();
//		lista1.inserir("A"); // 0
//		lista1.inserir("C"); // 1
//		lista1.inserir("E"); // 2
//		lista1.inserir("G"); // 3
		lista1.inserir("I");// 0
		lista1.inserir("J");// 1
		lista1.inserir("I");// 2
		lista1.inserir("J");// 3
		
		ListaEncadeada<String> lista2 = new ListaEncadeada<String>();
		lista2.inserir("B"); // 0
		lista2.inserir("D"); // 1
		lista2.inserir("D"); // 2
		lista2.inserir("D"); // 3
		lista2.inserir("D"); // 4
		
//		lista2.inserir("F"); // 2
//		lista2.inserir("H"); // 2
		
		System.out.println(" O último índice do número é : " + lista1.ultimoIndiceDe("J"));
		System.out.println(" O último índice do número é : " + lista2.ultimoIndiceDe("D"));
		System.out.println("Lista intercalada: "+ lista1.intercala(lista2).exibir());
	}
}
