package Item;

/** 
 * Classe de objetos de tipo Biblioteca, onde serão contidos os atributos e os métodos dos mesmos.
 * @author Carlos Eduardo Marques A. Torres e Ricardo G. Kurashiki
 */

import java.util.ArrayList;
import java.io.Serializable;

public class Biblioteca implements Serializable {

	private String nomeBib;
	private ArrayList<Item> alItem;

	/**
	 * Método construtor da classe Biblioteca.
	 * @param nomeBib - Recebe uma string que representa o nome da Biblioteca.
	 * @param alItem - Recebe uma ArrayList de Itens para seu acervo.
	 */
	public Biblioteca(String nomeBib, ArrayList<Item> alItem) {
		this.nomeBib = nomeBib;
		this.alItem = alItem;
	}

	/**
	 * Método construtor da classe Biblioteca.
	 * @param nomeBib - Recebe uma string que representa o nome da Biblioteca.
	 */
	public Biblioteca(String nomeBib) {
		this.nomeBib = nomeBib;
		this.alItem = new ArrayList<Item>();
	}

	/**
	 * Método getter para o atributo nomBib.
	 * @return nomeBib - Retorna uma string que representa o nome da Biblioteca.
	 */
	public String getNomeBib() {return this.nomeBib;}

	/**
	 * Método getter para o atributo alItem.
	 * @return alItem - Retorna uma ArrayList que representa o acervo de Itens da Biblioteca.
	 */
	public ArrayList<Item> getAlItem() {return this.alItem;}

	/**
	 * Método setter para o atributo alItem.
	 * @param alItem - Recebe como parâmetro uma ArrayList de Item para a substituição do atributo.
	 */
	public void setAlItem(ArrayList<Item> alItem) {this.alItem = alItem;}

	/**
	 * Método setter para o atributo nomeBib.
	 * @param novoNome - Recebe como parâmetro uma string para a substituição do atributo.
	 */
	public void setNomeBib(String novoNome) {this.nomeBib = novoNome;}

	/**
	 * Método que permite adicionar novos itens no acervo da Biblioteca.
	 * @param novoItem - Recebe como parâmetro um objeto de tipo Item, para adicionar no acervo da Biblioteca.
	 */
	public void addNovoItem(Item novoItem) {this.alItem.add(novoItem);}

	@Override
	/**
	 * Função que permite a visualização geral da classe Biblioteca.
	 */
	public String toString() {
		return "Biblioteca: " + nomeBib + ", com os seguintes itens: " + alItem;
	}

}
