package Item;

public class CD extends Item {
    // TODO => Ver mais caracteristicas

    // -> Construtores
    public CD(int idItem, String tituloItem) {
        super.setIdItem(idItem);
        super.setTitulo(tituloItem);
        super.setDisponibilidade(Disponibilidade.DISPONIVEL);
    }

    @Override
    public String toString() {
        return "CD: " + super.getTituloItem();
    }

}
