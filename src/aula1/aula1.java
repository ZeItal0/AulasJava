package aula1;

public class aula1 {
    public static void main(String[] args){
        Automovel carro = new Automovel();
        carro.modelo = "Ford";
        carro.velocidade = 100;
        carro.acelerar();
        carro.acelerar();

        Automovel moto;
        moto = new Automovel();

        // GITHUB

        carro.reduzir();
        System.out.println(carro.modelo);
    }
}
