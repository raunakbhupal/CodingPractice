/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    String str=sc.next();
		    String pat=sc.next();
		    findString(str,pat);
		}
	}
	static void findString(String str,String pat){
	    int len1=str.length();
	    int len2=pat.length();
	    if(len1<len2){
	        System.out.println("-1");
	        return;
	    }
	    int str1[]=new int[256];
	    int pat1[]=new int[256];
	    for(int i=0;i<len2;i++)
	        pat1[pat.charAt(i)]++;
	    int start=0;
	    int index=-1;
	    int len=Integer.MAX_VALUE;
	    int count=0;
	    for(int i=0;i<len1;i++){
	        str1[str.charAt(i)]++;
	        if(pat1[str.charAt(i)]!=0&&str1[str.charAt(i)]<=pat1[str.charAt(i)])
	            count++;
	        if(count==len2){
	            while(str1[str.charAt(start)]>pat1[str.charAt(start)]||pat1[str.charAt(start)]==0){
	                if(str1[str.charAt(start)]>pat1[str.charAt(start)])
	                    str1[str.charAt(start)]--;
	                start++;
	            }
	            int window=i-start+1;
	            if(len>window){
	                len=window;
	                index=start;
	            }
	        }
	    }
	    if(index==-1){
	        System.out.println("-1");
	        return;
	    }
	    System.out.println(str.substring(index,index+len));
	}
}
