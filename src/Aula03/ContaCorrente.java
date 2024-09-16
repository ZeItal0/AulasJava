package Aula03;

public class ContaCorrente {
    String agencia;
    private String NumeroConta;
    private double saldo = 40;

    ContaCorrente(String minhaAgencia, String minhaConta){
       this.agencia = minhaAgencia;
       this.NumeroConta = minhaConta;
    }

    String getNConta(){
        return this.NumeroConta;
    }

    void setNConta(String NumeroConta){
        this.NumeroConta = NumeroConta;
    }

    double getSaldo(){
        return this.saldo;
    }

    void setSaldo(double newSaldo){
        this.saldo = newSaldo;
    }



}
