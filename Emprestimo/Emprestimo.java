package Emprestimo;

/** 
 * Classe de objetos de tipo Empréstimo, onde serão contidos os atributos e os métodos dos mesmos.
 * @author Carlos Eduardo Marques A. Torres e Ricardo G. Kurashiki
 */

import java.time.LocalDate;
import java.io.Serializable;

import Amigo.Amigo;
import Item.Item;

public class Emprestimo implements Serializable {

	private Item item;
	private Amigo amigo;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;

	/**
	 * Método construtor para objetos da classe Empréstimo.
	 * @param amigo - Recebe um objeto do tipo Amigo para registrar na classe.
	 * @param item - Recebe um objeto de tipo Item para registrar na classe.
	 * @param dataEmprestimo - Recebe um LocalDate para registro da data de empréstimo do Item.
	 * @param dataDevolucao - Recebe um LocalDate para registro da data de devolução do Item.
	 */
	public Emprestimo(Amigo amigo, Item item, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
		this.amigo = amigo;
		this.item = item;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	/**
	 * Método construtor para objetos da classe Empréstimo.
	 * @param amigo - Recebe um objeto do tipo Amigo para registrar na classe.
	 * @param item - Recebe um objeto de tipo Item para registrar na classe.
	 * @param dataEmprestimo - Recebe um LocalDate para registro da data de empréstimo do Item.
	 */
	public Emprestimo(Amigo amigo, Item item, LocalDate dataEmprestimo) {
		this.amigo = amigo;
		this.item = item;
		this.dataEmprestimo = dataEmprestimo;
	}

	/**
	 * Método construtor para objetos da classe Empréstimo.
	 * @param amigo - Recebe um objeto do tipo Amigo para registrar na classe.
	 * @param item - Recebe um objeto de tipo Item para registrar na classe.
	 */
	public Emprestimo(Amigo amigo, Item item) {
		this.amigo = amigo;
		this.item = item;
		this.dataEmprestimo = LocalDate.now();
	}

	/**
	 * Método que possibilita acessar o ID do amigo que realizou o empréstimo.
	 * @return amigo.getIdAmigo - Retorna o inteiro que representa o ID do amigo relacionado ao empréstimo.
	 */
	public int getIdAmigo() {return this.amigo.getIdAmigo();}

	/**
	 * Método que possibilita acessar o ID do item emprestado.
	 * @return item.getIdItem - Retorna o inteiro que representa o ID do item emprestado.
	 */
	public int getIdItem() {return this.item.getIdItem();}

	/**
	 * Método que permite acessar o objeto do tipo Item relacionado ao empréstimo.
	 * @return item - Retorna o objeto do tipo Item relacionado ao empréstimo.
	 */
	public Item getItem() {return this.item;}

	/**
	 * Método que permite acessar o objeto do tipo Amigo relacionado ao empréstimo.
	 * @return amigo - Retorna o objeto do tipo Amigo relacionado ao empréstimo.
	 */
	public Amigo getAmigo() {return this.amigo;}

	/**
	 * Método getter do atributo dataEmprestimo.
	 * @return dataEmprestimo - Retorna um LocalDate que representa a data em que foi realizado o empréstimo.
	 */
	public LocalDate getDataEmprestimo() {return this.dataEmprestimo;}

	/**
	 * Método getter do atributo dataDevolucao.
	 * @return dataDevolucao - Retorna um LocalDate que representa a data em que foi realizada a devolução do objeto.
	 */
	public LocalDate getDataDevolucao() {return this.dataDevolucao;}

	/**
	 * Método setter do atributo dataEmprestimo.
	 * @param data - Recebe como parâmetro uma LocalDate para substituir a data de empréstimo.
	 */
	public void setDataEmprestimo(LocalDate data) {this.dataEmprestimo = data;}

	/**
	 * Método setter do atributo dataEmprestimo com inteiros.
	 * @param dia - Recebe um inteiro que representa o dia do empréstimo.
	 * @param mes - Recebe um inteiro que representa o mês do empréstimo.
	 * @param ano - Recebe um inteiro que representa o ano do empréstimo.
	 */
	public void setDataEmprestimo(int dia, int mes, int ano) {this.dataEmprestimo = LocalDate.of(ano, mes, dia);}

	/**
	 * Método setter do atributo dataDevolucao.
	 * @param data - Recebe como parâmetro uma LocalDate para substituir a data de devolução.
	 */
	public void setDataDevolucao(LocalDate data) {this.dataDevolucao = data;}

	/**
	 * Método setter do atributo dataDevolucao com inteiros.
	 * @param dia - Recebe um inteiro que representa o dia da devolução.
	 * @param mes - Recebe um inteiro que representa o mês da devolução.
	 * @param ano - Recebe um inteiro que representa o ano da devolução.
	 */
	public void setDataDevolucao(int dia, int mes, int ano) {this.dataDevolucao = LocalDate.of(ano, mes, dia);}

	@Override
	/**
	 * Função que permite a visualização geral da classe Empréstimo.
	 */
	public String toString() {
		if (this.dataDevolucao == null)
			return this.amigo + " - " + this.item + "\n" + this.dataEmprestimo + "\nAinda nao foi devolvido";
		else
			return this.amigo + " - " + this.item + "\n" + this.dataEmprestimo + "\n" + this.dataDevolucao;
	}

}
