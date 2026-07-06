public class Musica { 
    private String titulo;
    private double duracao;
    private String genero;
    private int faixa;
    private Album album;
    public Musica (String titulo, double duracao, String genero, int faixa, Album album) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
        this.faixa = faixa;
        this.album = album;
    }
    public String getTitulo() {
        return titulo;
    }
    public double getDuracao() {
        return duracao;
    }
    public String getGenero() {
        return genero;
    }
    public int getFaixa() {
        return faixa;
    }
    public Album getAlbum() {
        return album;
    }
    public boolean equals(Musica m) {
        if(this.titulo.equals(m.getTitulo()) && this.duracao == (m.getDuracao()) && this.genero.equals(m.getGenero()) && this.faixa == (m.getFaixa())) {
            return true;
        }
        else {
            return false;
        }
    }
}
