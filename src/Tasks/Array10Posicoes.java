package Tasks;

public class Array10Posicoes {

	public static void main(String[] args) {
		
		int[] position = new int[10];
		
		for (int index = 0;index <= 9;index++) {
			position[index] = index;
			
			if(index > 3) {
				System.out.printf("%d-", position[index]);
			}
			
		}
		
		
		
		
		

	}

}
