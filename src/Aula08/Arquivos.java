package Aula08;

import java.io.*;

public class Arquivos {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 30);
        String filename = "pessoa.txt";

        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(pessoa);
            System.out.println("Objeto gravado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Pessoa p = (Pessoa) in.readObject();
            System.out.println("Objeto lido do arquivo: " + p); }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
