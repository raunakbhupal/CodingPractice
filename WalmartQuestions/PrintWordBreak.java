/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    String dict[]=new String[n];
		    for(int i=0;i<n;i++)
		        dict[i]=sc.next();
		    String word=sc.next();
		    Set<String> dictionary=new HashSet<String>();
		    for(String temp:dict)
		        dictionary.add(temp);
		    printWords(word,word.length(),dictionary,"");
		    System.out.println();
		}
	}
	static void printWords(String word,int len,Set<String> dictionary,String res){
	    for(int i=1;i<=len;i++){
	        String prefix=word.substring(0,i);
	        if(dictionary.contains(prefix)){
	            if(i==len){
	                res+=prefix;
	                System.out.print("("+res+")");
	                return;
	            }
	            printWords(word.substring(i,len),len-i,dictionary,res+prefix+" ");
	        }
	    }
	}
}
