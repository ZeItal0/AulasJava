package Aula04;

public class main {
    public static void main(String[] args){
        Address address = new Address();
        address.setRua("Centro da cidade");

        Client client = new Client();
        client.setName("Pedro");
        client.setIdade(18);
        client.setCasado(true);
        client.setAddress(address);

        Client client2 = new Client();
        client2.setName("Pedro 2");

        Client client3 = new Client();
        client2.setName("Pedro 3");

        System.out.println(client.getName());
        System.out.println(client.getIdade());
        System.out.println(client.getAddress().getRua());

        Buy buy = new Buy();
        buy.addClient(client);
        buy.addClient(client2);


    }
}
