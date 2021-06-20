package Item;

public class BluRay extends Item {
    // TODO => Ver mais caracteristicas
    private String genero;

    // -> Construtores
    public BluRay(int idItem, String tituloItem) {
        super.setIdItem(idItem);
        super.setTitulo(tituloItem);
        super.setDisponibilidade(Disponibilidade.DISPONIVEL);
    }

    public BluRay(int idItem, String tituloItem, String genero) {
        super.setIdItem(idItem);
        super.setTitulo(tituloItem);
        super.setDisponibilidade(Disponibilidade.DISPONIVEL);
        this.genero = genero;
    }

    // -> Getters
    public String getGenero(){
        return genero;
    }

    // -> Setters
    public void setGenero(String novoGen){
        this.genero = novoGen;
    }


    @Override
    public String toString() {
        if (genero == null){
            return "BluRay: " + super.getTituloItem();
        } else {
            return "BluRay: " + super.getTituloItem() + " do gênero de " + genero;
        }
    }

}
