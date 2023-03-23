package model.Pilha;

import model.Lista.NoLista;

public class PilhaLista<T> implements Pilha<T> {

	private NoLista<T> topo;

	@Override
	public void push(T v) {
		NoLista<T> novo = new NoLista<>();
		novo.setInfo(v);
		novo.setProximo(this.topo);
		this.topo = novo;
	}

	@Override
	public T pop() {
		T elemento = this.peek();
		this.topo = this.topo.getProximo();
		return elemento;
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new RuntimeException("Pilha vazia.");
		}
		return this.topo.getInfo();
	}

	@Override
	public boolean estaVazia() {
		return (this.topo == null);
	}

	@Override
	public void liberar() {
		this.topo = null;
	}

	@Override
	public String toString() {
		String elementos = "";

		NoLista<T> t = this.topo;
		while (t != null) {
			elementos += t.getInfo() + ", ";
		}
		elementos = elementos.substring(0, Math.max(0, elementos.length() - 2));
		return "topo[" + elementos + "]base";
	}
}
