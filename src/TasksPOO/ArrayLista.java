package TasksPOO;

import java.util.ArrayList;

public class ArrayLista {

	public static void main(String[] args) {
		
		ArrayList<String> namesArray = new ArrayList<>();
		namesArray.add("Talles");
		namesArray.add("Jefersson");
		namesArray.add("Rany");
		namesArray.add("Marina");
		namesArray.add("Neto");
		
		
		namesArray.remove(1);
		
		for (int position = 0;position < namesArray.size();position++) {
			System.out.println(position + "->" + namesArray.get(position));
		}
		
		namesArray.remove(2);
		
		
		for (int position = 0;position < namesArray.size();position++) {
			System.out.println(position + "->" + namesArray.get(position));
		}
		
		if(namesArray.get(0).equals("Talles")) {
			System.out.printf("O primeiro nome e:%s", namesArray.get(0));
		}
		

	}

}
