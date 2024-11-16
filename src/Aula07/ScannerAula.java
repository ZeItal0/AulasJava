package Aula07;
import java.util.Scanner;

public class ScannerAula {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.print("Digite seu nome: ");
//        String nome = scanner.nextLine();
//        System.out.println("Olá, " + nome + "!");
////
//        System.out.print("Digite sua idade: ");
//        int idade = scanner.nextInt();
//        System.out.println("Sua idade é: " + idade);


        boolean continuar = true;

        while (continuar) {
            System.out.println("Menu:");
            System.out.println("1. Digite seu nome");
            System.out.println("2. Digite sua idade");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite seu nome: ");
                    String name = scanner.nextLine();
                    System.out.println("Olá, " + name + "!");
                    break;
                case 2:
                    System.out.print("Digite sua idade: ");
                    int age = scanner.nextInt();
                    System.out.println("Sua idade é: " + age);
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
//
//
//
        scanner.close();
    }
}
