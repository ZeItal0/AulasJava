package Aula08;

import java.io.IOException;

public class TestarLeituraObj {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Motocicleta moto = (Motocicleta) Serialize.ler("minha_moto.txt");
        System.out.println(moto.getModelo());
    }
}
