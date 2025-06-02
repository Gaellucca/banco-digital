public abstract class Conta { // Classe abstrata para comportamentos comuns da conta
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    // Construtor
    public Conta(Cliente cliente, int agencia, int numero) {
        this.cliente = cliente;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0.0; // Saldo inicial
    }

    // Métodos públicos (interface) para interação
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado. Novo saldo: R$" + this.saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado. Novo saldo: R$" + this.saldo);
        } else if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
        } else {
            System.out.println("Saldo insuficiente para o saque.");
        }
    }

    public void transferir(double valor, Conta contaDestino) {
        if (valor > 0 && this.saldo >= valor) {
            this.sacar(valor); // Reutiliza a lógica de saque
            contaDestino.depositar(valor); // Reutiliza a lógica de depósito
            System.out.println("Transferência de R$" + valor + " para a conta " + contaDestino.getNumero() + " realizada.");
        } else if (valor <= 0) {
            System.out.println("Valor de transferência inválido.");
        } else {
            System.out.println("Saldo insuficiente para a transferência.");
        }
    }

    // Getters para acessar atributos protegidos
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Não há setters para agencia ou numero para manter sua imutabilidade após a criação
    // setSaldo não é necessário, pois o saldo muda através dos métodos de depósito/saque/transferência
}