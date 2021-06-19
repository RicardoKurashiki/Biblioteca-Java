package Item;

public class CD extends Item {

    private String nomeCD;
    // TODO -> Ver mais categorias

    // -> Construtores
    CD(String nomeCD) {
        this.nomeCD = nomeCD;
    }

    // -> Getters e Setters
    String getNomeCD() {
        return this.nomeCD;
    }

    void setNomeCD(String novoNome) {
        this.nomeCD = novoNome;
    }

}
