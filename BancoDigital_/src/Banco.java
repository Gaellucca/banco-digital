import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;
    private List<Cliente> clientes;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " adicionado ao banco " + this.nome);
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
        System.out.println("Conta " + conta.getNumero() + " adicionada para o cliente " + conta.getCliente().getNome());
    }

    public Conta buscarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null; // Conta não encontrada
    }

    public void listarContas() {
        System.out.println("\n--- Contas do Banco " + this.nome + " ---");
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }
        for (Conta conta : contas) {
            System.out.println("Cliente: " + conta.getCliente().getNome() +
            ", Tipo: " + (conta instanceof ContaCorrente ? "Corrente" : "Poupança") +
            ", Agência: " + conta.getAgencia() +
            ", Número: " + conta.getNumero() +
            ", Saldo: R$" + String.format("%.2f", conta.getSaldo()));
        }
        System.out.println("-------------------------------------");
    }
}