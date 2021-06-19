package Emprestimo;

import java.time.LocalDate;

import Amigo.Amigo;
import Item.Item;

public class Emprestimo {

	private int idAmigo;
	private int idItem;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;

	// para a equipe pensar nesta repeti��o, pois pode-se obter os objetos pelo IDs
	private Item item;
	private Amigo amigo;

	// -> Construtores
	public Emprestimo(int idAmigo, int idItem, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
		this.idAmigo = idAmigo;
		this.idItem = idItem;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	public Emprestimo(int idAmigo, int idItem, LocalDate dataEmprestimo) {
		this.idAmigo = idAmigo;
		this.idItem = idItem;
		this.dataEmprestimo = dataEmprestimo;
	}

	public Emprestimo(int idAmigo, int idItem) {
		this.idAmigo = idAmigo;
		this.idItem = idItem;
		this.dataEmprestimo = LocalDate.now();
	}

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
		return this.idAmigo;
	}

	public int getIdAmigoClasse() {
		return this.amigo.getIdAmigo();
	}

	public int getIdItem() {
		return this.idItem;
	}

	public int getIdItemClasse() {
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

	public void setIdAmigo(int id) {
		this.idAmigo = id;
	}

	public void setIdAmigo(Amigo amigo) {
		this.idAmigo = amigo.getIdAmigo();
	}

	public void setIdItem(int id) {
		this.idItem = id;
	}

	public void setIdItem(Item item) {
		this.idItem = item.getIdItem();
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

}
