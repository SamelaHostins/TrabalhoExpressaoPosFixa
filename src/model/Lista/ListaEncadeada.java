package model.Lista;

import java.util.Objects;

public class ListaEncadeada<T> implements Lista<T> {

	private NoLista<T> primeiro;
	private NoLista<T> ultimo;
	private int qtdElem;

	public ListaEncadeada(T[] elements) {
		for (int i=0;i<elements.length;i++) {
			this.inserir(elements[i]);
		}
	}

	public ListaEncadeada() {
	}

	
	public NoLista<T> getUltimo() {
		return ultimo;
	}

	public int getQtdElem() {
		return qtdElem;
	}

	public NoLista<T> getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(NoLista<T> primeiro) {
		this.primeiro = primeiro;
	}

	@Override
	public void inserir(T valor) {
		// inserção ao final da lista
		NoLista<T> novo = new NoLista();
		novo.setInfo(valor);

		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProximo(novo);
		}
		ultimo = novo;
		qtdElem++;
	}

	// public int ultimoIndiceDe(T x) {
	// 	int posicao = this.getTamanho() - 1;
	// 	NoLista<T> p = ultimo;

	// 	while (p != null) {
	// 		if (p.getInfo().equals(x)) {
	// 			return posicao;
	// 		}
	// 		posicao--;
	// 		p = p.getAnterior();
	// 	}
	// 	return -1;
	// }

	@Override
	public String exibir() {
		NoLista<T> p = primeiro;
		String resultado = "[";

		while (p != null) {
			resultado += p.getInfo() + ", ";
			p = p.getProximo();
		}

		return resultado + "]";
	}

	@Override
	public int buscar(T valor) {
		int posicao = 0;
		NoLista<T> p = primeiro;

		while (p != null) {
			if (p.getInfo().equals(valor)) {
				return posicao;
			}
			posicao++;
			p = p.getProximo();
		}
		return -1;
	}

	@Override
	public void retirar(T valor) {
		NoLista<T> anterior = null;
		NoLista<T> p = primeiro;

		while (p != null && !p.getInfo().equals(valor)) {
			anterior = p;
			p = p.getProximo();
		}

		if (p != null) {
			if (anterior == null) {
				primeiro = p.getProximo();
			} else {
				anterior.setProximo(p.getProximo());
			}
			qtdElem--;
			if (ultimo == p) {
				ultimo = anterior;
			}
		}
	}

	@Override
	public Lista<T> copiar() {
		ListaEncadeada<T> novaLista = new ListaEncadeada<>();
		NoLista<T> no = primeiro;

		while (no != null) {
			novaLista.inserir(no.getInfo());
			no = no.getProximo();
		}

		return novaLista;
	}

	@Override
	public void concatenar(Lista<T> outra) {
		for (int i = 0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}
	}

	@Override
	public int getTamanho() {
		return qtdElem;
	}

	@Override
	public boolean estaVazia() {
		return (primeiro == null);
	}

	@Override
	public Lista<T> dividir() {
		NoLista<T> no = primeiro;
		ListaEncadeada<T> listaNova = new ListaEncadeada<>();
		int metade = this.getTamanho() / 2;
		int contador = 1;
		NoLista<T> novoUltimo = null;

		while (no != null) {
			if (contador > metade) {
				listaNova.inserir(no.getInfo());
			} else {
				novoUltimo = no;
			}
			contador++;
			no = no.getProximo();
		}
		ultimo = novoUltimo;
		ultimo.setProximo(null);
		qtdElem = metade;
		return listaNova;
	}

	@Override
	public T pegar(int pos) {
		if (pos < 0 || pos >= this.qtdElem) {
			throw new IndexOutOfBoundsException("Posicao=" + pos + "; Tamanho=" + qtdElem);
		}
		NoLista<T> no = primeiro;

		for (int i = 0; i < pos; i++) {
			no = no.getProximo();
		}

		return no.getInfo();
	}

	public boolean contains(T element) {
		NoLista<T> no = getPrimeiro();
		while (Objects.nonNull(no)) {
			if (no.getInfo().equals(element)) {
				return true;
			}
			no = no.getProximo();
		}
		return false;
	}

}