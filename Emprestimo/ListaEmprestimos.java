package Emprestimo;

/** 
 * Classe de objetos de tipo ListaEmprestimos, onde serão contidos os atributos e os métodos dos mesmos.
 * @author Carlos Eduardo Marques A. Torres e Ricardo G. Kurashiki
 */

import java.util.ArrayList;
import java.io.Serializable;
import Item.Disponibilidade;

public class ListaEmprestimos implements Serializable {

	private ArrayList<Emprestimo> alEmprestimos;

	/**
	 * Método construtor para o objeto ListaEmprestimos, este método recebe uma ArrayList de Empréstimo.
	 * @param alEmprestimos - ArrayList de Empréstimo para a construção do objeto ListaEmprestimos.
	 */
	public ListaEmprestimos(ArrayList<Emprestimo> alEmprestimos) {
		this.alEmprestimos = alEmprestimos;
	}

	/**
	 * Método construtor para o objeto ListaEmprestimos, este método não recebe nada, e realiza a 
	 * criação de uma ArrayList de Empréstimo vazia.
	 */
	public ListaEmprestimos() {
		this.alEmprestimos = new ArrayList<Emprestimo>();
	}

	/**
	 * Metodo getter para o atributo alEmprestimos.
	 * @return alEmprestimos - Retorna uma ArrayList do tipo Empréstimo.
	 */
	public ArrayList<Emprestimo> getAlEmprestimos() {
		return this.alEmprestimos;
	}

	/**
	 * Método setter para o atributo alEmprestimos.
	 * @param alEmprestimos - Recebe uma ArrayList do tipo Empréstimo para fazer a substituição do atributo
	 * da classe.
	 */
	public void setAlEmprestimos(ArrayList<Emprestimo> alEmprestimos) {
		this.alEmprestimos = alEmprestimos;
	}

	/**
	 * Método que permite adicionar novos Empréstimos a ArrayList da classe.
	 * @param emprestimo - Recebe como parâmetro um objeto do tipo Empréstimo para adicionar a ArrayList.
	 */
	public void addEmprestimo(Emprestimo emprestimo) {
		emprestimo.getItem().setDisponibilidade(Disponibilidade.EMPRESTADO);
		this.alEmprestimos.add(emprestimo);
	}

	/**
	 * Método que permite remover Empréstimos da ArrayList da classe.
	 * @param emprestimo - Recebe como parâmetro um objeto do tipo Empréstimo para remover da ArrayList.
	 */
	public void removeEmprestimo(Emprestimo emprestimo) {
		emprestimo.getItem().setDisponibilidade(Disponibilidade.DISPONIVEL);
		this.alEmprestimos.remove(emprestimo);
	}

	@Override
	/**
	 * Função que permite a visualização geral da classe ListaEmprestimo.
	 */
	public String toString() {
		String texto = "";
		for (Emprestimo emprestimo : this.alEmprestimos) {
			texto += emprestimo.toString() + "\n";
		}
		return "Lista de Emprestimos\n" + texto;
	}
}
