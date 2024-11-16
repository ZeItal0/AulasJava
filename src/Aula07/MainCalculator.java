package Aula07;

public class MainCalculator {
    public static void main(String[] args) {
        operation calculator = new Calculator();

        System.out.println("Soma: " + calculator.sum(5, 3));
        System.out.println("Subtração: " + calculator.subtract(5, 3));
        System.out.println("Multiplicação: " + calculator.multiply(5, 3));
        System.out.println("Divisão: " + calculator.divide(5, 3));
    }
}
