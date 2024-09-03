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
        
        
        
        int day = 1;
        String nameDay;
        
        if (day == 1) {
        	nameDay = "Sunday";
        }else if(day == 2) {
        	nameDay = "Monday";
        }else if (day == 3) {
        	nameDay = "Tuesday";
        }else if (day == 4) {
        	nameDay = "Wednesday";
        }else if (day == 5) {
        	nameDay = "Thursday";
        }else if (day == 6) {
        	nameDay = "Friday";
        }else if (day == 7) {
        	nameDay = "Saturday";
        }else {
        	nameDay = "This is day invalid";
        	
        }
        
        System.out.println(nameDay);
        
        
        int number = 9;
        int numberTwo = (number > 5) ? number + 10 : number - 5;
        
        if(numberTwo > 10) {
        	numberTwo += 10; 
        }else {
        	numberTwo *= 50;
        }
        
        System.out.println(numberTwo);
        
        
        int colors = 4;
        String colorName;
        
        switch (colors) {
        	case 1:
        		colorName = "Red";
        		break;
        	case 2:
        		colorName = "Blue";
        		break;
        	case 3:
        		colorName = "Yellow";
        		break;
        	case 4:
        		colorName = "Green";
        		break;
        	case 5:
        		colorName = "Pink";
        		break;
        	default:
        		colorName = "unknow color";
        		break;
        }
        
        System.out.println(colorName);
        
     
    }
}
