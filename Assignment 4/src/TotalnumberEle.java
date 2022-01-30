import java.util.Arrays;
import java.util.List;

public class TotalnumberEle
{
	public static void main(String[] args)
	{
		List<Integer> numbers = Arrays.asList(88, 2, 1, 3, 3, 2, 4,5,7,8,41,44,55,67,64,222,111,14444,15555,31111,1,21,14,100);
		System.out.println(" Total Number of element in the list:");
		long count=numbers.stream()
			.count();
		System.out.println(count);
	}
}
