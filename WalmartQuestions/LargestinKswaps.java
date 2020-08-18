/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static String max;
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int k=sc.nextInt();
		    String s=sc.next();
		    char ch[]=s.toCharArray();
		    max=s;
		    largest(ch,k,0);
		    System.out.println(max);
		}
	}
	static void largest(char ch[],int k,int count){
	    if(k==0)
	        return;
	    int n=ch.length;
	    if(n<=count)
	        return;
	    char maxm=ch[count];
	    for(int j=count+1;j<n;j++)
	        if(maxm<ch[j])
	            maxm=ch[j];
	    if(maxm!=ch[count])
	        k--;
	    for(int j=count;j<n;j++){
	        if(maxm==ch[j]){
	            char temp=ch[count];
	            ch[count]=ch[j];
	            ch[j]=temp;
	            String s=String.copyValueOf(ch);
	            if(s.compareTo(max)>0)
	                max=s;
	            largest(ch,k,count+1);
	            temp=ch[count];
	            ch[count]=ch[j];
	            ch[j]=temp;
	            s=String.copyValueOf(ch);
	        }
	    }
	}
}
