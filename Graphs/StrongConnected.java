import java.util.*;
import java.io.*;
import java.lang.*;

public class StrongConnected
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
		strongConnected(adj,n);
	}

	static void strongConnected(ArrayList<ArrayList<Integer>> adj,int size)
	{
		boolean visited[]=new boolean[size];
		Stack<Integer> stk =new Stack<Integer>();

		//fill vertices in stack according to their finishing time(as did in topological sort)
		for(int i=0;i<size;i++)
		{
			if(!visited[i])
				fillStack(i,adj,visited,stk);
		}

		ArrayList<ArrayList<Integer>> adj1=new ArrayList<ArrayList<Integer>>(adj.size());
		for(int i=0;i<adj.size();i++)
			adj1.add(new ArrayList<Integer>());

		//create reversed graph
		adj1=reverseGraph(adj,adj1,size);

		//mark the visited as false for the reversed graph
		for(int i=0;i<size;i++)
			visited[i]=false;

		int c=0;

		while(!stk.empty())
		{
			int n=stk.pop();
			if(!visited[n])
			{
				//find strongly connected components
				recDFS(n,visited,adj1);
				c++; //count of strongly connected components
			}
		}
		System.out.println(c);
	}

	static void fillStack(int i,ArrayList<ArrayList<Integer>> adj,boolean visited[],Stack<Integer> stk)
	{
		visited[i]=true;
		Iterator<Integer> itr=adj.get(i).listIterator();
		while(itr.hasNext())
		{
			int n=itr.next();
			if(!visited[n])
				fillStack(n,adj,visited,stk);
		}
		stk.push(i);
	}

	static ArrayList<ArrayList<Integer>> reverseGraph(ArrayList<ArrayList<Integer>> adj,ArrayList<ArrayList<Integer>> adj1,int size)
	{
		for(int i=0;i<size;i++)
		{
			Iterator<Integer> itr=adj.get(i).listIterator();
			while(itr.hasNext())
			{
				int n=itr.next();
				adj1.get(n).add(i);
			}
		}
		return adj1;
	}

	static void recDFS(int i,boolean visited[],ArrayList<ArrayList<Integer>> adj1)
	{
		visited[i]=true;
		Iterator<Integer> itr=adj1.get(i).listIterator();
		while(itr.hasNext())
		{
			int n=itr.next();
			if(!visited[n])
				recDFS(n,visited,adj1);
		}
	}
}
