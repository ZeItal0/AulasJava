package Aula08;

import javax.swing.*;
import java.util.InputMismatchException;

public class Except {
    public static void main(String[] args){
        int x = 10;
        int y = 0;

        try {
            System.out.println("1");
            System.out.println(x / y);
            System.out.println("2");
        } catch (InputMismatchException ex){
            System.out.println("ArithmeticException" + ex.getMessage());
            JOptionPane.showMessageDialog(null,
                    "Desculpa, vc digitou errado");
        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
        }
        System.out.println("finally");


    }
}
