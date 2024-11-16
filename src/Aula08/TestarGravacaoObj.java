package Aula08;

import java.io.IOException;

public class TestarGravacaoObj {
    public static void main(String[] args) throws IOException {
        Motocicleta moto = new Motocicleta();
        moto.setMarca("Honda");
        moto.setModelo("Titan");
        moto.setVelocidade(100);

        Serialize.gravar("minha_moto.txt", moto);
    }
}
