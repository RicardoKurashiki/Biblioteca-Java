package Item;

/** 
 * Classe de objetos de tipo CD, onde serão contidos os atributos e os métodos dos mesmos.
 * @author Carlos Eduardo Marques A. Torres e Ricardo G. Kurashiki
 */

public class CD extends Item {
    private String banda;
    private String genero;

    /**
     * Método construtor para a classe CD.
     * @param idItem - Recebe um inteiro para a identificação do CD, atributo herdado da classe Item.
     * @param tituloItem - Recebe uma string para o nome do CD, atributo herdado da classe Item.
     */
    public CD(int idItem, String tituloItem) {
        super.setIdItem(idItem);
        super.setTitulo(tituloItem);
        super.setDisponibilidade(Disponibilidade.DISPONIVEL);
    }

    /**
     * Método construtor para a classe CD.
     * @param idItem - Recebe um inteiro para a identificação do CD, atributo herdado da classe Item.
     * @param tituloItem - Recebe uma string para o nome do CD, atributo herdado da classe Item.
     * @param banda - Recebe uma string para o nome da Banda.
     */
    public CD(int idItem, String tituloItem, String banda) {
        super.setIdItem(idItem);
        super.setTitulo(tituloItem);
        super.setDisponibilidade(Disponibilidade.DISPONIVEL);
        this.banda = banda;
    }

    /**
     * Método construtor para a classe CD.
     * @param idItem - Recebe um inteiro para a identificação do CD, atributo herdado da classe Item.
     * @param tituloItem - Recebe uma string para o nome do CD, atributo herdado da classe Item.
     * @param banda - Recebe uma string para o nome da Banda.
     * @param genero - Recebe uma string para o gênero musical do disco.
     */
    public CD(int idItem, String tituloItem, String banda, String genero) {
        super.setIdItem(idItem);
        super.setTitulo(tituloItem);
        super.setDisponibilidade(Disponibilidade.DISPONIVEL);
        this.banda = banda;
        this.genero = genero;
    }

    /**
     * Método getter para o atributo banda.
     * @return banda - Retorna uma string que identifica a banda ou artista que compôs o disco.
     */
    public String getBanda() {return banda;}

    /**
     * Método getter para o atributo genero.
     * @return genero - Retorna uma string que identifica o gênero musical do disco.
     */
    public String getGenero() {return genero;}

    /**
     * Método setter para o atributo banda.
     * @param novaBanda - Recebe como parâmetro uma string que representa o novo nome do atributo banda.
     */
    public void setBanda(String novaBanda) {this.banda = novaBanda;}

    /**
     * Método setter para o atributo gênero.
     * @param novoGen - Recebe como parâmetro uma string que representa o novo gênero do disco.
     */
    public void setGenero(String novoGen) {this.genero = novoGen;}

    @Override
    /**
	 * Função que permite a visualização geral da classe CD.
	 */
    public String toString() {
        return "CD: " + super.getTituloItem();
    }

}
