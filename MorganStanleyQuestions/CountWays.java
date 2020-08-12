/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    ways(n);
		}
	}
	static void ways(int n){
	    BigInteger res[]=new BigInteger[n+1];
	    BigInteger A=BigDecimal.valueOf(Math.ceil(Math.pow(10,9))+7).toBigInteger();
	    res[0]=BigInteger.valueOf(1);
	    res[1]=BigInteger.valueOf(1);
	    for(int i=2;i<=n;i++){
	        res[i]=(res[i-1].add(res[i-2])).mod(A);
	       // res[i]=BigInteger.valueOf(0);
	       // for(int j=1;j<=2&&j<=i;j++)
	       //     res[i]=(res[i].add(res[i-j])).mod(A);
	    }
	    //BigInteger A=BigDecimal.valueOf(Math.ceil(Math.pow(10,9))+7).toBigInteger();
	    System.out.println(res[n]);
	}
}
