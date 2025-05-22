package view;
import model.BancoDeDados;
import java.util.*;

public class View {
    private Scanner scanner = new Scanner(System.in);

    // Simulando a lista de produtos
    public static class Produto {
        public int id;
        public String nome;
        public double preco;

        public Produto(int id, String nome, double preco) {
            this.id = id;
            this.nome = nome;
            this.preco = preco;
        }
    }

    // Lista fixa de produtos
    private List<Produto> produtos = Arrays.asList(
        new Produto(1, "FIFA 2026", 255.00),
        new Produto(2, "GOD OF WAR", 333.00),
        new Produto(3, "RESIDENT EVIL 4", 165.00),
        new Produto(4, "DEATH STRANDING 2", 380.00),
        new Produto(5, "METAL GEAR SOLID V", 120.00)
    );

    public void inserirCabecalho(String titulo) {
        System.out.println("===================================");
        System.out.println("        LOJA DE JOGOS");
        System.out.println("===================================");
        System.out.println(titulo);
        System.out.println("===================================");
    }

    public void desenharLinha() {
        System.out.println("===================================");
    }

    public int exibirMenuProdutos() {
        inserirCabecalho("PRODUTOS:");
        for (Produto p : produtos) {
            System.out.printf("%d - %s\tR$ %.2f\n", p.id, p.nome, p.preco);
        }
        desenharLinha();
        System.out.println("0 - SAIR");
        desenharLinha();
        System.out.print("QUE PRODUTO DESEJA COLOCAR NO CARRINHO:\n> ");
        return scanner.nextInt();
    }

    public void confirmarProdutoAdicionado(Produto produto) {
        System.out.println(produto.nome + " FOI INSERIDO NO CARRINHO!");
        desenharLinha();
    }

    public void exibirCarrinho(List<Produto> carrinho) {
        inserirCabecalho("CARRINHO:");
        double total = 0;
        int contador = 1;
        for (Produto p : carrinho) {
            System.out.printf("%d - %s\tR$ %.2f\n", contador, p.nome, p.preco);
            total += p.preco;
            contador++;
        }
        desenharLinha();
        System.out.println("Total: R$ " + total);
        desenharLinha();
        System.out.println("1 - FINALIZAR COMPRA");
        System.out.println("2 - CONTINUAR COMPRANDO");
        System.out.println("0 - SAIR");
        desenharLinha();
        System.out.print("> ");
    }

    public Map<String, String> exibirFormularioPagamento() {
        inserirCabecalho("FINALIZAR COMPRA");
        System.out.println("INSIRA OS DADOS DE PAGAMENTO:");
        Map<String, String> dados = new HashMap<>();

        System.out.print("NUMERO DO CARTAO: ");
        dados.put("cartao", scanner.next());

        System.out.print("SENHA: ");
        dados.put("senha", scanner.next());

        System.out.print("DATA DE VALIDADE (MM/AAAA): ");
        dados.put("validade", scanner.next());

        desenharLinha();
        System.out.println("1 - FINALIZAR");
        System.out.println("0 - SAIR");
        desenharLinha();
        System.out.print("> ");
        dados.put("opcao", scanner.next());

        return dados;
    }

    public void exibirComprovante(List<Produto> carrinho) {
        inserirCabecalho("COMPRA EFETUADA COM SUCESSO!");
        System.out.println("COMPROVANTE DE PAGAMENTO:");
        desenharLinha();
        int contador = 1;
        for (Produto p : carrinho) {
            System.out.printf("%d | %s | R$ %.2f\n", contador, p.nome, p.preco);
            contador++;
        }
        desenharLinha();
        System.out.println("1 - FAZER OUTRA COMPRA");
        System.out.println("0 - SAIR");
        desenharLinha();
        System.out.print("> ");
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
        desenharLinha();
    }

    public Produto buscarProdutoPorId(int id) {
        for (Produto p : produtos) {
            if (p.id == id) {
                return p;
            }
        }
        return null;
    }

    public int lerOpcao() {
        System.out.print("> ");
        return scanner.nextInt();
    }
}

