package Aula07;
import javax.swing.JOptionPane;

public class Joption {

    public static void main(String[] args) {

//        JOptionPane.showMessageDialog(null, "Olá" );
//
//        String opcao = JOptionPane.showInputDialog(
//                    "Menu:\n" +
//                            "1. Digite seu nome\n" +
//                            "2. Digite sua idade\n" +
//                            "0. Sair\n" +
//                            "Escolha uma opção:"
//            );


        boolean continuar = true;

        while (continuar) {

            String opcao = JOptionPane.showInputDialog(
                    "Menu:\n" +
                            "1. Digite seu nome\n" +
                            "2. Digite sua idade\n" +
                            "0. Sair\n" +
                            "Escolha uma opção:"
            );

            if (opcao == null) {
                continuar = false;
                break;
            }

            switch (opcao) {
                case "1":

                    String nome = JOptionPane.showInputDialog("Digite seu nome:");
                    if (nome != null) {
                        JOptionPane.showMessageDialog(null, "Olá, " + nome + "!");
                    }
                    break;
                case "2":

                    String idadeStr = JOptionPane.showInputDialog("Digite sua idade:");
                    if (idadeStr != null) {
//                        try {
                            int idade = Integer.parseInt(idadeStr);
                            JOptionPane.showMessageDialog(null, "Sua idade é: " + idade);
//                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Idade inválida! Tente novamente.");
//                        }
                    }
                    break;
                case "0":
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
}
