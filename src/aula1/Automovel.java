package aula1;

public class Automovel {
    String modelo;
    String cor;
    int velocidade = 0;
    boolean isUsado;

    void acelerar() {
        velocidade = velocidade + 1;
    }
    void parar(){
        velocidade = 0;
    }
    void reduzir(){
        velocidade = velocidade - 1;
    }
}
