package Item;

import java.util.ArrayList;
import java.util.Iterator;

public class Biblioteca {

	private String nomeBib;
	private ArrayList<Item> alItem;

	// -> Construtores
	public Biblioteca(String nomeBib) {
		this.nomeBib = nomeBib;
		this.alItem = new ArrayList<Item>();
	}

	// -> Getters e Setters
	String getNomeBib() {
		return this.nomeBib;
	}

	ArrayList<Item> getAlItem() {
		return this.alItem;
	}

	void setNomeBib(String novoNome) {
		this.nomeBib = novoNome;
	}

	void addNovoItem(Item novoItem) {
		this.alItem.add(novoItem);
	}

	// m�todos, getters, setters, toString, compareTo etc conforme
	// a modelagem e encapsulamento que a equipe decidir implementar
	// v�rias op��es
}
