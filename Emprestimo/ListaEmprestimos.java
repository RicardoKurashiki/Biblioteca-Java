package Emprestimo;

import java.util.ArrayList;
import java.io.Serializable;
import Item.Disponibilidade;

public class ListaEmprestimos implements Serializable{

	private ArrayList<Emprestimo> alEmprestimos;

	// -> Construtores
	public ListaEmprestimos(ArrayList<Emprestimo> alEmprestimos) {
		this.alEmprestimos = alEmprestimos;
	}

	public ListaEmprestimos() {
		this.alEmprestimos = new ArrayList<Emprestimo>();
	}

	// -> Getters e Setters
	public ArrayList<Emprestimo> getAlEmprestimos() {
		return this.alEmprestimos;
	}

	public void addEmprestimo(Emprestimo emprestimo) {
		emprestimo.getItem().setDisponibilidade(Disponibilidade.EMPRESTADO);
		this.alEmprestimos.add(emprestimo);
	}

	public void removeEmprestimo(Emprestimo emprestimo) {
		emprestimo.getItem().setDisponibilidade(Disponibilidade.DISPONIVEL);
		this.alEmprestimos.remove(emprestimo);
	}

	// toString
}
