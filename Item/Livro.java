package Item;

public class Livro extends Item{
	private String autorLivro;
	private int totPagLivro;

	// -> Construtor
	public Livro(int idItem, String tituloItem, Disponibilidade dispItem, String autorLivro, int totPagLivro) {
		super.setIdItem(idItem);
		super.setTitulo(tituloItem);
		super.setDisponibilidade(dispItem);
		this.autorLivro = autorLivro;
		this.totPagLivro = totPagLivro;
	}

	public Livro(int idItem, String tituloItem, String autorLivro, int totPagLivro) {
		super.setIdItem(idItem);
		super.setTitulo(tituloItem);
		super.setDisponibilidade(Disponibilidade.DISPONIVEL);
		this.autorLivro = autorLivro;
		this.totPagLivro = totPagLivro;
	}

	public Livro(int idItem, String tituloItem, String autorLivro) {
		super.setIdItem(idItem);
		super.setTitulo(tituloItem);
		super.setDisponibilidade(Disponibilidade.DISPONIVEL);
		this.autorLivro = autorLivro;
		this.totPagLivro = 0;
	}

	public Livro(int idItem, String tituloItem, int totPagLivro) {
		super.setIdItem(idItem);
		super.setTitulo(tituloItem);
		super.setDisponibilidade(Disponibilidade.DISPONIVEL);
		this.autorLivro = "Anonimo";
		this.totPagLivro = totPagLivro;
	}

	public Livro(int idItem, String tituloItem) {
		super.setIdItem(idItem);
		super.setTitulo(tituloItem);
		super.setDisponibilidade(Disponibilidade.DISPONIVEL);
		this.autorLivro = "Anonimo";
		this.totPagLivro = 0;
	}

	// -> Getters e Setters

	public String getAutorItem() {
		return this.autorLivro;
	}

	public int getTotalPaginas() {
		return this.totPagLivro;
	}

	public void setAutorItem(String nome) {
		this.autorLivro = nome;
	}

	public void setTotalPaginas(int paginas) {
		this.totPagLivro = paginas;
	}

	@Override
	public String toString() {
		return "Livro: " + super.getTituloItem() + ", de " + this.autorLivro + ", com " + this.totPagLivro
				+ " paginas.";
	}

}
