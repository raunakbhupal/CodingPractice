import java.util.*;
import java.io.*;

public class Acyclicity
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
		System.out.println(isCyclic(adj));
	}

	static int isCyclic(ArrayList<ArrayList<Integer>> adj)
	{
		boolean visited[]=new boolean[adj.size()];
		//add a recursion stack too
		boolean recStack[]=new boolean[adj.size()];
		for(int i=0;i<adj.size();i++)
			if(isCyclicCheck(i,adj,visited,recStack))
					return 1;
		return 0;
	}

	static boolean isCyclicCheck(int i,ArrayList<ArrayList<Integer>> adj,boolean visited[],boolean recStack[])
	{
		if(recStack[i])
			return true;
		if(visited[i])
			return false;
		visited[i]=true;
		recStack[i]=true;
		List<Integer> children=adj.get(i);
		for(Integer a:children)
			if(isCyclicCheck(a,adj,visited,recStack))
				return true;
		recStack[i]=false;
		return false;
	}
}
