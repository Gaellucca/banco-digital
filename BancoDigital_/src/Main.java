public class Main {
    public static void main(String[] args) {
        // Cria um banco
        Banco meuBanco = new Banco("Meu Banco Digital");

        // Cria clientes
        Cliente cliente1 = new Cliente("Maria Silva", "123.456.789-00");
        Cliente cliente2 = new Cliente("João Santos", "987.654.321-11");

        meuBanco.adicionarCliente(cliente1);
        meuBanco.adicionarCliente(cliente2);

        // Cria contas usando polimorfismo
        // Podemos declará-las como Conta, mas instanciar como ContaCorrente ou ContaPoupanca
        Conta contaCorrenteMaria = new ContaCorrente(cliente1, 1, 1001);
        Conta contaPoupancaJoao = new ContaPoupanca(cliente2, 1, 2002);

        meuBanco.adicionarConta(contaCorrenteMaria);
        meuBanco.adicionarConta(contaPoupancaJoao);

        // Realiza operações
        contaCorrenteMaria.depositar(500.0);
        contaPoupancaJoao.depositar(1000.0);

        meuBanco.listarContas();

        contaCorrenteMaria.sacar(150.0);
        contaPoupancaJoao.transferir(200.0, contaCorrenteMaria);

        meuBanco.listarContas();

        // Tentando operações inválidas
        contaCorrenteMaria.sacar(1000.0); // Saldo insuficiente
        contaCorrenteMaria.transferir(-50.0, contaPoupancaJoao); // Valor de transferência inválido
    }
}