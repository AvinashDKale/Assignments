import java.util.Scanner;
public class PrimeNumber {       
	
	
	
    public static void main(String args[]){    
        int i,halfTestNum=0,flag=0;      
        int testNumber;    
        Scanner sc = new Scanner(System.in);
        testNumber=sc.nextInt();
        halfTestNum=testNumber/2;      
        if(testNumber==0||testNumber==1){  
         System.out.println(testNumber+" is not prime number");      
        }else{  
         for(i=2;i<=halfTestNum;i++){      
          if(testNumber%i==0){      
           System.out.println(testNumber+" is not prime number");      
           flag=1;      
           break;      
          }      
         }      
         if(flag==0)  { System.out.println(testNumber+" is prime number"); }  
        }  
        sc.close();
      }    
        

}
