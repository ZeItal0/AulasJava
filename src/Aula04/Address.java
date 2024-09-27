package Aula04;

public class Address {
    private String rua;
    private boolean ativo;

    boolean isAtivo(){
        return ativo;
    }


    String getRua(){
        return rua;
    }

    void setRua(String newAddress){
        this.rua = newAddress;
    }
}
