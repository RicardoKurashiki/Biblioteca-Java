package Item;

public class Livro extends Item {

	private String autorLivro;
	private int totPagLivro;

	// -> Construtores
	Livro(String autorLivro, int totPagLivro) {
		this.autorLivro = autorLivro;
		this.totPagLivro = totPagLivro;
	}

	Livro(String autorLivro) {
		this.autorLivro = autorLivro;
		this.totPagLivro = 0;
	}

	Livro(int totPagLivro) {
		this.autorLivro = "Autor Anonimo";
		this.totPagLivro = totPagLivro;
	}

	// -> Getters e Setters
	String getAutor() {
		return this.autorLivro;
	}

	int getTotPag() {
		return this.totPagLivro;
	}

	void setAutor(String novoNome) {
		this.autorLivro = novoNome;
	}

	void setTotPag(int novoTotPag) {
		this.totPagLivro = novoTotPag;
	}

}
