/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int l=sc.nextInt();
		    int r=sc.nextInt();
		    System.out.println(maxFreqDigit(l,r));
		}
	}
	static int maxFreqDigit(int l,int r){
	    boolean prime[]=new boolean[r+1];
	    findPrime(prime,r);
	    int g=0;
	    int freq[]=new int[10];
	    for(int i=l;i<=r;i++){
	        if(!prime[i]){
	            g=1;
	            int p=i;
	            while(p>0){
	                freq[p%10]++;
	                p/=10;
	            }
	        }
	    }
	    if(g==0)
	        return -1;
	    int max=freq[0],pos=0;
	    for(int i=1;i<10;i++){
	        if(freq[i]>=max){
	            max=freq[i];
	            pos=i;
	        }
	    }
	    return pos;
	}
	static void findPrime(boolean prime[],int r){
	    for(int p=2;p*p<=r;p++){
	        if(prime[p]==false){
	            for(int i=p*2;i<=r;i+=p){
	                prime[i]=true;
	            }
	        }
	    }
	}
}
