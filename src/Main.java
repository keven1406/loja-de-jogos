import view.View;
import view.View.Produto;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        List<Produto> carrinho = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            int opcaoProduto = view.exibirMenuProdutos();
            if (opcaoProduto == 0) {
                continuar = false;
                break;
            }

            Produto escolhido = view.buscarProdutoPorId(opcaoProduto);
            if (escolhido != null) {
                carrinho.add(escolhido);
                view.confirmarProdutoAdicionado(escolhido);
            }

            view.exibirCarrinho(carrinho);
            int opcaoCarrinho = view.lerOpcao();

            if (opcaoCarrinho == 1) {
                Map<String, String> pagamento = view.exibirFormularioPagamento();
                if (pagamento.get("opcao").equals("1")) {
                    view.exibirComprovante(carrinho);
                    int novaCompra = view.lerOpcao();
                    if (novaCompra == 1) {
                        carrinho.clear();
                    } else {
                        continuar = false;
                    }
                } else {
                    continuar = false;
                }

            } else if (opcaoCarrinho == 0) {
                continuar = false;
            }
        }

        view.exibirMensagem("Encerrando o sistema. Obrigado!");
    }
}
