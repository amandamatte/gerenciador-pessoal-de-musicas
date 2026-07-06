public class Album {
    private String titulo;
    private int anoLancamento;
    private int numFaixas;
    private Musica[] musicas;
    private Artista artista;
    public Album (String titulo, int anoLancamento, int numFaixas, Artista artista) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.numFaixas = numFaixas;
        this.musicas = new Musica[10];
        this.artista = artista;
    }
    public String getTitulo() {
        return titulo;
    }
    public int getAnoLancamento() {
        return anoLancamento;
    }
    public int getNumFaixas() {
        return numFaixas;
    }
    public Musica[] getMusicas() {
        return musicas;
    }
    public Artista getArtista(){
        return artista;
    }
    public void adicionarMusica(Musica m){
        for(int i = 0; i < musicas.length; i++){
            if(musicas[i] == null){
                musicas[i] = m;
                return;
            }
        }
        // se ainda nao tivermos colocado
        //criamos um array com o dobro do tamanho, 
        //e colocamos a musica no primeiro espaco livre
        Musica[] novasMusicas = new Musica[musicas.length*2];
        for(int i = 0; i <= musicas.length; i++){
            if(i == musicas.length){
                novasMusicas[i] = m;
                this.musicas = novasMusicas;
            }
            novasMusicas[i] = musicas[i];
        }
    }
}