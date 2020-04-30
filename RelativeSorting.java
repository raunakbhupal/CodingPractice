

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int a1[]=new int[n];
		    int a2[]=new int[m];
		    for(int i=0;i<n;i++)
		        a1[i]=sc.nextInt();
		    for(int i=0;i<m;i++)
		        a2[i]=sc.nextInt();
		    HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
		    for(int i=0;i<n;i++){
		        if(!h.containsKey(a1[i]))
		            h.put(a1[i],1);
		        else
		            h.put(a1[i],h.get(a1[i])+1);
		    }
		    for(int i=0;i<m;i++){
		        if(h.containsKey(a2[i])){
		            int c=h.get(a2[i]);
		            while(c-->0)
		                System.out.print(a2[i]+" ");
		            h.remove(a2[i]);
		        }
		    }
		    if(h.size()>0){
		        ArrayList<Integer> a=new ArrayList<Integer>();
		        for(int i=0;i<n;i++){
		            if(h.containsKey(a1[i]))
		                a.add(a1[i]);
		        }
		        Collections.sort(a);
		        for(int i=0;i<a.size();i++)
		            System.out.print(a.get(i)+" ");
		    }
		    System.out.println();
		}
	}
}
