package Item;

/** 
 * Classe de objetos de tipo BluRay, onde serão contidos os atributos e os métodos dos mesmos.
 * @author Carlos Eduardo Marques A. Torres e Ricardo G. Kurashiki
 */

public class BluRay extends Item {
    private String genero;

    /**
     * Método construtor para a classe BluRay
     * @param idItem - Recebe um inteiro para a identificação do BluRay, atributo herdado da classe Item.
     * @param tituloItem - Recebe uma string para o nome do BluRay, atributo herdado da classe Item.
     */
    public BluRay(int idItem, String tituloItem) {
        super.setIdItem(idItem);
        super.setTitulo(tituloItem);
        super.setDisponibilidade(Disponibilidade.DISPONIVEL);
    }

    /**
     * Método construtor para a classe BluRay
     * @param idItem - Recebe um inteiro para a identificação do BluRay, atributo herdado da classe Item.
     * @param tituloItem - Recebe uma string para o nome do BluRay, atributo herdado da classe Item.
     * @param genero - Recebe uma string para designar o gênero do filme.
     */
    public BluRay(int idItem, String tituloItem, String genero) {
        super.setIdItem(idItem);
        super.setTitulo(tituloItem);
        super.setDisponibilidade(Disponibilidade.DISPONIVEL);
        this.genero = genero;
    }

    /**
     * Método getter para o atributo genero.
     * @return genero - Retorna uma string que representa o gênero do filme BluRay.
     */
    public String getGenero() {return genero;}

    /**
     * Método setter para o atributo genero.
     * @param novoGen - Recebe como parâmetro uma string que representa o novo nome do gênero do filme BluRay.
     */
    public void setGenero(String novoGen) {this.genero = novoGen;}

    @Override
    /**
	 * Função que permite a visualização geral da classe BluRay.
	 */
    public String toString() {
        if (genero == null) {
            return "BluRay: " + super.getTituloItem();
        } else {
            return "BluRay: " + super.getTituloItem() + " do gênero de " + genero;
        }
    }

}
