package model.Pilha;

public class PilhaVetor<T> implements Pilha<T> {

	private int limite; // limite de tamanho que a pilha pode ter
	private int tamanho = 0; // tamanho da pilha
	private T[] info;

	public PilhaVetor(int limite) {
		this.info = (T[]) new Object[limite];
		this.limite = limite;
	}

	@Override
	public void push(T v) {
		// verifica se tem espaço na pilha
		if (this.tamanho == this.limite) {
			throw new RuntimeException("A pilha está cheia!");
		}
		this.info[tamanho] = v;
		this.tamanho += 1;

	}

	@Override
	public T pop() {
		if (!estaVazia()) {
			T elemento = this.info[tamanho - 1];
			this.info[tamanho - 1] = null; // anula a referencia
			this.tamanho -= 1;
			return elemento;
		} else {
			throw new RuntimeException("A pilha vazia.");
		}
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new RuntimeException("A pilha está vazia.");
		}
		return this.info[tamanho - 1];
	}

	@Override
	public boolean estaVazia() {
		return this.tamanho == 0;
	}

	@Override
	public void liberar() {
		this.info = (T[]) new Object[this.limite];
		this.tamanho = 0;
	}

	@Override
	public String toString() {
		String elementos = "";

		for (int i = this.tamanho - 1; i >= 0; i--) {
			elementos += this.info[i] + ", ";
		}
		elementos = elementos.substring(0, Math.max(0, elementos.length() - 2));
		return "topo[" + elementos + "]base";
	}
}
