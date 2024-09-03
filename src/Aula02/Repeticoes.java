package Aula02;

public class Repeticoes {
    public static void main(String[] args){


//        for(int i = 5; i <= 10; i++){
//            System.out.println(i);
//            i++;
//        }

//        for(int i = 5, x = 0; i <= 10 && x <= 5; i++, x++){
//            for(int)...
//        }

        int contador = 1;
        while(contador <= 10){
            System.out.println("while -> " + contador);
            contador++;
        }

        contador = 1;
        do {
            System.out.println("Do -> " + contador);
            contador++;
        }while(contador <= 10);
        
        
        for (int i = 9;i > 0;i--) {
        	System.out.printf("Decrease ->%d ", i);
        	if(i==1) {
        		System.out.printf("%n");
        	}
        }
        
        contador = 9;
        
        while (contador > 0 ){
        	System.out.printf("Decrease while ->%d ", contador);
        	contador--;
        }
        
        
        

    }
}
