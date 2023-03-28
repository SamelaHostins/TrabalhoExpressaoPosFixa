package view;

import model.listas.ListaEncadeada;

public class TesteListaEscadeada {

    public static void main(String[] args) {

        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();

        lista.inserir(50);
        lista.inserir(-15);
        lista.inserir(12);
        lista.inserir(28);
        lista.inserir(91);
        lista.inserir(17);
        System.out.println("Lista original = " + lista.exibir());
        // int valor = lista.buscar(17);
        // int valorMenosUm = lista.buscar(1);

        // System.out.println("posição do valor buscado: " + valor);
        // System.out.println("posição do valor buscado deve retornar -1: " + valorMenosUm);

        lista.retirar(28);
        System.out.println("Lista original = " + lista.exibir());

    }
}
