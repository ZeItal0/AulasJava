package TasksPOO;

public class TratamentoDeString {

	public static void main(String[] args) {
		
		String name = "UNI Patrick estrela RIO";
		String vowels = "aeiou";
		int count = 0;
		
	
		int quant = name.length();
		System.out.printf("A quantidade de caracteres: %d%n",quant );
		
		String newName = name.toUpperCase();
		System.out.println(newName);
		
		newName = newName.toLowerCase();
		
		for (int number = 0; number < quant; number++) {
			char quantVowels = newName.charAt(number);
				if (vowels.indexOf(quantVowels) != -1) {
					count++;
				}
		}
		System.out.printf("O numero de vogais e: %d%n",count);
		
		name = name.toLowerCase();
		System.out.println("O nome comeca com UNI?:" + name.startsWith("uni"));
		System.out.println("O nome termina com RIO?:" + name.endsWith("rio"));

	}
}