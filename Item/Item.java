package Item;

public abstract class Item implements Comparable<Item>{

	private int idItem;
	private String tituloItem;
	private Disponibilidade dispItem;

	// -> Getters e Setters

	public int getIdItem() {
		return this.idItem;
	}

	public String getTituloItem() {
		return this.tituloItem;
	}

	public Disponibilidade getDisponibilidade() {
		return this.dispItem;
	}

	protected void setIdItem(int id) {
		this.idItem = id;
	}

	protected void setTitulo(String titulo) {
		this.tituloItem = titulo;
	}

	public void setDisponibilidade(Disponibilidade disponibilidade) {
		this.dispItem = disponibilidade;
	}

	@Override
	public int compareTo(Item outroItem){
		return tituloItem.compareTo(outroItem.getTituloItem());
	}

}
