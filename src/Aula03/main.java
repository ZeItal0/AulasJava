package Aula03;

public class main {
    public static void main(String[] args){
        ContaCorrente conta = new ContaCorrente("3015", "");

//        System.out.println(conta.agencia);
        System.out.println(conta.getNConta());
        conta.setNConta("54546");
        System.out.println(conta.getNConta());
        conta.setNConta("534634");
        System.out.println(conta.getNConta());
//        conta.NConta = "2222";
//        System.out.println(conta.NConta);

        System.out.println(conta.getSaldo());
        conta.setSaldo(100);

        System.out.println(conta.getSaldo());
        conta.setSaldo(-500);

        System.out.println(conta.getSaldo());
    }
}
