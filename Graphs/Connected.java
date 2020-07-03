import java.util.*;
import java.io.*;

public class Connected
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
			adj.get(y-1).add(x-1);
		}
		System.out.println(numberComponents(adj));
	}

	public static int numberComponents(ArrayList<ArrayList<Integer>> adj)
	{
		boolean visited[]=new boolean[adj.size()];
		int ccnum[]=new int[adj.size()];
		int cc=0;
		for(int i=0;i<adj.size();i++)
		{
			if(!visited[i])
			{
				explore(adj,i,visited,cc,ccnum);
				cc+=1;
			}
		}
		return cc;
	}

	public static void explore(ArrayList<ArrayList<Integer>> adj,int v,boolean visited[],int cc,int ccnum[])
	{
		visited[v]=true;
		ccnum[v]=cc;	
		Iterator<Integer> i;
		i=adj.get(v).listIterator();
		while(i.hasNext())
		{
			int w=i.next();
			if(!visited[w])
				explore(adj,w,visited,cc,ccnum);
		}
	}
}
