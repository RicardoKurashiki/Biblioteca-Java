package Amigo;

/**
 * Classe de objetos de tipo ListaAmigos, onde serão contidos os atributos e os métodos dos mesmos.
 * @author Carlos Eduardo Marques A. Torres e Ricardo G. Kurashiki
 */

import java.util.ArrayList;
import java.io.Serializable;

public class ListaAmigos implements Serializable{

	private ArrayList<Amigo> alAmigos;

	/**
	 * Método construtor para o objeto ListaAmigos, este método recebe uma ArrayList de Amigo.
	 * @param alAmigos - ArrayList de amigo para a construção do objeto ListaAmigos.
	 */
	public ListaAmigos(ArrayList<Amigo> alAmigos) {
		this.alAmigos = alAmigos;
	}

	/**
	 * Método construtor para o objeto ListaAmigos, este método não recebe nada, e realiza a 
	 * criação de uma ArrayList de Amigo vazia.
	 */
	public ListaAmigos() {
		this.alAmigos = new ArrayList<Amigo>();
	}

	/**
	 * Método Getter que permite obter a ArrayList do objeto ListaAmigo.
	 * @return alAmigos - Retorna o atributo ArrayList.
	 */
	public ArrayList<Amigo> getListaAmigos() {return this.alAmigos;}
	
	/**
	 * Método Setter que permite substituir o atributo da classe ListaAmigo.
	 * @param alAmigos - Recebe uma ArrayList do tipo amigo, permitindo dessa forma substituir
	 * a ArrayList definida na criação.
	 */
	public void setListaAmigos(ArrayList<Amigo> alAmigos){this.alAmigos = alAmigos;}

	/**
	 * Método que permite obter o tamanho da ArrayList da classe ListaAmigos.
	 * @return alAmigos.size() - Retorna o tamanho da ArrayList do objeto.
	 */
	public int getTamanhoLista() {return this.alAmigos.size();}

	/**
	 * Método que permite adicionar novos Amigos no ListaAmigos.
	 * @param novoAmigo - Recebe um objeto do tipo Amigo para adicionar na ArrayList da ListaAmigo
	 */
	public void addAmigo(Amigo novoAmigo) {this.alAmigos.add(novoAmigo);}

	@Override
	/**
	 * Função que permite a visualização geral da classe ListaAmigos.
	 */
	public String toString() {
		String texto = "";
		for (Amigo amigo : this.alAmigos) {
			texto += amigo.getIdAmigo() + " - " + amigo.getNomeAmigo() + "\n";
		}
		return texto;
	}
}
