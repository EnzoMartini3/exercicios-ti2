import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        XDAO dao = new XDAO();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Listar");
            System.out.println("2. Inserir");
            System.out.println("3. Excluir");
            System.out.println("4. Atualizar");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    List<X> lista = dao.listar();
                    for (X x : lista) {
                        System.out.println(x.getId() + " - " + x.getNome() + " - " + x.getIdade());
                    }
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    dao.inserir(new X(0, nome, idade));
                    break;

                case 3:
                    System.out.print("ID para excluir: ");
                    dao.excluir(scanner.nextInt());
                    break;

                case 4:
                    System.out.print("ID para atualizar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova Idade: ");
                    int novaIdade = scanner.nextInt();
                    dao.atualizar(new X(id, novoNome, novaIdade));
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
