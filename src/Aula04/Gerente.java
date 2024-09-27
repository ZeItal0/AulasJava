package Aula04;

public class Gerente extends Funcionario{
    private String nivel;
    Gerente(String name, String nivel) {
        super(name);
        this.nivel =  nivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
