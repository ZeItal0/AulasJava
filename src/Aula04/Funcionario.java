package Aula04;

public class Funcionario extends Pessoa{

    private String senha;

    Funcionario(String name){
        super(name);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
