//10. program to find maximum and minimum occuring character in string

import java.util.*;
class Characters{

public void printMinMaxOccurance(char[]str)
       {
           char minChar=str[0];
           char maxChar=str[0];

           int []freq=new int[str.length];
           for(int i=0;i<str.length;i++)
              {
                   freq[i]=1;
                   for(int j=i+1;j<str.length;j++)
                 {
                   if(str[i]==str[j]&&str[i]!=' '&&str[i]!='0')
                    {
                       freq[i]++;
                        str[j]='0';
                       }
                 }
             }
             int min,max;
             min=max=freq[0];
             for(int i=0;i<freq.length;i++)
             {
                if(min>freq[i]&&freq[i]!='0')
              {
                 min=freq[i];
               minChar=str[i];
              }
              if(max<freq[i])
              {
                 max=freq[i];
                  maxChar=str[i];
               }
              }
              System.out.print("\nMaximum Occuring character: "+maxChar);
              System.out.print("\nMinimum Occuring character: "+minChar);
             }

}

public class CharOccurance{

public static void main(String[]args)
{
Scanner sc=new Scanner(System.in);
System.out.print("Enter String: ");
String str=sc.nextLine();
char[] string=str.toCharArray();
Characters c= new Characters();
c.printMinMaxOccurance(string);
sc.close();
}

}







