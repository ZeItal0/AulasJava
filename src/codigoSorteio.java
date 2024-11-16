import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class codigoSorteio {
    public static void main(String[] args){
        List<String> itensX = List.of(
                "ANTONIO MEDEIROS DE ALMEIDA NETO -> Presente 23/10",
                "ANTONIO RAMOS DA SILVA -> Presente 23/10",
                "AUDRI RIAN CORDEIRO CARVALHO ALVES  -> Presente 23/10 -> OK",
                "BRENO EMANUEL ARAUJO DE ANDRADE",
                "CLAUDIVAN JOSÉ SANTOS DE ARAÚJO -> Presente 23/10",
                "EDCARLOS FRANCA DA SILVA",
                "ERICK LEVI BASÍLIO DE AQUINO -> Presente 23/10 -> ok",
                "FELLIPE FERREIRA BEZERRA -> Presente 23/10 - Sem",
                "GABRIELA DA SILVA MACHADO -> Presente 23/10 -> OK",
                "ÍCARO DE ANDRADE SANTOS -> Presente 23/10",
                "JAMILLE MAGALHÃES PINTO",
                "JERFESSON DA SILVA MELO -> Presente 23/10",
                "JOÃO LUCAS ALMEIDA DOS SANTOS -> Presente 23/10 OK",
                "JOÃO PAULO BARBOSA VAZ -> Presente 23/10 - Sem",
                "JONATHAN ANTONIO SALVADOR DE BRITO -> Presente 23/10 - sEM",
                "JOSE ITALO DOS SANTOS MARTINS -> Presente 23/10",
                "JOSÉ ROBERTO LUIZ GOMES JUNIOR -> Presente 23/10",
                "KELVIN KAUÊ VIANA SIQUEIRA -> Presente 23/10",
                "LUCAS RAFAEL BEZERRA -> Presente 23/10",
                "MARIA BEATRIZ SILVA SANTOS -> Presente 23/10 - Sem",
                "MARIA HELENA CARNEIRO RAMALHO ROQUE -> Presente 23/10",
                "MARINA GRAZIELLY PAES DUARTE",
                "MAYKON VANDERSON SIQUEIRA SANTOS -> Presente 23/10",
                "PEDRO HENRIQUE FELIX CAVALCANTI -> Presente 23/10",
                "PEDRO HENRIQUE SANTOS CAVALCANTI -> Presente 23/10",
                "PEDRO IGOR DA SILVA RIBEIRO -> Presente 23/10",
                "RAMON GALINDO ALVES -> Presente 23/10 - Sem",
                "RANIELY BEZERRA DA SILVA",
                "RICHARD MATHEUS TENÓRIO CAVALCANTI -> Presente 23/10",
                "SABRINA BRAZ FERREIRA DE BRITO -> Presente 23/10",
                "SAMUEL PEREIRA DE LIMA -> Presente 23/10 ok",
                "SÁVIO SOUZA CAVALCANTE GUEDES -> Presente 23/10",
                "STÉFANE CAROLINE OLIVEIRA DA SILVA LIRA -> Presente 23/10 OK",
                "TAINÁ TAISA DA CONCEIÇÃO HENRIQUE -> Presente 23/10 -> ok",
                "VINICIUS ALBERTO SOUSA DUARTE DO AMARAL -> Presente 23/10 - Sem",
                "VINICIUS SOUZA DE MORAES -> Presente 23/10 OK ",
                "WANDERSON PAZ PACHECO -> Presente 23/10"
        );

        List<String> itensY = List.of("Restaurante", "Categoria", "Endereço", "Promocao", "Avaliacao", "Pedido", "forma de pagamento",
                "Status entrega", "status pagamento", "historico entrega", "historico pagamento", "Produto_acompanhamento",
                "Produto_pedido_acompanhamento", "");

        Random random = new Random();
        String valorX = itensX.get(random.nextInt(itensX.size()));
        String valorY = itensY.get(random.nextInt(itensY.size()));

        System.out.println("Aluno " + valorX + " vai falar sobre: " + valorY);
    }
}
