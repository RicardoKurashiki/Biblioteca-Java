package Principal;

import java.util.Scanner;

import Item.Biblioteca;
import Item.BluRay;
import Item.CD;
import Item.Livro;

public class Principal {
	public static void main(String[] args) {
		Biblioteca bib = new Biblioteca("Biblioteca Pessoal");

		boolean appOn = true;
		Scanner scanner = new Scanner(System.in);

		while (appOn) {
			int escolha = menu();
			switch (escolha) {
				case 1:
					menuRegistrarItem(bib);
					break;
				case 2:
					System.out.println("CASE 2");
					break;
				case 3:
					System.out.println("CASE 3");
					break;
				case 4:
					System.out.println("CASE 4");
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
					System.out.println("CASE 8");
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
				bib.addNovoItem(new BluRay(nomeItem));
				System.out.println("Item adicionado!");
				System.out.println("Nome: " + nomeItem);
				break;
			case 2:
				System.out.println("\n--- Novo CD ---");
				System.out.print("Nome do CD: ");
				nomeItem = scanner.nextLine();
				System.out.print(nomeItem);
				bib.addNovoItem(new CD(nomeItem));
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
				bib.addNovoItem(new Livro(nomeItem, nomeAutor, totalPag));
				System.out.println("Item adicionado!");
				System.out.println(nomeItem + ", de " + nomeAutor + ", com " + totalPag + " paginas.");
				break;
			default:
				System.out.println("Escolha inválida, tente novamente.");
				break;

		}
	}
}
