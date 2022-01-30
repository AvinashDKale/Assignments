import java.util.Arrays;
import java.util.List;
public class Startwith1
{
	public static void main(String[] args)
	{
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4,5,7,8,41,44,55,67,64,222,111,14444,15555,31111,1,21,14,100);
		System.out.println(" Numbers starting with 1:");
		numbers.stream()
			.map(s -> s + "")
			.filter(s -> s.startsWith("1"))
			.forEach(System.out::println);
	}
}
