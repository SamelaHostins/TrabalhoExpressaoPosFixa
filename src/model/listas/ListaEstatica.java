package model.listas;

public class ListaEstatica <T> implements Lista<T> {
	private T[] info;
	private int tamanho;
	

	public ListaEstatica() {
		info = (T[]) new Object[10];
		tamanho = 0;
	}

	@Override
	public void inserir(T valor) {
		if (tamanho == info.length) {
			this.redimensionar();
		}
		info[tamanho] = valor;
		tamanho++;
	}

	private void redimensionar() {
		T[] novo = (T[]) new Object[info.length + 10];
		for (int i = 0; i < info.length; i++) {
			novo[i] = info[i];
		}
		info = novo;
	}

	@Override
	public String exibir() {
		String retorno = "[";
		for (int i = 0; i < tamanho; i++) {
			retorno += info[i] + ", ";
		}
		return retorno + "]";
	}

	@Override
	public int buscar(T valor) {
		for (int i = 0; i < tamanho; i++) {
			if (info[i].equals(valor)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void retirar(T valor) {
		int posicao = buscar(valor);
		if (posicao != -1) {
			for (int i = posicao; i < tamanho - 1; i++) {
				info[i] = info[i + 1];
			}
			tamanho--;
		}
	}

	@Override
	public Lista<T> copiar() {
		Lista<T> novaLista = new ListaEstatica<>();

		for (int i = 0; i < this.tamanho; i++) {
			novaLista.inserir(this.info[i]);
		}

		return novaLista;
	}

	@Override
	public void concatenar(Lista<T> outra) {
		for (int i = 0; i < outra.getTamanho(); i++) {
			inserir(outra.pegar(i));
		}
	}

	@Override
	public int getTamanho() {
		return this.tamanho;
	}

	@Override
	public boolean estaVazia() {
		return (tamanho == 0);
	}

	@Override
	public Lista<T> dividir() {
		int metade = tamanho / 2;
		Lista<T> novaLista = new ListaEstatica<>();

		for (int i = metade; i < tamanho; i++) {
			novaLista.inserir(this.info[i]);
		}
		tamanho = metade;

		return novaLista;
	}

	@Override
	public T pegar(int posicao) {
		return info[posicao];
	}

}
