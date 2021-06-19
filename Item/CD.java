package Item;

public class CD extends Item {

    private String nomeCD;
    // TODO -> Ver mais categorias

    // -> Construtores
    public CD(String nomeCD) {
        this.nomeCD = nomeCD;
    }

    // -> Getters e Setters
    public String getNomeCD() {
        return this.nomeCD;
    }

    public void setNomeCD(String novoNome) {
        this.nomeCD = novoNome;
    }

    @Override
    public String toString() {
        return "CD: " + this.nomeCD;
    }

}
