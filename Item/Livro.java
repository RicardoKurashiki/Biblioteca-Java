package Item;

public class Livro extends Item {

	private String autorLivro, nomeLivro;
	private int totPagLivro;

	// -> Construtores
	public Livro(String nomeLivro, String autorLivro, int totPagLivro) {
		this.nomeLivro = nomeLivro;
		this.autorLivro = autorLivro;
		this.totPagLivro = totPagLivro;
	}

	public Livro(String nomeLivro, int totPagLivro) {
		this.nomeLivro = nomeLivro;
		this.autorLivro = "Anonimo";
		this.totPagLivro = totPagLivro;
	}

	public Livro(String nomeLivro, String autorLivro) {
		this.nomeLivro = nomeLivro;
		this.autorLivro = autorLivro;
		this.totPagLivro = 0;
	}

	public Livro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
		this.autorLivro = "Anonimo";
		this.totPagLivro = 0;
	}

	// -> Getters e Setters
	public String getNome() {
		return this.nomeLivro;
	}

	public String getAutor() {
		return this.autorLivro;
	}

	public int getTotPag() {
		return this.totPagLivro;
	}

	public void setNomeLivro(String novoNome) {
		this.nomeLivro = novoNome;
	}

	public void setAutor(String novoNome) {
		this.autorLivro = novoNome;
	}

	public void setTotPag(int novoTotPag) {
		this.totPagLivro = novoTotPag;
	}

	@Override
	public String toString() {
		return "Livro: " + this.nomeLivro + ", de " + this.autorLivro + ", com " + this.totPagLivro + " paginas.";
	}

}
