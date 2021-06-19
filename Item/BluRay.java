package Item;

public class BluRay extends Item {

    private String nomeFilme;
    // TODO -> Ver mais caracteristicas

    // -> Construtores
    BluRay(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    // -> Getters e Setters
    String getNomeFilme() {
        return this.nomeFilme;
    }

    void setNomeFilme(String novoNome) {
        this.nomeFilme = novoNome;
    }

}
