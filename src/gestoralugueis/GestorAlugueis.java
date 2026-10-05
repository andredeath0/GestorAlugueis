package gestoralugueis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorAlugueis {
    private static List<Vila> vilas = new ArrayList<>();
    private static List<Locatario> locatarios = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Imovel> imoveis = new ArrayList<>();
    private static List<Contrato> contratos = new ArrayList<>();
    private static List<Pagamento> pagamentos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        carregarDadosIniciais();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n==========================================");
            System.out.println("     GESTOR DE ALUGUEIS - PROTOTIPO      ");
            System.out.println("==========================================");
            System.out.println("1. Listar Vilas");
            System.out.println("2. Cadastrar Imovel em uma Vila");
            System.out.println("3. Listar Imoveis Disponiveis");
            System.out.println("4. Cadastrar Locatario");
            System.out.println("5. Registrar Contrato de Aluguel");
            System.out.println("6. Listar Contratos Ativos");
            System.out.println("7. Registrar Pagamento");
            System.out.println("0. Sair");
            System.out.print("Opcao: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, informe um numero valido!");
                continue;
            }

            switch (opcao) {
                case 1 -> listarVilas();
                case 2 -> cadastrarImovel();
                case 3 -> listarImoveisDisponiveis();
                case 4 -> cadastrarLocatario();
                case 5 -> registrarContrato();
                case 6 -> listarContratos();
                case 7 -> registrarPagamento();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opcao invalida!");
            }
        }
    }

    private static void carregarDadosIniciais() {
        Vila v1 = new Vila(1, "Rua das Flores, 100", "Centro", "Sao Paulo", "SP", "01001000");
        Vila v2 = new Vila(2, "Av. Brasil, 200", "Jardins", "Sao Paulo", "SP", "01400000");
        vilas.add(v1);
        vilas.add(v2);

        Usuario admin = new Usuario(1, "Administrador", "admin", "123456", "ADMIN");
        usuarios.add(admin);

        Locatario loc1 = new Locatario(1, "Carlos Silva", "11111111111", "11999999999", "carlos@email.com");
        locatarios.add(loc1);

        Imovel im1 = new Imovel(1, v1, 101, 1200.00, "Disponivel");
        Imovel im2 = new Imovel(2, v1, 102, 1300.00, "Disponivel");
        imoveis.add(im1);
        imoveis.add(im2);
    }

    private static void listarVilas() {
        System.out.println("\n--- VILAS CADASTRADAS ---");
        vilas.forEach(System.out::println);
    }

    private static void cadastrarImovel() {
        System.out.println("\n--- NOVO IMOVEL ---");
        listarVilas();
        System.out.print("Informe o ID da Vila: ");
        int idVila = Integer.parseInt(scanner.nextLine());

        Vila vilaSel = vilas.stream().filter(v -> v.getIdVila() == idVila).findFirst().orElse(null);
        if (vilaSel == null) {
            System.out.println("Vila nao encontrada!");
            return;
        }

        System.out.print("Numero do Apartamento: ");
        int numAp = Integer.parseInt(scanner.nextLine());
        System.out.print("Valor do Aluguel (R$): ");
        double valor = Double.parseDouble(scanner.nextLine());

        int novoId = imoveis.size() + 1;
        Imovel novo = new Imovel(novoId, vilaSel, numAp, valor, "Disponivel");
        imoveis.add(novo);
        System.out.println("Imovel cadastrado com sucesso!");
    }

    private static void listarImoveisDisponiveis() {
        System.out.println("\n--- IMOVEIS DISPONIVEIS ---");
        imoveis.stream()
               .filter(i -> i.getStatus().equalsIgnoreCase("Disponivel"))
               .forEach(System.out::println);
    }

    private static void cadastrarLocatario() {
        System.out.println("\n--- NOVO LOCATARIO ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String tel = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        int novoId = locatarios.size() + 1;
        locatarios.add(new Locatario(novoId, nome, cpf, tel, email));
        System.out.println("Locatario cadastrado!");
    }

    private static void registrarContrato() {
        System.out.println("\n--- NOVO CONTRATO ---");
        listarImoveisDisponiveis();
        System.out.print("ID do Imovel desejado: ");
        int idImovel = Integer.parseInt(scanner.nextLine());

        Imovel imovelSel = imoveis.stream()
                .filter(i -> i.getIdImovel() == idImovel && i.getStatus().equalsIgnoreCase("Disponivel"))
                .findFirst().orElse(null);

        if (imovelSel == null) {
            System.out.println("Imovel indisponivel ou inexistente!");
            return;
        }

        System.out.println("Locatarios cadastrados:");
        locatarios.forEach(System.out::println);
        System.out.print("ID do Locatario: ");
        int idLoc = Integer.parseInt(scanner.nextLine());

        Locatario locSel = locatarios.stream().filter(l -> l.getIdLocatario() == idLoc).findFirst().orElse(null);
        if (locSel == null) {
            System.out.println("Locatario invalido!");
            return;
        }

        int novoId = contratos.size() + 1;
        Contrato c = new Contrato(novoId, imovelSel, locSel, usuarios.get(0), 
                                 "2026-01-01", "2026-12-31", imovelSel.getValorAluguel(), "Ativo");
        contratos.add(c);
        System.out.println("Contrato gerado com sucesso! O status do imovel mudou para 'Ocupado'.");
    }

    private static void listarContratos() {
        System.out.println("\n--- CONTRATOS REGISTRADOS ---");
        if (contratos.isEmpty()) {
            System.out.println("Nenhum contrato ativo.");
        } else {
            contratos.forEach(System.out::println);
        }
    }

    private static void registrarPagamento() {
        System.out.println("\n--- REGISTRO DE PAGAMENTO ---");
        listarContratos();
        if (contratos.isEmpty()) return;

        System.out.print("ID do Contrato: ");
        int idContrato = Integer.parseInt(scanner.nextLine());

        Contrato cSel = contratos.stream().filter(c -> c.getIdContrato() == idContrato).findFirst().orElse(null);
        if (cSel == null) {
            System.out.println("Contrato nao encontrado!");
            return;
        }

        System.out.print("Valor Pago (R$): ");
        double valor = Double.parseDouble(scanner.nextLine());

        int novoId = pagamentos.size() + 1;
        Pagamento p = new Pagamento(novoId, cSel, usuarios.get(0), "2026-08-24", valor, "Pago");
        pagamentos.add(p);
        System.out.println("Pagamento de R$ " + valor + " registrado com sucesso!");
    }
}