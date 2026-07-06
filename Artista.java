public class Artista {
    private String nome;
    private String nacionalidade;
    private int anoEstreia;
    private String bio;
    private boolean ativo;
    public Artista (String nome, String nacionalidade, int anoEstreia, String bio, boolean ativo) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.anoEstreia = anoEstreia;
        this.bio = bio;
        this.ativo = ativo;
    }
    public String getNome() {
        return nome;
    }
    public String getNacionalidade() {
        return nacionalidade;
    }
    public int getAnoEstreia() {
        return anoEstreia;
    }
    public String getBio() {
        return bio;
    }
    public boolean getAtivo() {
        return ativo;
    }
}