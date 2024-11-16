package Aula08;

import java.io.IOException;
import java.io.Serializable;
import java.util.InputMismatchException;

public class Motocicleta implements Serializable {
    private String marca;
    private String modelo;
    private int velocidade;


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        if(velocidade < 0){
            throw new InputMismatchException("Velocidade não pode ser negativa");
        }
        this.velocidade = velocidade;
    }
}

