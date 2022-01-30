import java.util.Arrays;
import java.util.List;

public class StreamEvenOddNo
{
	public static void main(String[] args)
	{
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4,5,7,8,41,44,55,67,64);
		System.out.println("Even numbers:");
		
		numbers.stream()
			.filter(i -> i % 2 == 0)
			.distinct()
			.forEach(System.out::println);
		System.out.println("\nOdd numbers:");
		numbers.stream()
			.filter(i -> i % 2 != 0 || i==1)
			.distinct()
			.forEach(System.out::println);
	}
}
