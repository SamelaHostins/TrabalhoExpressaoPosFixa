package model.Pilha;

import model.Lista.ListaEncadeada;

public class PilhaLista<T> implements Pilha<T> {

	private ListaEncadeada<T> lista;

	public PilhaLista() {
		this.lista = new ListaEncadeada<T>();
	}

	@Override
	public T pop() {
		T valor;
		valor = this.peek();
		this.lista.retirar(valor);
		return valor;
	}

	@Override
	public T peek() {

		if (this.estaVazia()) {
			throw new RuntimeException("Pilha vazia.");
		}
		return this.lista.getUltimo().getInfo();
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
	public void push(T valor) {
		this.lista.inserir(valor);
	}

	public String toString2() {
		return this.lista.exibir();
	}

	public int getTamanho() {
		return this.lista.getTamanho();
	}
}
