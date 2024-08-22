package aula1;

public class aula1 {
    public static void main(String[] args){
        Automovel carro = new Automovel();
        carro.nome  = "Corsa";
        carro.velocidade = 0;
        int mudancaDeVelocidade = 0;
        
        
       mudancaDeVelocidade =  carro.acelerar(mudancaDeVelocidade);
       System.out.println("Carro:" + carro.nome + " Primeira Velocidade ->" + mudancaDeVelocidade + " Km/h");
        
       mudancaDeVelocidade = mudancaDeVelocidade + 10;
       mudancaDeVelocidade =  carro.acelerar(mudancaDeVelocidade);
       System.out.println("Carro:" + carro.nome + " Segunda Velocidade -> " + mudancaDeVelocidade + " Km/h");
       mudancaDeVelocidade =  carro.acelerar(mudancaDeVelocidade);
        
        carro.qualVelocidade();
        System.out.println(" Velocidade atual -> " + carro.qualVelocidade() + " Km/h");
        
        mudancaDeVelocidade =  carro.reduzir(mudancaDeVelocidade);
        System.out.println("Carro:" + carro.nome + " Segunda Velocidade -> " + mudancaDeVelocidade + " Km/h");
        
        carro.qualMeuCarro("Corsa","Preto","2001","chevrolet");
        System.out.println("Caracteristicas do carro -> "+carro.nome +", "+ carro.cor +", "+ carro.ano +", "+ carro.modelo);
        // GITHUB

    
    }
}