import java.util.Scanner;

public class Main {
        public static Album[] albuns = new Album[100];
        public static Artista[] artistas = new Artista[100];
        public static Musica[] musicas = new Musica[500];
        public static Playlist[] playlists = new Playlist[100];
        public static int numAlbuns = 0;
        public static int numArtistas = 0;
        public static int numMusicas = 0;
        public static int numPlaylists = 0;
        public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        
        System.out.println("Bem vindo(a) ao seu gerenciador de músicas favorito!");
        
        while (true) { 
            System.out.println("Pressione 1 para adicionar um artista");
            System.out.println("Pressione 2 para adicionar um álbum");
            System.out.println("Pressione 3 para adicionar uma música");
            System.out.println("Pressione 4 para adicionar uma playlist");
            System.out.println("Pressione 5 para adicionar uma música em uma playlist");
            System.out.println("Pressione 6 para listar os artistas");
            System.out.println("Pressione 7 para listar os álbuns");
            System.out.println("Pressione 8 para listar as músicas");
            System.out.println("Pressione 9 para listar as playlists");
            System.out.println("Presssione 10 para buscar musicas por nome");
            System.out.println("Pressione 11 para editar o álbum de uma música");
            System.out.println("Pressione -1 para sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // não deixar dar erro por causa do nextInt anterior
            switch(opcao) {
                case 1: {
                    adicionarArtista();
                    numArtistas++;
                    break;
                 }
                case 2: {
                    adicionarAlbum(); 
                    break;
                }
                case 3: {
                    adicionarMusica();
                    break;
                }
                case 4: {
                    adicionarPlaylist();
                    break;
                }
                case 5: {
                    adicionarEmPlaylist(); 
                    break;
                }
                case 6: {
                    System.out.println("Listando artistas...");
                    listarArtistasPretty();
                    break;
                }
                case 7: {
                    System.out.println("Listando álbuns...");
                    listarAlbunsPretty();
                    break;
                }
                case 8: {
                    System.out.println("Listando músicas...");
                    listarMusicasPretty();
                    break;
                }
                case 9: {
                    System.out.println("Listando playlists...");
                    listarPlaylistsPretty();
                    break;
                }
                case 10: {
                    buscarMusicasPorNome();
                    break;
                }
                case 11: {
                    adicionarAlbumAMusica();
                    break;
                }
                case -1: {
                    System.out.println("Saindo...");
                    break;
                }
                default : System.out.println("Comando inválido!");
            }
        }
    }
    public static void adicionarArtista(){
        System.out.println("Qual o nome do artista?");
        String nome = scanner.nextLine();
        System.out.println("Qual a nacionalidade do artista?");
        String nacionalidade = scanner.nextLine();
        System.out.println("Qual foi o ano de estreia do artista?");
        int anoEstreia = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Qual a bio do artista?");
        String bio = scanner.nextLine();
        System.out.println("Esse artista está ativo? (true ou false)");
        boolean ativo = scanner.nextBoolean();
        scanner.nextLine(); 
        System.out.println("Criando artista...");
        Artista artista = new Artista(nome, nacionalidade, anoEstreia, bio, ativo);
        artistas[numArtistas] = artista;
    }
    public static void adicionarAlbum() {
        System.err.println("Qual o título do Álbum?");
        String nome = scanner.nextLine();
        System.out.println("Qual foi o ano de lançamento?");
        int anoLancamento = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Quantas faixas o álbum possui?");
        int numFaixas = scanner.nextInt(); 
        scanner.nextLine();
        if(numArtistas == 0){
            System.out.println("Ainda não há artistas cadastrados, cadastre um artista antes de criar o álbum");
            return;
        }
        System.out.println("Selecione o artista criador do álbum entre esses, pelo id: ");
        listarArtistas();
        int selecao = scanner.nextInt();
        scanner.nextLine();
        Artista artistaEscolhido = artistas[selecao];
        Album novoAlbum = new Album(nome, anoLancamento, numFaixas, artistaEscolhido); 
        System.out.println("Criando álbum com as suas escolhas!");
        albuns[numAlbuns] = novoAlbum;
        numAlbuns++;
    }
    public static void adicionarMusica() {
        System.out.println("Qual o título da música?");
        String titulo = scanner.nextLine();
        System.out.println("Qual a duração da música?");
        double duracao = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Qual o gênero da música?");
        String genero = scanner.nextLine();
        System.out.println("Qual a faixa da música?");
        int faixa = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Selecione o álbum que contém a música entre esses, pelo id: ");
        listarAlbuns();
        System.out.println("Se for um single, digite -1");
        int selecao = scanner.nextInt();
        scanner.nextLine();
        if(selecao == -1){
            Musica novaMusica = new Musica(titulo, duracao, genero, faixa, null);
            musicas[numMusicas] = novaMusica;
            numMusicas++;
            return;
        }
        Album albumEscolhido = albuns[selecao];
        Musica novaMusica = new Musica(titulo, duracao, genero, faixa, albumEscolhido);
        albumEscolhido.adicionarMusica(novaMusica);
        musicas[numMusicas] = novaMusica;
        numMusicas++;
    }
    public static void listarMusicas(){
        for(int i = 0; i < numMusicas; i++){
            System.out.println("id: " + i + " titulo: " + musicas[i].getTitulo());
        }
    }
    public static void listarArtistas(){
        for(int i = 0; i < numArtistas; i++){
            System.out.println("id: " + i + " nome: " + artistas[i].getNome());
            
        }
    }
    public static void listarAlbuns(){
        for(int i = 0; i < numAlbuns; i++){
            System.out.println("id: " + i + " titulo: " + albuns[i].getTitulo());
        }
    }
    public static void adicionarPlaylist() {
        System.out.println("Qual o nome da playlist?");
        String nome = scanner.nextLine();
        System.out.println("Qual a descrição da playlist?");
        String descricao = scanner.nextLine();
        System.out.println("Essa playlist é favorita? (true/false)");
        boolean favorita = scanner.nextBoolean();
        Playlist novaPlaylist = new Playlist(nome, descricao, favorita);
        playlists[numPlaylists] = novaPlaylist;
        numPlaylists++;
    }
    public static void adicionarEmPlaylist() {
        System.out.println("Selecione a playlist que deseja adicionar a música, pelo id: ");
        listarPlaylists();
        int selecao = scanner.nextInt();
        scanner.nextLine();
        Playlist playlistEscolhida = playlists[selecao];
        System.out.println("Selecione a música que deseja adicionar na playlist, pelo id: ");
        listarMusicas();
        selecao = scanner.nextInt();
        scanner.nextLine();
        Musica musicaEscolhida = musicas[selecao];
        playlistEscolhida.adicionarMusica(musicaEscolhida);
    }
    public static void listarPlaylists(){
        for(int i = 0; i < numPlaylists; i++){
            System.out.println("id: " + i + " nome: " + playlists[i].getNome());
        }
    }       
    public static void listarPlaylistsPretty(){
        System.out.println("Playlists Cadastradas:");
        for(int i = 0; i < numPlaylists; i++){
            System.out.println("id: " + i + " nome: " + playlists[i].getNome());
            Musica[] musicas = playlists[i].getMusicas();
            for(int j = 0; j < musicas.length; j++){
                if(musicas[j] != null){
                    System.out.println("    id: " + j + " titulo: " + musicas[j].getTitulo());
                }
            }
        }
    }
    public static void listarAlbunsPretty(){
        System.out.println("Álbuns Cadastrados:");
        for(int i = 0; i < numAlbuns; i++){
            System.out.println("Álbum: " + albuns[i].getTitulo());
            System.out.println("    Ano de lançamento: " + albuns[i].getAnoLancamento());
            System.out.println("    Número de faixas: " + albuns[i].getNumFaixas());
            System.out.println("    Artista: " + albuns[i].getArtista().getNome());
            Musica[] musicas = albuns[i].getMusicas();
            for(int j = 0; j < musicas.length; j++){
                if(musicas[j] != null){
                    System.out.println("    Música: " + musicas[j].getTitulo());
                    System.out.println("        Duração: " + musicas[j].getDuracao());
                    System.out.println("        Gênero: " + musicas[j].getGenero());
                    System.out.println("        Faixa: " + musicas[j].getFaixa());
                }
            }
        }
    }
    public static void listarArtistasPretty(){
        System.out.println("Artistas Cadastrados:");
        for(int i = 0; i < numArtistas; i++){
            System.out.println("Nome do artista: " + artistas[i].getNome());
            System.out.println("    Nacionalidade: " + artistas[i].getNacionalidade());
            System.out.println("    Ano de estreia: " + artistas[i].getAnoEstreia());
            System.out.println("    Bio: " + artistas[i].getBio());
            System.out.println("    Ativo: " + artistas[i].getAtivo());
            Album[] albunsDoArtista = new Album[100];
            int numAlbunsDoArtista = 0;
            for(int j = 0; j < numAlbuns; j++){
                if(albuns[j].getArtista().equals(artistas[i])){
                    albunsDoArtista[numAlbunsDoArtista] = albuns[j];
                    numAlbunsDoArtista++;
                }
            }
            for(int j = 0; j < numAlbunsDoArtista; j++){
                System.out.println("    Álbum: " + albunsDoArtista[j].getTitulo());
                Musica[] musicas = albunsDoArtista[j].getMusicas();
                for(int k = 0; k < musicas.length; k++){
                    if(musicas[k] != null){
                        System.out.println("        Música: " + musicas[k].getTitulo());
                    }
                }
            }
        }
    }
    public static void listarMusicasPretty(){
        System.out.println("Músicas Cadastradas:");
        for(int i = 0; i < numMusicas; i++){
            System.out.println("Música: " + musicas[i].getTitulo());
            Album album = musicas[i].getAlbum();
            System.out.println("    Álbum: " + album.getTitulo());
            Artista artista = album.getArtista();
            System.out.println("    Artista: " + artista.getNome());
        }
    }
    public static void buscarMusicasPorNome(){
        System.out.println("Digite o nome da música que deseja buscar:");
        String nome = scanner.nextLine();
        boolean encontrou = false;
        for(int i = 0; i < numMusicas; i++){
            if(musicas[i].getTitulo().toLowerCase().startsWith(nome.toLowerCase())){ // colocar p/ lowercase antes de buscar p/ garantir que vai ser igual
                System.out.println("Música encontrada: " + musicas[i].getTitulo());
                Album album = musicas[i].getAlbum();
                System.out.println("    Álbum: " + album.getTitulo());
                Artista artista = album.getArtista();
                System.out.println("    Artista: " + artista.getNome());
                encontrou = true;
            }
        }
        if(!encontrou){
            System.out.println("Nenhuma música encontrada com esse nome.");
        }
    }
    public static void adicionarAlbumAMusica(){
        System.out.println("Selecione a música que deseja adicionar o álbum, pelo id: ");
        listarMusicas();
        int selecao = scanner.nextInt();
        scanner.nextLine();
        Musica musicaEscolhida = musicas[selecao];
        System.out.println("Selecione o álbum que deseja adicionar à música, pelo id: ");
        listarAlbuns();
        selecao = scanner.nextInt();
        scanner.nextLine();
        Album albumEscolhido = albuns[selecao];
        musicaEscolhida.setAlbum(albumEscolhido);
    }
}
    