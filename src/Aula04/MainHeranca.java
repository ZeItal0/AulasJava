package Aula04;

public class MainHeranca {
    public static void main(String[] args){
        Gerente gerente = new Gerente("Gabi", "Tester");
        Funcionario funcionario = new Funcionario("Pedro");


        System.out.println(gerente.getName());
        System.out.println(gerente.getNivel());
        System.out.println(gerente.getSenha());

    }
}
