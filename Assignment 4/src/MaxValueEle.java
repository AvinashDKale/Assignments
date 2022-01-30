import java.util.Arrays;
import java.util.List;

public class MaxValueEle
{
	public static void main(String[] args)
	{
		List<Integer> numbers = Arrays.asList(88, 2, 1, 3, 3, 2, 4,5,7,8,41,44,55,67,64,222,111,14444,15555,31111,1,21,14,100);
		System.out.println(" Maximum value element in the list:");
		int count=numbers.stream()
			.max(Integer::compare)
			.get();
		System.out.println(count);
	}
}
