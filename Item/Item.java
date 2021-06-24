package Item;

/** 
 * Classe de objetos de tipo Item, onde serão contidos os atributos e os métodos dos mesmos.
 * @author Carlos Eduardo Marques A. Torres e Ricardo G. Kurashiki
 */

import java.io.Serializable;

public abstract class Item implements Comparable<Item>, Serializable{

	private int idItem;
	private String tituloItem;
	private Disponibilidade dispItem;

	/**
	 * Método getter para o atributo idItem.
	 * @return idItem - Retorna um inteiro que representa o ID do Item.
	 */
	public int getIdItem() {return this.idItem;}

	/**
	 * Método getter para o atributo tituloItem.
	 * @return tituloItem - Retorna uma string que representa o título do Item.
	 */
	public String getTituloItem() {return this.tituloItem;}

	/**
	 * Método getter para o atributo dispItem.
	 * @return dispItem - Retorna um enum que representa a disponibilidade do Item.
	 */
	public Disponibilidade getDisponibilidade() {return this.dispItem;}

	/**
	 * Método setter para o atributo idItem.
	 * @param id - Recebe como parâmetro um inteiro que substituirá o id do Item.
	 */
	protected void setIdItem(int id) {this.idItem = id;}

	/**
	 * Método setter para o atributo tituloItem.
	 * @param titulo - Recebe como parâmetro uma string que substituirá a título do Item.
	 */
	protected void setTitulo(String titulo) {this.tituloItem = titulo;}

	/**
	 * Método setter para o atributo dispItem.
	 * @param disponibilidade - Recebe como parâmtro um enum de Disponibilidade para alterar o estado de
	 * disponibilidade do Item.
	 */
	public void setDisponibilidade(Disponibilidade disponibilidade) {this.dispItem = disponibilidade;}

	@Override
	/**
	 * Função que permite a visualização geral da classe Item.
	 */
	public String toString() {
		return "Título: " + tituloItem + ", ID: " + idItem;
	}

	@Override
	/**
	 * Função que define a ordem natural da classe, no caso, é utilizando o título dos itens.
	 */
	public int compareTo(Item outroItem){
		return tituloItem.compareTo(outroItem.getTituloItem());
	}
}
