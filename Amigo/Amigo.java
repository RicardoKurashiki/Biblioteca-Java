package Amigo;

/** 
 * Classe de objetos de tipo Amigo, onde serão contidos os atributos e os métodos dos mesmos.
 * @author Carlos Eduardo Marques A. Torres e Ricardo G. Kurashiki
 */

import java.io.Serializable;

public class Amigo implements Serializable {

	private int idAmigo;
	private String nomeAmigo;

	/**
	 * Método construtor para a classe amigo.
	 * @param idAmigo - ID do amigo a ser registrado, deve ser implementado para ser gerado automáticamente.
	 * @param nomeAmigo - Nome do amigo a ser registrado.
	 */

	public Amigo(int idAmigo, String nomeAmigo) {
		this.idAmigo = idAmigo;
		this.nomeAmigo = nomeAmigo;
	}

	/**
	 * Getter para o atributo nomeAmigo.
	 * @return nomeAmigo - Nome do amigo registrado.
	 */
	public String getNomeAmigo() {return this.nomeAmigo;}

	/**
	 * Getter para o atributo idAmigo.
	 * @return idAmigo - ID do amigo registrado.
	 */
	public int getIdAmigo() {return this.idAmigo;}

	/**
	 * Setter para o atributo nomeAmigo, permitindo assim sua alteração.
	 * @param novoNome - Novo nome que deseja ser atribuído para o amigo.
	 */
	public void setNomeAmigo(String novoNome) {this.nomeAmigo = novoNome;}

	/**
	 * Setter para o atributo idAmigo, permitindo assim sua alteração.
	 * @param novoId - Novo ID que deseja ser atribuído para o amigo.
	 */
	public void setIdAmigo(int novoId) {this.idAmigo = novoId;}

	@Override
	/**
	 * Função que permite a visualização geral da classe Amigo.
	 */
	public String toString() {
		return this.nomeAmigo;
	}
}
