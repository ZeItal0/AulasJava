package Aula05;

public class Main {

    public static void main(String[] args) {
    	
        new Contador();
        new Contador();
        new Contador();

        String nome;

        PF pf = new PF();
        
        String resposta = "male";
        pf.setSexo(resposta);
        
        Pessoa pessoa = new Pessoa();
        




        System.out.println("sexo: " + pf.getSexo());
        System.out.println("Número de instâncias: " + Contador.getContador());
    }

}
