package Item;

public class CD extends Item {
    // TODO => Ver mais caracteristicas
    private String banda;
    private String genero;
    private int numMusicas;

    // -> Construtores
    public CD(int idItem, String tituloItem) {
        super.setIdItem(idItem);
        super.setTitulo(tituloItem);
        super.setDisponibilidade(Disponibilidade.DISPONIVEL);
    }

    public CD(int idItem, String tituloItem, String banda){
        super.setIdItem(idItem);
        super.setTitulo(tituloItem);
        super.setDisponibilidade(Disponibilidade.DISPONIVEL);
        this.banda = banda;
    }

    public CD(int idItem, String tituloItem, String banda, String genero){
        super.setIdItem(idItem);
        super.setTitulo(tituloItem);
        super.setDisponibilidade(Disponibilidade.DISPONIVEL);
        this.banda = banda;
        this.genero = genero;
    }

    public CD(int idItem, String tituloItem, String banda, int numMusicas){
        super.setIdItem(idItem);
        super.setTitulo(tituloItem);
        super.setDisponibilidade(Disponibilidade.DISPONIVEL);
        this.banda = banda;
        this.numMusicas = numMusicas;
    }

    public CD(int idItem, String tituloItem, String banda, String genero, int numMusicas){
        super.setIdItem(idItem);
        super.setTitulo(tituloItem);
        super.setDisponibilidade(Disponibilidade.DISPONIVEL);
        this.banda = banda;
        this.genero = genero;
        this.numMusicas = numMusicas;
    }

    // -> Getters
    public String getBanda(){
        return banda;
    }

    public String getGenero(){
        return genero;
    }

    // -> Setters
    public void setBanda(String novaBanda){
        this.banda = novaBanda;
    }

    public void setGenero(String novoGen){
        this.genero = novoGen;
    }

    @Override
    public String toString() {
        return "CD: " + super.getTituloItem();
    }

}
