public class FizzBuzz {
	public static void main(String[] args) 
    {
		
		for(int i=1;i<101;i++) {
			if(i%3==0 ) {
				if(i%5==0) {
					System.out.println("\tFizzBuzz\t\t"+i);
				}
				else {
					System.out.println("\tFizz\t\t"+i);
				}
				
			}
			else if(i%5==0 ) {
				if(i%3==0) {
					System.out.println("\tFizzBuzz\t"+i);
				}
				else {
					System.out.println("\tBuzz\t\t"+i);
				}
			}
			else {i++;}
				
		}
    }

}
