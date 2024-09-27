package Aula04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sorteio {
    public static void main(String[] args) {

        String[] grupoAluno = {"Jhonata", "Lucas", "Audri", "Jamille", "Italo", "Breno", "Claudivan","JP","Taina", "Kelvin"};
        String[] dateProject = {"25/09", "25/09", "25/09", "25/09", "25/09", "02/10", "02/10","02/10","02/10","02/10"};

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < grupoAluno.length; i++) {
            indices.add(i);
        }

        Collections.shuffle(indices, new Random());

        for (int i = 0; i < grupoAluno.length; i++) {
            int idx = indices.get(i);
            System.out.println(grupoAluno[i] + " -> " + dateProject[idx]);
        }

    }
}
