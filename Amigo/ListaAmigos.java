package Amigo;

import java.util.ArrayList;
import java.io.Serializable;

public class ListaAmigos implements Serializable{

	private ArrayList<Amigo> alAmigos;

	// -> Construtor
	public ListaAmigos(ArrayList<Amigo> alAmigos) {
		this.alAmigos = alAmigos;
	}

	public ListaAmigos() {
		this.alAmigos = new ArrayList<Amigo>();
	}

	// -> Getters e Setters
	public ArrayList<Amigo> getListaAmigos() {
		return this.alAmigos;
	}

	public int getTamanhoLista() {
		return this.alAmigos.size();
	}

	public void addAmigo(Amigo novoAmigo) {
		this.alAmigos.add(novoAmigo);
	}

	// -> ToString
	@Override
	public String toString() {
		String texto = "";
		for (Amigo amigo : this.alAmigos) {
			texto += amigo.getIdAmigo() + " - " + amigo.getNomeAmigo() + "\n";
		}
		return texto;
	}
}
