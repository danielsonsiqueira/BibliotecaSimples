import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            System.out.println("=== Sistema de Gestão de Biblioteca ===");
            System.out.println("\n1. Adicionar Livro");
            System.out.println("2. Emprestar Livro");
            System.out.println("3. Devolver Livro");
            System.out.println("4. Exibir Livros Disponíveis");
            System.out.println("5. Buscar Livro por Autor");
            System.out.println("6. Sair");
            System.out.print("\nEscolha uma opção: ");

            int opcao = 0;

            // Tratamento de erro == menu ==
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt
            } catch (Exception e) {
                System.out.println("\n Digite um valor válido. Tente novamente.");
                scanner.nextLine(); // Limpar a entrada para evitar loops infinitos
                continue; // Voltar ao início do loop para nova entrada
            }

            switch (opcao) {

                case 1:
                    
                    // Adicionar novo livro
                    System.out.print("\nDigite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o nome do autor do livro: ");
                    String autor = scanner.nextLine();
                    
                    int anoPublicacao = 0;
                    boolean anoValido = false;
                    while (!anoValido) {
                        System.out.print("Digite o ano de publicação: ");
                        try {
                            anoPublicacao = scanner.nextInt();
                            scanner.nextLine();
                            if (anoPublicacao > 0) {
                                anoValido = true;
                            } else {
                                System.out.println("O ano deve ser um número positivo. Tente novamente.");
                            }
                        } catch (Exception e) {
                            System.out.println("Digite um valor numérico válido para o ano. Tente novamente.");
                            scanner.nextLine();
                        }
                    }

                    boolean disponivel = false;
                    boolean disponivelValido = false;
                    
                    while (!disponivelValido) {
                        System.out.print("Está disponível? Digite 'true' para SIM ou 'false' para NÃO: ");
                        try {
                            disponivel = scanner.nextBoolean();
                            scanner.nextLine();
                            disponivelValido = true;
                        } catch (Exception e) {
                            System.out.println("Digite 'true' para SIM ou 'false' para NÃO. Tente novamente.");
                            scanner.nextLine();
                        }
                    }

                    Livro livro = new Livro(titulo, autor, anoPublicacao, disponivel);
                    biblioteca.adicionarLivro(livro);
                    break;

                case 2:

                    // Emprestar livro
                    System.out.print("Digite o título do livro para emprestar: ");
                    String tituloEmprestimo = scanner.nextLine();
                    biblioteca.emprestarLivro(tituloEmprestimo);
                    break;

                case 3:

                    // Devolver livro
                    System.out.print("Digite o título do livro para devolver: ");
                    String tituloDevolucao = scanner.nextLine();
                    biblioteca.devolverLivro(tituloDevolucao);
                    break;

                case 4:

                    // Exibir livros disponíveis
                    biblioteca.exibirLivrosDisponiveis();
                    break;

                case 5:

                    // Buscar livro por autor
                    System.out.print("Digite o nome do autor: ");
                    String autorBusca = scanner.nextLine();
                    biblioteca.buscarLivroPorAutor(autorBusca);
                    break;

                case 6:

                    // Sair
                    System.out.println("\n Saindo do sistema. Até logo!");
                    scanner.close();
                    return;

                default:

                    // Valores inválidos
                    System.out.println("\n Digite valores válidos. Tente novamente.");
                    break;
            }
            System.out.println();
        }

    }
}
