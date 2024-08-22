package aula1;

public class Automovel {
    String nome;
    String cor;
    String ano;
    String modelo;
    int velocidade = 0;
    boolean isUsado;

    int acelerar(int novaVelocidade) {
         velocidade = novaVelocidade + 3;
        return velocidade;
    }
    int reduzir(int reducao){
        velocidade = velocidade - 5;
        return velocidade;
    }
    int qualVelocidade() {
    	return velocidade;
    	
    }
    void qualMeuCarro(String NomeCarro,String corCarro, String anoCarro,String ModeloCarro) {
    	nome = NomeCarro;
    	cor = corCarro;
    	ano = anoCarro;
    	modelo = ModeloCarro;
    	
    }
}
