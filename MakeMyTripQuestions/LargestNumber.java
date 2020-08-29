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
		    Vector<String> a=new Vector<>();
		    for(int i=0;i<n;i++)
		        a.add(Integer.toString(sc.nextInt()));
		    printLargest(a);
		    System.out.println();
		}
	}
	static void printLargest(Vector<String> a){
	    Collections.sort(a,new Comparator<String>(){
	        public int compare(String x,String y){
	            String xy=x+y;
	            String yx=y+x;
	            return xy.compareTo(yx)>0?-1:1;
	        }
	    });
	    Iterator it=a.iterator();
	    while(it.hasNext())
	        System.out.print(it.next());
	}
}
