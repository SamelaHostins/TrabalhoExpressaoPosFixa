package model.Pilha;

import model.Lista.ListaEncadeada;

public class PilhaLista<T> implements Pilha<T> {

	private ListaEncadeada<T> lista;

	public PilhaLista() {
		lista = new ListaEncadeada<T>();
	}

	@Override
	public void push(T v) {
		lista.inserir(v);
	}

	@Override
	public T pop() {
		T valor = this.peek();
		lista.retirar(valor);
		return valor;
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new RuntimeException("Pilha está vazia.");
		}
		return lista.getPrimeiro().getInfo();
	}

	@Override
	public boolean estaVazia() {
		return lista.estaVazia();
	}

	@Override
	public void liberar() {
		this.lista = new ListaEncadeada<T>();
	}

	@Override
	public String toString() {
		return this.lista.toString();
	}
}
