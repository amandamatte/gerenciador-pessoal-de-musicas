public class Playlist {
    private String nome;
    private String descricao;
    private boolean favorita;
    private Musica[] musicas;
    public Playlist (String nome, String descricao, boolean favorita) {
        this.nome = nome;
        this.descricao = descricao;
        this.favorita = favorita;
        this.musicas = new Musica[10];
    }
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public boolean getFavorita() {
        return favorita;
    }
    public Musica[] getMusicas() {
        return musicas;
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