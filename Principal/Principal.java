package Principal;

import java.util.Scanner;

import Item.Biblioteca;
import Item.BluRay;
import Item.CD;
import Item.Livro;
import Item.Disponibilidade;

import Amigo.Amigo;
import Amigo.ListaAmigos;

import Emprestimo.Emprestimo;
import Emprestimo.ListaEmprestimos;

public class Principal {
	public static void main(String[] args) {
		Biblioteca bib = new Biblioteca("Biblioteca Pessoal");
		ListaAmigos listaAmigos = new ListaAmigos();
		ListaEmprestimos listaEmprestimos = new ListaEmprestimos();
		boolean appOn = true;
		Scanner scanner = new Scanner(System.in);

		// --- DUMMIES --- //
		BluRay br1 = new BluRay(0, "As cronicas de Narnia");
		BluRay br2 = new BluRay(1, "Velozes e Furiosos");
		CD cd1 = new CD(2, "The Beatles");
		CD cd2 = new CD(3, "Chitaozinho e Xororo");
		Livro livro1 = new Livro(4, "Harry Potter");
		Livro livro2 = new Livro(5, "Jogador n1");

		bib.addNovoItem(br1);
		bib.addNovoItem(br2);
		bib.addNovoItem(cd1);
		bib.addNovoItem(cd2);
		bib.addNovoItem(livro1);
		bib.addNovoItem(livro2);

		Amigo amigo1 = new Amigo(0, "Carlos Eduardo");
		Amigo amigo2 = new Amigo(1, "Mateus Ferro");
		Amigo amigo3 = new Amigo(2, "Joao Klein");
		Amigo amigo4 = new Amigo(3, "Milena Silverio");

		listaAmigos.addAmigo(amigo1);
		listaAmigos.addAmigo(amigo2);
		listaAmigos.addAmigo(amigo3);
		listaAmigos.addAmigo(amigo4);
		// --- FIM DOS DUMMIES --- //

		while (appOn) {
			int escolha = menu();
			switch (escolha) {
				case 1:
					menuRegistrarItem(bib);
					break;
				case 2:
					menuRegistrarAmigo(listaAmigos);
					break;
				case 3:
					menuEmprestarItem(bib, listaAmigos, listaEmprestimos);
					break;
				case 4:
					menuDevolverItem(bib, listaAmigos, listaEmprestimos);
					break;
				case 5:
					System.out.println("CASE 5");
					break;
				case 6:
					System.out.println("CASE 6");
					break;
				case 7:
					System.out.println("CASE 7");
					break;
				case 8:
					menuAlterarEstado(bib);
					break;
				case 0:
					appOn = false;
					break;
				default:
					System.out.println("Escolha inválida, tente novamente.");
					break;
			}
		}
		scanner.close();
	}

