package Item;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

public class Biblioteca implements Serializable{

	private String nomeBib;
	private ArrayList<Item> alItem;

	// -> Construtores
	public Biblioteca(String nomeBib, ArrayList<Item> alItem) {
		this.nomeBib = nomeBib;
		this.alItem = alItem;
	}

	public Biblioteca(String nomeBib) {
		this.nomeBib = nomeBib;
		this.alItem = new ArrayList<Item>();
	}

	// -> Getters e Setters
	public String getNomeBib() {
		return this.nomeBib;
	}

	public ArrayList<Item> getAlItem() {
		return this.alItem;
	}

	public void setNomeBib(String novoNome) {
		this.nomeBib = novoNome;
	}

	public void addNovoItem(Item novoItem) {
		this.alItem.add(novoItem);
	}

	// m�todos, getters, setters, toString, compareTo etc conforme
	// a modelagem e encapsulamento que a equipe decidir implementar
	// v�rias op��es
}
