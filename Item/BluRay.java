package Item;

public class BluRay extends Item {
    // -> Construtores

    public BluRay(int idItem, String tituloItem) {
        super.setIdItem(idItem);
        super.setTitulo(tituloItem);
        super.setDisponibilidade(Disponibilidade.DISPONIVEL);
    }

    @Override
    public String toString() {
        return "BluRay: " + super.getTituloItem();
    }

}
