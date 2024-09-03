package Aula02;

import java.util.ArrayList;

public class Arrays {
    public static void main(String[] args) {

        String[] nomes = {"Alice", "Bob", "Carlos", "Diana",
                "Eva", "Lucas", "Rani"};
//        String[] nomesVazios = new String[5];
//        boolean[] meusBoo = new boolean[3];
//        int[] valores = {0,1,2,3,4};

//        for (int x = 0; x < nomes.length; x++) {
//            System.out.println("Na linha " + x + " o nome é: "
//                    + nomes[x].length());
//        }
//

//
//        int[] novosValores = new int[5];
//        novosValores[0] = 11;
//        novosValores[1] = 10;
//        novosValores[2] = 20;
//        System.out.println("novosValores -> " + novosValores[3]);




//
//        System.out.println("novosValores -> " + novosValores[1]);
//        System.out.println("novosValores -> " + novosValores[0]);
//



        ArrayList<String> nomesArray = new ArrayList<>();

        nomesArray.add("Alice");
        nomesArray.add("Bob");
        nomesArray.add("Carlos");
        nomesArray.add("Diana");
        nomesArray.add("Eva");
        nomesArray.add("Rani");

//        nomesArray.remove(2);


        if(!nomesArray.isEmpty()){
            // Exibindo os nomes
            for (int x = 0; x < nomesArray.size(); x++) {
                System.out.println("Na linha " + x +
                        " o nome da pessoa é: "
                        + nomesArray.get(x));

                if(nomesArray.get(x).equals("Rani")){
                    System.out.println("Removendo Rani");
//                    nomesArray.remove(nomesArray.get(x));
                    System.out.println(nomesArray.get(x));
                }
            }
        }


        
     ArrayList<String> nameProduct = new ArrayList<>();
     
     nameProduct.add("Cake");
     nameProduct.add("Coconut");
     nameProduct.add("Soda");
     nameProduct.add("Beef");
     nameProduct.add("Beer"); 
     nameProduct.add("Honey"); 
     nameProduct.add("cookie"); 
     
     for (int index = 0;index < nameProduct.size();index++) {
    	 System.out.println("Product name ->" + nameProduct.get(index));
     }
     
     
    	 System.out.println("Product remove ->" + nameProduct.get(2));
    	 nameProduct.remove(2);
     
        
     for (int index = 0;index < nameProduct.size();index++) {
    	 System.out.println("Update product name ->" + nameProduct.get(index));
     }   
        
        
        
        
        
    }
}
