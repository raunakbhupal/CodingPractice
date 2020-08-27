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
		    int e=sc.nextInt();
		    ArrayList<Stack<Integer>> l1=new ArrayList<Stack<Integer>>();
		    ArrayList<Queue<Integer>> l2=new ArrayList<Queue<Integer>>();
		    for(int i=0;i<=n;i++){
		        l1.add(new Stack<Integer>());
		        l2.add(new LinkedList<Integer>());
		    }
		    for(int i=0;i<e;i++){
		        int x=sc.nextInt();
		        int y=sc.nextInt();
		        l1.get(x).push(y);
		    }
		    for(int i=0;i<e;i++){
		        int x=sc.nextInt();
		        int y=sc.nextInt();
		        l2.get(x).offer(y);
		    }
		    boolean flag=true;
		    for(int i=1;i<=n;i++){
		        Stack<Integer> s=l1.get(i);
		        Queue<Integer> q=l2.get(i);
		        while(!s.isEmpty()&&!q.isEmpty()){
		            if(s.peek()!=q.peek()){
		                flag=false;
		                break;
		            }
		            s.pop();
		            q.poll();
		        }
		        if(flag==false)
		            break;
		    }
		    if(flag)
		        System.out.println("1");
		    else
		        System.out.println("0");
	    }
	}
	
}
