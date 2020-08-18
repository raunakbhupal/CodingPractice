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
		    String d[]=new String[n];
		    for(int i=0;i<n;i++)
		        d[i]=sc.next();
		    String word=sc.next();
		    Set<String> dictionary=new HashSet<String>();
		    for(String temp:d)
		        dictionary.add(temp);
		    System.out.println(checkWord(word,dictionary));
		}
	}
	static int checkWord(String word,Set<String> dictionary){
	    int len=word.length();
	    if(len==0)
	        return 1;
	    boolean dp[]=new boolean[len+1];
	    for(int i=1;i<=len;i++){
	        if(dp[i]==false&&dictionary.contains(word.substring(0,i))){
	            dp[i]=true;
	        }
	        if(dp[i]==true){
	            if(i==len)
	                return 1;
	            for(int j=i+1;j<=len;j++){
	                if(dp[j]==false&&dictionary.contains(word.substring(i,j))){
	                    dp[j]=true;
	                }
	                if(j==len&&dp[j]==true)
	                    return 1;
	            }
	        }
	    }
	    return 0;
	}
}
