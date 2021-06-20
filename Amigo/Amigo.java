package Amigo;
import java.io.Serializable;

public class Amigo implements Serializable{

	private int idAmigo;
	private String nomeAmigo;

	// -> Construtores
	public Amigo(int idAmigo, String nomeAmigo) {
		this.idAmigo = idAmigo;
		this.nomeAmigo = nomeAmigo;
	}

	// -> Getters e Setters
	public String getNomeAmigo() {
		return this.nomeAmigo;
	}

	public int getIdAmigo() {
		return this.idAmigo;
	}

	public void setNomeAmigo(String novoNome) {
		this.nomeAmigo = novoNome;
	}

	public void setIdAmigo(int novoId) {
		this.idAmigo = novoId;
	}

}
