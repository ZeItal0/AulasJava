package Aula02;

public class Strings {
    public static void main(String[] args){
      String phrase = "Pessimismo leva à fraqueza, otimismo ao poder.";
      String phraseTwo = " fraqueza- ";
      
      System.out.println(phrase.equals(phraseTwo));
      System.out.println(phrase.length());
      System.out.println(phraseTwo);
      System.out.println(phraseTwo.trim());
      
      String words[] = phrase.split("");
      System.out.println(words[5]);
      
      System.out.println(phrase.equalsIgnoreCase(phraseTwo));
      System.out.println(phrase.toLowerCase());
      System.out.println(phrase.toUpperCase());
      System.out.println(phrase.replace("otimismo", "pessimismo"));

       String numcell = "(89)9-8435545";
       String novonum = numcell.replace("(89)", "89");
       novonum = novonum.replace("-", "");
       
      System.out.println(numcell);
      System.out.println(novonum);
    }
}
