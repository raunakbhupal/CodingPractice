import java.util.*;
import java.io.*;

public class Toposort
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(n);
		for(int i=0;i<n;i++)
			adj.add(new ArrayList<Integer>());
		for(int i=0;i<m;i++)
		{
			int x,y;
			x=sc.nextInt();
			y=sc.nextInt();
			adj.get(x-1).add(y-1);
		}
		toposort(adj);
	}

	static void toposort(ArrayList<ArrayList<Integer>> adj)
	{
		Stack<Integer> stk=new Stack<Integer>();
		boolean visited[]=new boolean[adj.size()];
		for(int i=0;i<adj.size();i++)
			if(!visited[i])
				recToposort(i,adj,stk,visited); //call a recursive toposort function
		while(!stk.empty())
			System.out.print((stk.pop()+1)+" ");
		System.out.println();
	}

	static void recToposort(int i,ArrayList<ArrayList<Integer>> adj,Stack<Integer> stk,boolean visited[])
	{
		visited[i]=true;
		Iterator<Integer> itr=adj.get(i).listIterator();
		while(itr.hasNext())
		{
			int n=itr.next();
			if(!visited[n])
				recToposort(n,adj,stk,visited);
		}
		stk.push(i);
	}
}
