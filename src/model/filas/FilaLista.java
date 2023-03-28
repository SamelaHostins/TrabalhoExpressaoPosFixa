package model.filas;

import model.listas.ListaEncadeada;

public class FilaLista<T> implements Fila<T> {
	private ListaEncadeada<T> lista;

	public FilaLista() {
		lista = new ListaEncadeada<>();
	}

	@Override
	public void inserir(T valor) {
		lista.inserir(valor);
	}

	@Override
	public T retirar() {
		T valor = this.peek();
		lista.retirar(valor);
		return valor;
	}

	@Override
	public T peek() {
		try {
			return lista.pegar(0);
		} catch (IndexOutOfBoundsException iob) {
			throw new RuntimeException("Fila est� vazia");
		}
	}

	@Override
	public boolean estaVazio() {
		return lista.estaVazia();
	}

	@Override
	public void liberar() {
		lista = new ListaEncadeada<>();
	}

	@Override
	public String toString() {
		return lista.exibir();
	}
	
	

}