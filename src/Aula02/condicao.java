package Aula02;

public class condicao {
    public static void main(String[] args){

        int idade = 200;
        int altura = 150;
        int value = 0;

        if(idade > 18 && altura < 100){
            System.out.println("IF");
            value += 5;
        } else if (idade > 200) {
            System.out.println("ELSE IF 1");
            value -=3;
        }else if (idade >= 18 && (altura != 200 && altura > 200) ) {
            System.out.println("ELSE IF 2");
            value *= 8;
        }else if (idade < 200 || altura == 150) {
            System.out.println("ELSE IF 3");
            value += 5;
        }
        
        
        
        System.out.println("o valor e: " + value);
    }
}
