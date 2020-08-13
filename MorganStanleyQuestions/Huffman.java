/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class HuffmanNode{
    int data;
    char ch;
    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode>{
    public int compare(HuffmanNode x,HuffmanNode y){
        return x.data-y.data;
    }
}

public class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    String s=sc.next();
		    int n=s.length();
		    int freq[]=new int[n];
		    for(int i=0;i<n;i++)
		        freq[i]=sc.nextInt();
		    char ch[]=s.toCharArray();
		    PriorityQueue<HuffmanNode> pq=new PriorityQueue<HuffmanNode>(n,new MyComparator());
		    for(int i=0;i<n;i++){
		        HuffmanNode hn=new HuffmanNode();
		        hn.data=freq[i];
		        hn.ch=ch[i];
		        hn.left=null;
		        hn.right=null;
		        pq.add(hn);
		    }
		    HuffmanNode root=null;
		    while(pq.size()>1){
		        HuffmanNode x=pq.peek();
		        pq.poll();
		        HuffmanNode y=pq.peek();
		        pq.poll();
		        HuffmanNode newNode=new HuffmanNode();
		        newNode.data=x.data+y.data;
		        newNode.ch='-';
		        newNode.left=x;
		        newNode.right=y;
		        root=newNode;
		        pq.add(newNode);
		    }
		    printCode(root,"");
		    System.out.println();
		}
	}
	static void printCode(HuffmanNode root,String s){
	    if(root.left==null&&root.right==null&&Character.isLetter(root.ch)){
	        System.out.print(s+" ");
	        return;
	    }
	    printCode(root.left,s+"0");
	    printCode(root.right,s+"1");
	}
}
