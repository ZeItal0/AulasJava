package Tasks;

public class Calculator {

	public static void main(String[] args) {
		Calculation operation = new Calculation();
		
		double EntryOne = 98;
		double EntryTwo = 10;
		
		double Results_One = operation.Divisions(EntryOne, EntryTwo);
		System.out.printf("Division:%.2f%n",Results_One);
		
		double Results_Two = operation.Multiply(EntryOne, EntryTwo);
		System.out.printf("Multiply:%.2f%n", Results_Two);
		
		double Results_Three = operation.Subtraction(EntryOne, EntryTwo);
		System.out.printf("Subtraction:%.1f%n", Results_Three);
		
		double Results_Four = operation.Sum(EntryOne, EntryTwo);
		System.out.printf("Sum:%.2f", Results_Four);
		
		
		
		

	}

}
