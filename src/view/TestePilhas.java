package view;

import model.Pilha.Pilha;
import model.Pilha.PilhaVetor;

public class TestePilhas {

	public static void main(String[] args) {
		System.out.println("Pilha Vetor");
		Pilha<Integer> pilha = new PilhaVetor<Integer>(3);
		pilha.push(2);
		pilha.push(3);
		pilha.push(1);
		try {
			pilha.push(1);
		} catch (Exception e) {
			System.out.println("Deu certo!");
		}
		System.out.println(pilha.toString());

		System.out.println("Retirou: " + pilha.pop() + ", deve retirar 1");
		System.out.println(pilha.toString());
		System.out.println("Último elemento da pilha: " + pilha.peek() + ", deve ser 3");
		System.out.println("Retirou: " + pilha.pop() + ", deve retirar 3");
		System.out.println("Último elemento da pilha: " + pilha.peek() + ", deve ser 2");
		System.out.println("Retirou: " + pilha.pop() + ", deve retirar 2");
		try {
			System.out.println(pilha.peek() + ", deve retornar uma lista vazia");
		} catch (Exception e) {
			System.out.println("Deu certo!");
		}

		pilha.push(20);
		pilha.push(30);
		pilha.push(10);
		System.out.println(pilha.toString());
		System.out.println("Deve liberar a pilha:");
		pilha.liberar();
		System.out.println(pilha.toString() + ", pilha deve estar vazia");
	}
}
