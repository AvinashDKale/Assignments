import java.util.Scanner;

public class CountCharacter
{
    public static void main(String[] args)
    {
        String string;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        string = sc.nextLine();
        int count = 0;
        for(int i = 0; i < string.length(); i++)
        {
            if(string.charAt(i) != ' ')
                count++;
        }
        System.out.println("Total number of characters in a string: " + count);
        sc.close();
    }
}