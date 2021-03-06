package Principal;

/**
 * Programa principal, onde é construído a aplicação, seus menus, métodos e funcionalidades.
 * @author Carlos Eduardo Marques A. Torres e Ricardo G. Kurashiki.
 */

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

// -> Leitura e Escrita de dados
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

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
		//BluRay br1 = new BluRay(0, "Interstelar", "Ficcao Cientifica");
		//BluRay br2 = new BluRay(1, "Donnie Darko", "Suspense");
		//CD cd1 = new CD(2, "The Life of Pablo", "Kanye West");
		//CD cd2 = new CD(3, "Stuck", "Day Wave");
		//Livro livro1 = new Livro(4, "Universo numa casca de noz", "Stephen Hawking", 224);
		//Livro livro2 = new Livro(5, "Harry Potter e a Pedra Filosofal", "J. K. Rowling", 304);

		//bib.addNovoItem(br1);
		//bib.addNovoItem(br2);
		//bib.addNovoItem(cd1);
		//bib.addNovoItem(cd2);
		//bib.addNovoItem(livro1);
		//bib.addNovoItem(livro2);

		//Amigo amigo1 = new Amigo(0, "Carlos");
		//Amigo amigo2 = new Amigo(1, "Ricardo");
		//Amigo amigo3 = new Amigo(2, "Joao");
		//Amigo amigo4 = new Amigo(3, "Ferro");
		//Amigo amigo5 = new Amigo(4, "Milena");

		//listaAmigos.addAmigo(amigo1);
		//listaAmigos.addAmigo(amigo2);
		//listaAmigos.addAmigo(amigo3);
		//listaAmigos.addAmigo(amigo4);
		//listaAmigos.addAmigo(amigo5);
		// --- FIM DOS DUMMIES --- //
		while (appOn) {
			lerDados(bib, listaAmigos, listaEmprestimos);
			int escolha = menu();
			switch (escolha) {
				case 1:
					menuRegistrarItem(bib);
					gravarDados(bib, listaAmigos, listaEmprestimos);
					break;
				case 2:
					menuRegistrarAmigo(listaAmigos);
					gravarDados(bib, listaAmigos, listaEmprestimos);
					break;
				case 3:
					menuEmprestarItem(bib, listaAmigos, listaEmprestimos);
					gravarDados(bib, listaAmigos, listaEmprestimos);
					break;
				case 4:
					menuDevolverItem(bib, listaEmprestimos);
					gravarDados(bib, listaAmigos, listaEmprestimos);
					break;
				case 5:
					menuEmprestimosAtuais(listaEmprestimos);
					break;
				case 6:
					menuTodosEmprestimos(listaEmprestimos);
					break;
				case 7:
					menuHistoricoItem(bib, listaEmprestimos);
					break;
				case 8:
					menuTodosItens(bib);
					break;
				case 9:
					menuAlterarEstado(bib);
					gravarDados(bib, listaAmigos, listaEmprestimos);
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

	/**
	 * Método menu, apresenta o menu de opções para o usuário e retorna sua escolha para a main.
	 * @return scanner.nextInt() - Opção de escolha do usuário. 
	 */
	public static int menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n--- Menu ---");
		System.out.println("<1> Registrar um item");
		System.out.println("<2> Registrar um amigo");
		System.out.println("<3> Emprestimo de item");
		System.out.println("<4> Devolucao de item");
		System.out.println("<5> Ver emprestimos atuais");
		System.out.println("<6> Ver todos emprestimos");
		System.out.println("<7> Ver histórico do item");
		System.out.println("<8> Ver todos os itens");
		System.out.println("<9> Alterar estado de item");
		System.out.println("<0> Sair do aplicativo");
		System.out.print(">> ");
		return scanner.nextInt();
	}

	/**
	 * Método menuRegistrarItem, apresenta o processo de registro de novos Itens, contendo os menus
	 * de escolha e a lógica necessária para o armazenamento das informações do novo item.
	 * @param bib - Recebe como parâmetro um objeto da classe Biblioteca, para adição do novo item
	 * em sua ArrayList.
	 */
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
			case 0:
				break;
			case 1:
				System.out.println("\n--- Novo BluRay ---");
				System.out.print("Nome do BluRay: ");
				nomeItem = scanner.nextLine();
				System.out.print("Gênero do filme: ");
				String genItem = scanner.nextLine();
				bib.addNovoItem(new BluRay(bib.getAlItem().size(), nomeItem, genItem));
				System.out.println("\nItem adicionado!");
				System.out.println("Filme " + nomeItem + ", do gênero de " + genItem + ".");
				break;
			case 2:
				System.out.println("\n--- Novo CD ---");
				System.out.print("Nome do CD: ");
				nomeItem = scanner.nextLine();
				System.out.print("Nome da banda/artista: ");
				String nomeBanda = scanner.nextLine();
				System.out.print("Gênero Musical: ");
				String generoMusical = scanner.nextLine();
				bib.addNovoItem(new CD(bib.getAlItem().size(), nomeItem, nomeBanda, generoMusical));
				System.out.println("\nItem adicionado!");
				System.out.println("O disco " + nomeItem + " produzida pela banda/artista " + nomeBanda + ", do genero " + generoMusical);
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
				System.out.println("\nItem adicionado!");
				System.out.println(nomeItem + ", de " + nomeAutor + ", com " + totalPag + " paginas.");
				break;
			default:
				System.out.println("Escolha inválida, tente novamente.");
				break;

		}
	}

	/**
	 * Método menuRegistrarAmigo, apresenta o processo de registro de novos Amigos, contendo os menus 
	 * de escolha e a lógica necessária para armazenamento das informações do novo amigo.
	 * @param listaAmigos - Recebe como parâmetro um objeto da classe ListaAmigos, para adição do novo
	 * amigo em sua ArrayList.
	 */
	public static void menuRegistrarAmigo(ListaAmigos listaAmigos) {
		Scanner scanner = new Scanner(System.in);
		String nomeAmigo = "";
		int idAmigo = listaAmigos.getTamanhoLista();

		System.out.println("\n--- Registrar Amigo ---");
		System.out.print("Nome do amigo: ");
		nomeAmigo = scanner.nextLine();
		listaAmigos.addAmigo(new Amigo(idAmigo, nomeAmigo));
		System.out.println("\nAmigo adicionado!");
		System.out.println(idAmigo + " - " + nomeAmigo);
	}

	/**
	 * Método menuEmprestarItem, apresenta o processo de registro de novos Empréstimos, contendo os
	 * menus de escolha e a lógica necessária para armazenamento das informações do novo Empréstimo.
	 * @param bib - Recebe como parâmetro um objeto da classe Biblioteca, para verificação dos Itens
	 * disponíveis para empréstimo.
	 * @param listaAmigos - Recebe como parâmetro um objeto da classe ListaAmigos, para verificação
	 * de qual amigo deseja pegar o Item emprestado.
	 * @param listaEmprestimos - Recebe como parâmetro um objeto da classe ListaEmprestimos, para
	 * armazenamento do pedido de empréstimo.
	 */
	public static void menuEmprestarItem(Biblioteca bib, ListaAmigos listaAmigos, ListaEmprestimos listaEmprestimos) {
		Scanner scanner = new Scanner(System.in);
		int opcaoItem = 0, opcaoAmigo = 0, dia, mes, ano;
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

		invalidInput = true;
		while (invalidInput) {
			System.out.println("\n--- Deseja determinar hora de empréstimo ---");
			System.out.println("<1> Sim");
			System.out.println("<2> Não");
			System.out.println("<0> Cancelar emprestimo");
			System.out.print(">> ");
			int opcaoHora = scanner.nextInt();

			switch (opcaoHora) {
				case 0:
					System.out.println("Empréstimo cancelado!");
					invalidInput = false;
					break;
				case 1:
					System.out.println("\n--- Especifique o horário ---");

					// -> Escaneando e confirmando a data
					System.out.print("Dia (dia/mes/ano): ");
					scanner.nextLine();
					String diaInteiro = scanner.nextLine();
					String[] valoresDia = diaInteiro.split("/");
					if (valoresDia.length != 3) {
						System.out.println("\nDigite a data no formato correto!");
						break;
					} else {
						dia = Integer.parseInt(valoresDia[0]);
						mes = Integer.parseInt(valoresDia[1]);
						ano = Integer.parseInt(valoresDia[2]);
					}

					for (var item : bib.getAlItem()) {
						for (Amigo amigo : listaAmigos.getListaAmigos()) {
							if (item.getIdItem() == opcaoItem && amigo.getIdAmigo() == opcaoAmigo) {
								Emprestimo novoEmprestimo = new Emprestimo(amigo, item, LocalDate.of(ano, mes, dia));
								item.setDisponibilidade(Item.Disponibilidade.EMPRESTADO);
								listaEmprestimos.addEmprestimo(novoEmprestimo);
								System.out.println("Emprestado com sucesso!");
								break;
							}
						}
					}
					invalidInput = false;
					break;
				case 2:
					for (var item : bib.getAlItem()) {
						for (Amigo amigo : listaAmigos.getListaAmigos()) {
							if (item.getIdItem() == opcaoItem && amigo.getIdAmigo() == opcaoAmigo) {
								Emprestimo novoEmprestimo = new Emprestimo(amigo, item);
								item.setDisponibilidade(Item.Disponibilidade.EMPRESTADO);
								listaEmprestimos.addEmprestimo(novoEmprestimo);
								System.out.println("Emprestado com sucesso!");
								break;
							}
						}
					}
					invalidInput = false;
					return;
				default:
					System.out.println("\nValor incorreto! Tente novamente!");
					break;
			}
		}
	}

	/**
	 * Método menuDevolverItem, apresenta o processo de registro de novas devoluções, contendo os
	 * menus de escolha e a lógica necessária para armazenamento das informações da devolução.
	 * @param bib - Recebe como parâmetro um objeto da classe Biblioteca, para verificação dos Itens
	 * emprestados.
	 * @param listaEmprestimos - Recebe como parâmetro um objeto da classe ListaEmprestimos, para
	 * atualizar o Empréstimo com a data de devolução do item selecionado.
	 */
	public static void menuDevolverItem(Biblioteca bib, ListaEmprestimos listaEmprestimos) {
		Scanner scanner = new Scanner(System.in);
		int opcaoDevolucao = 0, dia = 0, mes = 0, ano = 0;
		boolean invalidInput = true;

		while (invalidInput) {
			System.out.println("\n--- Deseja determinar hora da devolução ---");
			System.out.println("<1> Sim");
			System.out.println("<2> Não");
			System.out.println("<0> Cancelar devolução");
			System.out.print(">> ");
			int opcaoHora = scanner.nextInt();

			switch (opcaoHora) {
				case 0:
					System.out.println("Devolução cancelada!");
					invalidInput = false;
					break;
				case 1:
					System.out.println("\n--- Especifique o horário ---");

					invalidInput = true;
					while (invalidInput) {
						System.out.print("Dia (dia/mes/ano): ");
						scanner.nextLine();
						String diaInteiro = scanner.nextLine();
						String[] valoresDia = diaInteiro.split("/");
						if (valoresDia.length != 3) {
							System.out.println("\nDigite a data no formato correto!");
							break;
						} else {
							dia = Integer.parseInt(valoresDia[0]);
							mes = Integer.parseInt(valoresDia[1]);
							ano = Integer.parseInt(valoresDia[2]);
						}

						System.out.println("\n--- Devolver item ---");
						for (Emprestimo emprestimo : listaEmprestimos.getAlEmprestimos()) {
							if (emprestimo.getItem().getDisponibilidade().equals(Disponibilidade.EMPRESTADO) && emprestimo.getDataDevolucao()==null){
								System.out.println("<" + emprestimo.getItem().getIdItem() + "> "
										+ emprestimo.getItem().getClass().getSimpleName() + " - "
										+ emprestimo.getItem().getTituloItem() + " || "
										+ emprestimo.getAmigo().getNomeAmigo());
							}
						}
						System.out.println("<" + bib.getAlItem().size() + "> Voltar para menu");
						System.out.print(">> ");
						opcaoDevolucao = scanner.nextInt();
						if (opcaoDevolucao == bib.getAlItem().size()) {
							return;
						} else if (opcaoDevolucao >= 0
								&& opcaoDevolucao < bib.getAlItem().size()) {
							invalidInput = false;
						} else {
							System.out.println("\nValor incorreto! Tente novamente!");
						}
					}
					for (Emprestimo emprestimo : listaEmprestimos.getAlEmprestimos()) {
						if (emprestimo.getItem().getIdItem() == opcaoDevolucao && emprestimo.getDataDevolucao() == null) {

							emprestimo.setDataDevolucao(LocalDate.of(ano, mes, dia));
							emprestimo.getItem().setDisponibilidade(Disponibilidade.DISPONIVEL);

							System.out.println("\n" + emprestimo.getItem().getTituloItem());
							System.out.println("Devolvido com sucesso!");

							break;
						}
					}
					break;
				case 2:
					invalidInput = true;

					while (invalidInput) {
						System.out.println("\n--- Devolver item ---");
						for (Emprestimo emprestimo : listaEmprestimos.getAlEmprestimos()) {
							if (emprestimo.getItem().getDisponibilidade().equals(Disponibilidade.EMPRESTADO) && emprestimo.getDataDevolucao() == null){
								System.out.println("<" + emprestimo.getItem().getIdItem() + "> "
										+ emprestimo.getItem().getClass().getSimpleName() + " - "
										+ emprestimo.getItem().getTituloItem() + " || "
										+ emprestimo.getAmigo().getNomeAmigo());
							}
						}
						System.out.println("<" + bib.getAlItem().size() + "> Voltar para menu");
						System.out.print(">> ");
						opcaoDevolucao = scanner.nextInt();
						if (opcaoDevolucao == bib.getAlItem().size()) {
							return;
						} else if (opcaoDevolucao >= 0
								&& opcaoDevolucao < bib.getAlItem().size()) {
							invalidInput = false;
						} else {
							System.out.println("\nValor incorreto! Tente novamente!");
						}
					}

					for (Emprestimo emprestimo : listaEmprestimos.getAlEmprestimos()) {
						if (emprestimo.getItem().getIdItem() == opcaoDevolucao && emprestimo.getDataDevolucao() == null) {
							emprestimo.setDataDevolucao(LocalDate.now());
							emprestimo.getItem().setDisponibilidade(Disponibilidade.DISPONIVEL);

							System.out.println("\n" + emprestimo.getItem().getTituloItem());
							System.out.println("Devolvido com sucesso!");

							break;
						}
					}
					break;
				default:
					System.out.println("\nValor incorreto! Tente novamente!");
					break;
			}
		}
		return;
	}

	/**
	 * Método menuAlterarEstado, apresenta o processo de alteração de estado dos Itens, contendo
	 * os menus de escolha e a lógica necessária para alterar as informações dos Itens.
	 * @param bib - Recebe como parâmetro um objeto da classe Biblioteca, para acessar e atualizar
	 * o estado dos Itens presentes em sua ArrayList.
	 */
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
						if(item.getDisponibilidade().equals(Disponibilidade.EMPRESTADO)){
							System.out.println("\nNão foi possível alterar o estado do item para Consulta Local, pois o item está emprestado.");
						} else {
							item.setDisponibilidade(Disponibilidade.CONSULTALOCAL);
							System.out.println("\n" + item.getTituloItem() + " foi alterado para "
									+ Disponibilidade.CONSULTALOCAL + "!");
						}
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

	/**
	 * Método menuEmprestimosAtuais, realiza a demonstração de todos os empréstimos que ainda não
	 * foram devolvidos.
	 * @param listaEmprestimos - Recebe como parâmetro um objeto da classe ListaEmprestimos, para
	 * a verificação de quais empréstimos em sua ArrayList ainda não foram devolvidos.
	 */
	public static void menuEmprestimosAtuais(ListaEmprestimos listaEmprestimos) {
		System.out.println("\n--- Empréstimos atuais ---");
		// - Para todos os empréstimos
		if (!listaEmprestimos.getAlEmprestimos().isEmpty()) {
			for (Emprestimo emprestimo : listaEmprestimos.getAlEmprestimos()) {
				if (emprestimo.getItem().getDisponibilidade().equals(Disponibilidade.EMPRESTADO) && emprestimo.getDataDevolucao() == null) {
					System.out.println("\n- Título do item: <" + emprestimo.getItem().getIdItem() + "> "
							+ emprestimo.getItem().getTituloItem());
					System.out.println("- Para quem foi emprestado: <" + emprestimo.getAmigo().getIdAmigo() + "> "
							+ emprestimo.getAmigo().getNomeAmigo());
					System.out.println("- Quando foi emprestado: " + emprestimo.getDataEmprestimo());
				}
			}
		} else {
			System.out.println("\nSem empréstimos");
		}
	}

	/**
	 * Método menuTodosEmprestimos, um método adicional que realiza a demonstração de todo o
	 * histórico de todas as movimentações realizadas na Biblioteca.
	 * @param listaEmprestimos - Recebe como parâmetro um objeto da classe ListaEmprestimos, para
	 * a verificação dos empréstimos atuais e já devolvidos.
	 */
	public static void menuTodosEmprestimos(ListaEmprestimos listaEmprestimos) {
		if (!listaEmprestimos.getAlEmprestimos().isEmpty()) {
			System.out.println("\n--- Emprestados e Devolvidos ---");
			for (Emprestimo emprestimo : listaEmprestimos.getAlEmprestimos()) {
				if (emprestimo.getDataDevolucao() != null) {
					System.out.println("\n- Título do item: <" + emprestimo.getItem().getIdItem() + "> "
							+ emprestimo.getItem().getTituloItem());
					System.out.println("- Para quem foi emprestado: <" + emprestimo.getAmigo().getIdAmigo() + "> "
							+ emprestimo.getAmigo().getNomeAmigo());
					System.out.println("- Quando foi emprestado: " + emprestimo.getDataEmprestimo());
					System.out.println("- Quando foi devolvido: " + emprestimo.getDataDevolucao());
				}
			}
			System.out.println("\n--- Emprestados ---");
			for (Emprestimo emprestimo : listaEmprestimos.getAlEmprestimos()) {
				if (emprestimo.getDataDevolucao() == null) {
					System.out.println("\n- Título do item: <" + emprestimo.getItem().getIdItem() + "> "
							+ emprestimo.getItem().getTituloItem());
					System.out.println("- Para quem foi emprestado: <" + emprestimo.getAmigo().getIdAmigo() + "> "
							+ emprestimo.getAmigo().getNomeAmigo());
					System.out.println("- Quando foi emprestado: " + emprestimo.getDataEmprestimo());
				}
			}
		} else {
			System.out.println("\nSem empréstimos");
		}
	}

	/**
	 * Método menuHistoricoItem, realiza a demonstração de todas as movimentações em determinado
	 * item.
	 * @param bib - Recebe como parâmetro um objeto da classe Biblioteca, para verificar qual 
	 * item deseja realizar a consulta.
	 * @param listaEmprestimos - Recebe como parâmetro um objeto da classe ListaEmprestimos, para
	 * verificar as movimentações do item determinado pelo usuário.
	 */
	public static void menuHistoricoItem(Biblioteca bib, ListaEmprestimos listaEmprestimos) {
		Scanner scanner = new Scanner(System.in);
		int escolhaItem = 0;
		int idEscolha = 0;
		boolean invalidInput = true;
		boolean haHistorico = false;

		while (invalidInput) {
			System.out.println("\n--- Historico do Item ---");
			for (var item : bib.getAlItem()) {
				System.out.println("<" + item.getIdItem() + "> " + item.getClass().getSimpleName() + " - "
						+ item.getTituloItem());
			}
			System.out.println("<" + bib.getAlItem().size() + "> Voltar para menu");
			System.out.print(">> ");
			escolhaItem = scanner.nextInt();
			if (escolhaItem == bib.getAlItem().size()) {
				return;
			} else if (escolhaItem >= 0 && escolhaItem < bib.getAlItem().size()) {
				idEscolha = bib.getAlItem().get(escolhaItem).getIdItem();
				invalidInput = false;
			} else {
				System.out.println("\nValor incorreto! Tente novamente!");
			}
		}

		System.out.println("\n--- Histórico de Empréstimos ---");
		for (Emprestimo emprestimo : listaEmprestimos.getAlEmprestimos()) {
			if (idEscolha == emprestimo.getItem().getIdItem()) {
				if (emprestimo.getDataDevolucao() == null) {
					haHistorico = true;
					System.out.println("\n--- Empréstimo atual ---");
					System.out.println("\n- Título do item: <" + emprestimo.getItem().getIdItem() + "> "
							+ emprestimo.getItem().getTituloItem());
					System.out.println("- Para quem foi emprestado: <" + emprestimo.getAmigo().getIdAmigo() + "> "
							+ emprestimo.getAmigo().getNomeAmigo());
					System.out.println("- Quando foi emprestado: " + emprestimo.getDataEmprestimo());
				} else {
					haHistorico = true;
					System.out.println("\n- Título do item: <" + emprestimo.getItem().getIdItem() + "> "
							+ emprestimo.getItem().getTituloItem());
					System.out.println("- Para quem foi emprestado: <" + emprestimo.getAmigo().getIdAmigo() + "> "
							+ emprestimo.getAmigo().getNomeAmigo());
					System.out.println("- Quando foi emprestado: " + emprestimo.getDataEmprestimo());
					System.out.println("- Quando foi devolvido: " + emprestimo.getDataDevolucao());
				}
			}
		}

		if (haHistorico == false) {
			System.out.println("\nNão houveram movimentações com este item!");
		}

	}

	/**
	 * Método menuTodosItens, realiza a demonstração de todos os itens disponíveis no acervo 
	 * da Biblioteca em ordem alfabética.
	 * @param bib - Recebe como parâmetro um objeto da classe Biblioteca, para a verificação dos 
	 * itens presentes em sua ArrayList.
	 */
	public static void menuTodosItens(Biblioteca bib) {
		// Salvando a antiga ordenação para depois do sort os índices não ficarem bagunçados
		Biblioteca bibAux = new Biblioteca("bibAux");
		for (var item : bib.getAlItem()) {
			bibAux.addNovoItem(item);
		}

		Collections.sort(bibAux.getAlItem());
		System.out.println("\n--- Itens da Biblioteca ---");
		if (!bibAux.getAlItem().isEmpty()) {
			for (var item : bibAux.getAlItem()) {
				System.out.println("\nTitulo: " + item.getTituloItem());
				System.out.println("Tipo de item: " + item.getClass().getSimpleName());
				System.out.println("Disponibilidade: " + item.getDisponibilidade());
			}
		} else {
			System.out.println("\nSem itens");
		}
	}

	/**
	 * Método gravarDados, realiza o registro em arquivo texto das informações das classes do 
	 * programa.
	 * @param bib - Recebe como parâmetro um objeto da classe Biblioteca, para armazenamento de
	 * seus objetos.
	 * @param listaAmigos - Recebe como parâmetro um objeto da classe ListaAmigos, para armazenamento
	 * de seus objetos.
	 * @param listaEmprestimos - Recebe como parâmetro um objeto da classe ListaEmprestimos, para 
	 * armazenamento de seus objetos.
	 */
	public static void gravarDados(Biblioteca bib, ListaAmigos listaAmigos, ListaEmprestimos listaEmprestimos) {
		ObjectOutputStream saida = null;

		try {
			// TODO: Mudar o caminho para o diretório correto no seu computador.
			saida = new ObjectOutputStream(new FileOutputStream(
					"C:\\Users\\carlo\\Documents\\GitHub\\Biblioteca-Java\\Dados\\Dados_Binarios.txt"));
			saida.writeObject(bib);
			saida.writeObject(listaAmigos);
			saida.writeObject(listaEmprestimos);
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				if (saida != null)
					saida.close();
			} catch (IOException e2) {
				System.out.println(e2.getMessage());
			}
		}

		System.out.println("\nDados registrados com sucesso!");
	}

	/**
	 * Método lerDados, realiza a leitura do arquivo texto contendo as informações das classes do 
	 * programa.
	 * @param bib - Recebe como parâmetro um objeto da classe Biblioteca, para leitura de
	 * seus objetos.
	 * @param listaAmigos - Recebe como parâmetro um objeto da classe ListaAmigos, para leitura
	 * de seus objetos.
	 * @param listaEmprestimos - Recebe como parâmetro um objeto da classe ListaEmprestimos, para 
	 * leitura de seus objetos.
	 */
	public static void lerDados(Biblioteca bib, ListaAmigos listaAmigos, ListaEmprestimos listaEmprestimos) {
		ObjectInputStream entrada = null;
		Biblioteca bibtemp = null;
		ListaAmigos listaAmiTemp = null;
		ListaEmprestimos listaEmpTemp = null;

		try {
			// TODO: Mudar o caminho para o diretório correto no seu computador.
			entrada = new ObjectInputStream(new FileInputStream(
					"C:\\Users\\carlo\\Documents\\GitHub\\Biblioteca-Java\\Dados\\Dados_Binarios.txt"));
			bibtemp = (Biblioteca) entrada.readObject();
			listaAmiTemp = (ListaAmigos) entrada.readObject();
			listaEmpTemp = (ListaEmprestimos) entrada.readObject();
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
			System.out.println("\nSem dados para leitura!");
		} catch (ClassNotFoundException e2) {
			System.out.println(e2.getMessage());
		} finally {
			try {
				if (entrada != null) {
					entrada.close();

					bib.setAlItem(bibtemp.getAlItem());
					bib.setNomeBib(bibtemp.getNomeBib());

					listaAmigos.setListaAmigos(listaAmiTemp.getListaAmigos());

					listaEmprestimos.setAlEmprestimos(listaEmpTemp.getAlEmprestimos());
				}
			} catch (IOException e3) {
				System.out.println(e3.getMessage());
			}
		}
	}
}