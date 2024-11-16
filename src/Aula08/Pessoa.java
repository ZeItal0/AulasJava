package Aula08;

import java.io.Serializable;

class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private int idade;
    public Pessoa(String nome, int idade) {
        this.nome = nome; this.idade = idade;
    }
    @Override
    public String toString() {
        return "Pessoa{nome='" + nome + "', idade=" + idade + "}";

    }
}