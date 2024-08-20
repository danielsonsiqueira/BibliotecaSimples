import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();

    public Biblioteca(){
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro){
        livros.add(livro);
        System.out.println("\n Livro adicionado: " + livro.getTitulo() );
    }

    public void emprestarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo) && livro.isDisponivel()) {
                livro.emprestar();
                System.out.println("\n Livro emprestado: " + livro.getTitulo());
                return;
            }
        }
        System.out.println("\n Livro não encontrado ou já emprestado. \n");
    }

    public void devolverLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo) && !livro.isDisponivel()) {
                livro.devolver();
                System.out.println("\n Livro devolvido: " + livro.getTitulo());
                return;
            }
        }
        System.out.println("\n Livro não encontrado ou já disponível.");
    }
    

    public void exibirLivrosDisponiveis(){
        System.out.println("\n Livros disponíveis: \n");

        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println("\nTítulo: " + livro.getTitulo() + ", Autor: " + livro.getAutor());
            }
        }
    }

    public void buscarLivroPorAutor(String autor) {
        System.out.println("\n Livros de " + autor + ":");
        boolean encontrou = false;
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                System.out.println("\n Título: " + livro.getTitulo() + ", Ano: " + livro.getAnoPublicacao());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("\n Nenhum livro encontrado para o autor " + autor);
        }
    }
    
}
