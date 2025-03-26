import java.util.Scanner;

public class SearchSpecificWord {

    static void findWord(String s,String word){
        String [] arr=s.split(" ");

        for(String i:arr){
            if(i.equals(word)){
                System.out.println("Word found");
                return ;
            }
        }
        System.out.println("Word Not found ");
    }
    public static void main(String[] args) {
        System.out.println("Enter any sentence ");
        Scanner sc=new Scanner(System.in);

        String s=sc.nextLine();

        System.out.println("Enter the word you want to find caseSensitive ");

        String word=sc.next();

        findWord(s,word);
    }
}