	public static int menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n--- Menu ---");
		System.out.println("<1> Registrar um item");
		System.out.println("<2> Registrar um amigo");
		System.out.println("<3> Emprestimo de item");
		System.out.println("<4> Devolucao de item");
		System.out.println("<5> Ver emprestimos atuais");
		System.out.println("<6> Ver todos emprestimos");
		System.out.println("<7> Ver todos os itens");
		System.out.println("<8> Alterar estado de item");
		System.out.println("<0> Sair do aplicativo");
		System.out.print(">> ");
		return scanner.nextInt();
	}

	public static void menuRegistrarItem(Biblioteca bib) {
		Scanner scanner = new Scanner(System.in);
		int tipoItem = 0, totalPag = 0;
		String nomeItem = "", nomeAutor = "";
		boolean invalidInput = true;
		while (invalidInput) {
			System.out.println("\n--- Registrar Item ---");
			System.out.println("<1> Novo BluRay");
			System.out.println("<2> Novo CD");
			System.out.println("<3> Novo Livro");
			System.out.println("<0> Voltar do menu");
			System.out.print(">> ");
			tipoItem = scanner.nextInt();
			if (tipoItem >= 0 && tipoItem <= 3) {
				invalidInput = false;
			} else {
				System.out.println("\nValor incorreto! Tente novamente!");
			}
		}
		scanner.nextLine();
		switch (tipoItem) {
			case 1:
				System.out.println("\n--- Novo BluRay ---");
				System.out.print("Nome do BluRay: ");
				nomeItem = scanner.nextLine();
				bib.addNovoItem(new BluRay(bib.getAlItem().size(), nomeItem));
				System.out.println("Item adicionado!");
				System.out.println("Nome: " + nomeItem);
				break;
			case 2:
				System.out.println("\n--- Novo CD ---");
				System.out.print("Nome do CD: ");
				nomeItem = scanner.nextLine();
				System.out.print(nomeItem);
				bib.addNovoItem(new CD(bib.getAlItem().size(), nomeItem));
				System.out.println("Item adicionado!");
				System.out.println("Nome: " + nomeItem);
				break;
			case 3:
				System.out.println("\n--- Novo Livro ---");
				System.out.print("Nome do Livro: ");
				nomeItem = scanner.nextLine();
				System.out.print("Nome do Autor: ");
				nomeAutor = scanner.nextLine();
				System.out.print("Total de paginas: ");
				totalPag = scanner.nextInt();
				bib.addNovoItem(new Livro(bib.getAlItem().size(), nomeItem, nomeAutor, totalPag));
				System.out.println("Item adicionado!");
				System.out.println(nomeItem + ", de " + nomeAutor + ", com " + totalPag + " paginas.");
				break;
			default:
				System.out.println("Escolha inválida, tente novamente.");
				break;

		}
	}

	public static void menuRegistrarAmigo(ListaAmigos listaAmigos) {
		Scanner scanner = new Scanner(System.in);
		String nomeAmigo = "";
		int idAmigo = listaAmigos.getTamanhoLista();

		System.out.println("\n--- Registrar Amigo ---");
		System.out.print("Nome do amigo: ");
		nomeAmigo = scanner.nextLine();
		listaAmigos.addAmigo(new Amigo(idAmigo, nomeAmigo));
		System.out.println("Amigo adicionado!");
		System.out.println(idAmigo + " - " + nomeAmigo);
	}

	public static void menuEmprestarItem(Biblioteca bib, ListaAmigos listaAmigos, ListaEmprestimos listaEmprestimos) {
		Scanner scanner = new Scanner(System.in);
		int opcaoItem = 0, opcaoAmigo = 0;
		boolean invalidInput = true;
		while (invalidInput) {
			System.out.println("\n--- Emprestar item ---");
			for (var item : bib.getAlItem()) {
				if (item.getDisponibilidade().equals(Disponibilidade.DISPONIVEL))
					System.out.println("<" + item.getIdItem() + "> " + item.getClass().getSimpleName() + " - "
							+ item.getTituloItem());
			}
			System.out.println("<" + bib.getAlItem().size() + "> Voltar para menu");
			System.out.print(">> ");
			opcaoItem = scanner.nextInt();
			if (opcaoItem == bib.getAlItem().size()) {
				return;
			} else if (opcaoItem >= 0 && opcaoItem < bib.getAlItem().size()) {
				invalidInput = false;
			} else {
				System.out.println("\nValor incorreto! Tente novamente!");
			}
		}
		invalidInput = true;
		while (invalidInput) {
			System.out.println("\n--- Escolher Amigo ---");
			for (Amigo amigo : listaAmigos.getListaAmigos()) {
				System.out.println("<" + amigo.getIdAmigo() + "> " + amigo.getNomeAmigo());
			}
			System.out.println("<" + listaAmigos.getTamanhoLista() + "> Cancelar emprestimo");
			System.out.print(">> ");
			opcaoAmigo = scanner.nextInt();
			if (opcaoAmigo == listaAmigos.getTamanhoLista()) {
				return;
			} else if (opcaoAmigo >= 0 && opcaoAmigo < listaAmigos.getTamanhoLista()) {
				invalidInput = false;
			} else {
				System.out.println("\nValor incorreto! Tente novamente!");
			}
		}
		for (var item : bib.getAlItem()) {
			for (Amigo amigo : listaAmigos.getListaAmigos()) {
				if (item.getIdItem() == opcaoItem && amigo.getIdAmigo() == opcaoAmigo) {
					listaEmprestimos.addEmprestimo(new Emprestimo(amigo, item));
					System.out.println("Emprestado com sucesso!");
					break;
				}
			}
		}
	}

	public static void menuDevolverItem(Biblioteca bib, ListaAmigos listaAmigos, ListaEmprestimos listaEmprestimos) {
		Scanner scanner = new Scanner(System.in);
		int opcaoEmprestimo = 0;
		boolean invalidInput = true;
		while (invalidInput) {
			System.out.println("\n--- Devolver item ---");
			for (Emprestimo emprestimo : listaEmprestimos.getAlEmprestimos()) {
				System.out.println("<" + emprestimo.getIdItem() + "> " + emprestimo.getItem().getClass().getSimpleName()
						+ " - " + emprestimo.getItem().getTituloItem() + " || " + emprestimo.getAmigo().getNomeAmigo());
			}
			System.out.println("<" + listaEmprestimos.getAlEmprestimos().size() + "> Voltar para menu");
			System.out.print(">> ");
			opcaoEmprestimo = scanner.nextInt();
			if (opcaoEmprestimo == listaEmprestimos.getAlEmprestimos().size()) {
				return;
			} else if (opcaoEmprestimo >= 0 && opcaoEmprestimo < listaEmprestimos.getAlEmprestimos().size()) {
				invalidInput = false;
			} else {
				System.out.println("\nValor incorreto! Tente novamente!");
			}
		}
		for (Emprestimo emprestimo : listaEmprestimos.getAlEmprestimos()) {
			if (emprestimo.getIdItem() == opcaoEmprestimo) {
				System.out.println(emprestimo.getItem().getTituloItem());
				listaEmprestimos.removeEmprestimo(emprestimo);
				System.out.println("Devolvido com sucesso!");
				break;
			}
		}
	}

	public static void menuAlterarEstado(Biblioteca bib) {
		Scanner scanner = new Scanner(System.in);
		int opcaoDisp = 0, itemEscolhido = 0;
		boolean invalidInput = true;

		while (invalidInput) {
			System.out.println("\n--- Alterar Estado ---");
			for (var item : bib.getAlItem()) {
				System.out.println("<" + item.getIdItem() + "> " + item.getClass().getSimpleName() + " - "
						+ item.getTituloItem() + " - " + item.getDisponibilidade());
			}
			System.out.println("<" + bib.getAlItem().size() + "> Voltar ao menu");
			System.out.print(">> ");
			itemEscolhido = scanner.nextInt();
			if (itemEscolhido == bib.getAlItem().size()) {
				return;
			} else if (itemEscolhido >= 0 && itemEscolhido < bib.getAlItem().size()) {
				invalidInput = false;
			} else {
				System.out.println("\nOpcao invalida! Tente novamente.");
			}
		}
		invalidInput = true;
		while (invalidInput) {
			System.out.println("\n--- Escolha disponibilidade ---");
			System.out.println("<1> " + Disponibilidade.DISPONIVEL);
			System.out.println("<2> " + Disponibilidade.EMPRESTADO);
			System.out.println("<3> " + Disponibilidade.CONSULTALOCAL);
			System.out.println("<4> " + Disponibilidade.DANIFICADO);
			System.out.println("<5> " + Disponibilidade.EXTRAVIADO);
			System.out.println("<0> Cancelar mudanca");
			System.out.print(">> ");
			opcaoDisp = scanner.nextInt();
			if (opcaoDisp == 0) {
				return;
			} else if (opcaoDisp > 0 && opcaoDisp <= 5) {
				invalidInput = false;
			} else {
				System.out.println("\nOpcao invalida! Tente novamente.");
			}
		}

		for (var item : bib.getAlItem()) {
			if (item.getIdItem() == itemEscolhido) {
				switch (opcaoDisp) {
					case 1:
						item.setDisponibilidade(Disponibilidade.DISPONIVEL);
						System.out.println(
								"\n" + item.getTituloItem() + " foi alterado para " + Disponibilidade.DISPONIVEL + "!");
						break;
					case 2:
						item.setDisponibilidade(Disponibilidade.EMPRESTADO);
						System.out.println(
								"\n" + item.getTituloItem() + " foi alterado para " + Disponibilidade.EMPRESTADO + "!");
						break;
					case 3:
						item.setDisponibilidade(Disponibilidade.CONSULTALOCAL);
						System.out.println("\n" + item.getTituloItem() + " foi alterado para "
								+ Disponibilidade.CONSULTALOCAL + "!");
						break;
					case 4:
						item.setDisponibilidade(Disponibilidade.DANIFICADO);
						System.out.println(
								"\n" + item.getTituloItem() + " foi alterado para " + Disponibilidade.DANIFICADO + "!");
						break;
					case 5:
						item.setDisponibilidade(Disponibilidade.EXTRAVIADO);
						System.out.println(
								"\n" + item.getTituloItem() + " foi alterado para " + Disponibilidade.EXTRAVIADO + "!");
						break;
					default:
						break;
				}
			}
		}
	}
}
