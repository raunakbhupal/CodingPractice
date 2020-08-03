/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

public class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int x=sc.nextInt();
		    String dictionary[]=new String[x];
		    for(int i=0;i<x;i++)
		        dictionary[i]=sc.next();
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    String boggle[][]=new String[n][m];
		    for(int i=0;i<n;i++){
		        for(int j=0;j<m;j++){
		            boggle[i][j]=sc.next();
		        }
		    }
		    findWords(dictionary,boggle,n,m);
		    System.out.println();
		}
	}
	static void findWords(String dictionary[],String boggle[][],int n,int m){
	    boolean visited[][]=new boolean[n][m];
	    String str="";
	    for(int i=0;i<n;i++){
	        for(int j=0;j<m;j++)
	            findWordsUtil(dictionary,boggle,n,m,i,j,visited,str);
	    }
	}
	
	static void findWordsUtil(String dictionary[],String boggle[][],int n,int m,int i,int j,boolean visited[][],String str){
	    visited[i][j]=true;
	    str=str+boggle[i][j];
	    if(isPresent(dictionary,str))
	        System.out.print(str+" ");
	    for(int row=i-1;row<=i+1&&row<n;row++){
	        for(int col=j-1;col<=j+1&&col<m;col++){
	            if(row>=0&&col>=0&&!visited[row][col]){
	                findWordsUtil(dictionary,boggle,n,m,row,col,visited,str);
	            }
	       }
	    }
	    str=""+str.charAt(str.length()-1);
	    visited[i][j]=false;
	}
	
	static boolean isPresent(String dictionary[],String str){
	    for(int i=0;i<dictionary.length;i++)
	        if(str.equals(dictionary[i]))
	            return true;
	   return false;
	}
}
