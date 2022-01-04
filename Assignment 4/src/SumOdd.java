import java.util.Arrays;
import java.util.List;
public class SumOdd {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4,5,7,8,41,44,55,67,64);
	

		System.out.println("\n Sum of Odd numbers:");
		int sum=numbers.stream()
		       .filter(i -> i % 2 != 0 || i==1)
		       .reduce(0, (a,b) -> a+b);
		       System.out.println(sum);
	}

}
