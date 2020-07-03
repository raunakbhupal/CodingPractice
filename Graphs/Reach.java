import java.util.*;
import java.io.*;

public class Reach
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
		int x=sc.nextInt()-1;
		int y=sc.nextInt()-1;
		System.out.println(isReachable(adj,x,y));
	}

	//implemented using dfs
	public static int isReachable(ArrayList<ArrayList<Integer>> adj,int x,int y)
	{
		boolean visited[]=new boolean[adj.size()];
		visited[x]=true;
		Stack<Integer> stk=new Stack<Integer>();
		stk.push(x);
		Iterator<Integer> i;  //used to get adjacent vertices
		while(!stk.empty())
		{
			int s=stk.pop();
			i=adj.get(s).listIterator();
			while(i.hasNext())
			{
				int n=i.next();
				if(n==y)
					return 1;
				if(!visited[n])
				{
					visited[n]=true;
					stk.push(n);
				}
			}
		}
		return 0;
	}
}
