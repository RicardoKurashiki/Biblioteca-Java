package Item;

public class BluRay extends Item {

    private String nomeFilme;
    // TODO -> Ver mais caracteristicas

    // -> Construtores
    public BluRay(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    // -> Getters e Setters
    public String getNomeFilme() {
        return this.nomeFilme;
    }

    public void setNomeFilme(String novoNome) {
        this.nomeFilme = novoNome;
    }

    @Override
    public String toString() {
        return "BluRay: " + this.nomeFilme;
    }

}
