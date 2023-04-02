package model.filas;

public class FilaVetor<T> implements Fila<T> {

	private T[] info;
	private int limite;
	private int tamanho;
	private int inicio;

	public FilaVetor(int limite) {
		this.inicio = 0;
		this.limite = limite;
		this.tamanho = 0;
		this.info = (T[]) new Object[limite];
	}

	int getTamanho() {
		return this.tamanho;
	}

	int getLimite() {
		return this.limite;
	}

	@Override
	public void inserir(T valor) {
		if (this.tamanho == this.limite) {
			throw new RuntimeException("Fila está cheia");
		} else {
			int proximo = (this.inicio + this.tamanho) % this.limite;
			this.info[proximo] = valor;
			this.tamanho += 1;
		}
	}


	public FilaVetor<T> concatenar(FilaVetor<T> outra) {
		FilaVetor<T> novaFila = new FilaVetor<T>(this.getLimite() + outra.getLimite());

		for (int i = 0; i < this.getTamanho(); i++) {
			novaFila.inserir(this.pegar(i));
		}

		for (int i = 0; i < outra.getTamanho(); i++) {
			novaFila.inserir(outra.pegar(i));
		}
		return novaFila;
	}

	private T pegar(int indice) {
        return this.info[(indice + this.inicio) % limite];
    }
	

	@Override
	public T retirar() {
		T valor = this.peek();
		this.info[this.inicio] = null;
		this.inicio = (this.inicio + 1) % limite;
		this.tamanho--;
		return valor;
	}

	@Override
	public T peek() {
		if (estaVazio()) {
			throw new RuntimeException("Fila está vazia");
		}
		return this.info[this.inicio];
	}

	@Override
	public boolean estaVazio() {
		return this.tamanho == 0;
	}

	@Override
	public void liberar() {
		this.inicio = 0;
		this.tamanho = 0;
		this.info = (T[]) new Object[this.limite];
	}

	@Override
	public String toString() {
		String elementos = "";
		int posicao;
		for (int i = 0; i < this.getTamanho(); i++) {
			posicao = (this.inicio + i) % this.limite;
			elementos += info[posicao] + ", ";
		}
		elementos = elementos.substring(0, Math.max(0, elementos.length() - 2));
		return "[" + elementos + "]";
	}

}
