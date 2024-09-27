package Aula04;

public class Client {
    private String name;
    private int idade;
    private Address address;

    private boolean casado;

    String getName(){
        return name;
    }

    void setName(String nome){
        this.name = nome;
    }

    Address getAddress(){
        return address;
    }

    void setAddress(Address address){
        this.address = address;
    }

    void setIdade(int idade){
        this.idade = idade;
    }

    int getIdade(){
        return idade;
    }

    void setCasado(boolean casado){
        this.casado = casado;
    }
}

