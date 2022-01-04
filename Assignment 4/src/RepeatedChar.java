import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

public class RepeatedChar {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter input string to find First repeated character:");
         
        String input = sc.nextLine();
         
       // char[] charArray = input.toCharArray();
    	
        

        Character result = input.chars() // Stream of String       
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
System.out.println(result);         
            sc.close();
    }
}