package Emprestimo;

import java.time.LocalDate;
import java.io.Serializable;

import Amigo.Amigo;
import Item.Item;

public class Emprestimo implements Serializable {

	private Item item;
	private Amigo amigo;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;

	// -> Construtores
	public Emprestimo(Amigo amigo, Item item, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
		this.amigo = amigo;
		this.item = item;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	public Emprestimo(Amigo amigo, Item item, LocalDate dataEmprestimo) {
		this.amigo = amigo;
		this.item = item;
		this.dataEmprestimo = dataEmprestimo;
	}

	public Emprestimo(Amigo amigo, Item item) {
		this.amigo = amigo;
		this.item = item;
		this.dataEmprestimo = LocalDate.now();
	}

	// -> Getters e Setters
	public int getIdAmigo() {
		return this.amigo.getIdAmigo();
	}

	public int getIdItem() {
		return this.item.getIdItem();
	}

	public Item getItem() {
		return this.item;
	}

	public Amigo getAmigo() {
		return this.amigo;
	}

	public LocalDate getDataEmprestimo() {
		return this.dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return this.dataDevolucao;
	}

	public void setDataEmprestimo(LocalDate data) {
		this.dataEmprestimo = data;
	}

	public void setDataEmprestimo(int dia, int mes, int ano) {
		this.dataEmprestimo = LocalDate.of(ano, mes, dia);
	}

	public void setDataDevolucao(LocalDate data) {
		this.dataDevolucao = data;
	}

	public void setDataDevolucao(int dia, int mes, int ano) {
		this.dataDevolucao = LocalDate.of(ano, mes, dia);
	}

	@Override
	public String toString() {
		if (this.dataDevolucao == null)
			return this.amigo + " - " + this.item + "\n" + this.dataEmprestimo + "\nAinda nao foi devolvido";
		else
			return this.amigo + " - " + this.item + "\n" + this.dataEmprestimo + "\n" + this.dataDevolucao;
	}

}
