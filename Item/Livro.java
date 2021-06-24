package Item;

/** 
 * Classe de objetos de tipo Livro, onde serão contidos os atributos e os métodos dos mesmos.
 * @author Carlos Eduardo Marques A. Torres e Ricardo G. Kurashiki
 */

public class Livro extends Item{
	private String autorLivro;
	private int totPagLivro;

	/**
	 * Método construtor para a classe Livro
	 * @param idItem - Recebe um inteiro para a identificação do item, atributo herdado da classe Item.
	 * @param tituloItem - Recebe uma string para o título do Livro, atributo herdado da classe Item.
	 * @param dispItem - Recebe um enum de Disponibilidade, atributo herdado da classe Item.
	 * @param autorLivro - Recebe uma string para designar o autor do livro.
	 * @param totPagLivro - Recebe um inteiro para identificar o número de páginas do livro.
	 */
	public Livro(int idItem, String tituloItem, Disponibilidade dispItem, String autorLivro, int totPagLivro) {
		super.setIdItem(idItem);
		super.setTitulo(tituloItem);
		super.setDisponibilidade(dispItem);
		this.autorLivro = autorLivro;
		this.totPagLivro = totPagLivro;
	}

	/**
	 * Método construtor para a classe Livro
	 * @param idItem - Recebe um inteiro para a identificação do item, atributo herdado da classe Item.
	 * @param tituloItem - Recebe uma string para o título do Livro, atributo herdado da classe Item.
	 * @param autorLivro - Recebe uma string para designar o autor do livro.
	 * @param totPagLivro - Recebe um inteiro para identificar o número de páginas do livro.
	 */
	public Livro(int idItem, String tituloItem, String autorLivro, int totPagLivro) {
		super.setIdItem(idItem);
		super.setTitulo(tituloItem);
		super.setDisponibilidade(Disponibilidade.DISPONIVEL);
		this.autorLivro = autorLivro;
		this.totPagLivro = totPagLivro;
	}

	/**
	 * Método construtor para a classe Livro
	 * @param idItem - Recebe um inteiro para a identificação do item, atributo herdado da classe Item.
	 * @param tituloItem - Recebe uma string para o título do Livro, atributo herdado da classe Item.
	 * @param autorLivro - Recebe uma string para designar o autor do livro.
	 */
	public Livro(int idItem, String tituloItem, String autorLivro) {
		super.setIdItem(idItem);
		super.setTitulo(tituloItem);
		super.setDisponibilidade(Disponibilidade.DISPONIVEL);
		this.autorLivro = autorLivro;
		this.totPagLivro = 0;
	}

	/**
	 * Método construtor para a classe Livro
	 * @param idItem - Recebe um inteiro para a identificação do item, atributo herdado da classe Item.
	 * @param tituloItem - Recebe uma string para o título do Livro, atributo herdado da classe Item.
	 * @param totPagLivro - Recebe um inteiro para identificar o número de páginas do livro.
	 */
	public Livro(int idItem, String tituloItem, int totPagLivro) {
		super.setIdItem(idItem);
		super.setTitulo(tituloItem);
		super.setDisponibilidade(Disponibilidade.DISPONIVEL);
		this.autorLivro = "Anonimo";
		this.totPagLivro = totPagLivro;
	}

	/**
	 * Método construtor para a classe Livro
	 * @param idItem - Recebe um inteiro para a identificação do item, atributo herdado da classe Item.
	 * @param tituloItem - Recebe uma string para o título do Livro, atributo herdado da classe Item. 
	 */
	public Livro(int idItem, String tituloItem) {
		super.setIdItem(idItem);
		super.setTitulo(tituloItem);
		super.setDisponibilidade(Disponibilidade.DISPONIVEL);
		this.autorLivro = "Anonimo";
		this.totPagLivro = 0;
	}

	/**
	 * Método getter para o atributo autorLivro.
	 * @return autorLivro - Retorna uma string que representa o autor do livro.
	 */
	public String getAutorItem() {return this.autorLivro;}

	/**
	 * Método getter para o atributo totPagLivro.
	 * @return totPagLivro - Retorna um inteiro que representa a quantidade de páginas do livro.
	 */
	public int getTotalPaginas() {return this.totPagLivro;}

	/**
	 * Método setter para o atributo autorLivro.
	 * @param nome - Recebe como parâmetro uma string que representa o novo nome do autor do livro.
	 */
	public void setAutorItem(String nome) {this.autorLivro = nome;}

	/**
	 * Método setter para o atributo totPagLivro.
	 * @param paginas - Recebe como parâmetro um inteiro que representa o novo número de páginas do livro.
	 */
	public void setTotalPaginas(int paginas) {this.totPagLivro = paginas;}

	@Override
	/**
	 * Função que permite a visualização geral da classe Livro.
	 */
	public String toString() {
		return "Livro: " + super.getTituloItem() + ", de " + this.autorLivro + ", com " + this.totPagLivro
				+ " paginas.";
	}

}
