
//11.To find duplicate characters in string 

import java.util.*;
class Strings{
public void printDuplicates(char[] str)
{
int count=0;
for(int i=0;i<str.length;i++)
{
count=1;
for(int j=i+1;j<str.length;j++)
{
if(str[i]==str[j]&&str[i]!=' ')
{
count=count+1;
str[j]='0';
}
}
if(count>1&&str[i]!='0')
{
System.out.print(str[i]);
}
}
}
}
public class StringDuplicates{
public static void main(String[]args)
{
Scanner sc=new Scanner(System.in);
System.out.print("Enter String: ");
String str=sc.nextLine();
char string[]=str.toCharArray();
Strings s=new Strings();
s.printDuplicates(string);
}
}