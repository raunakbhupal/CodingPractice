/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    int v;
    List<List<Integer>> adj;
    
    GFG(int v){
        this.v=v;
        adj=new ArrayList<>(v);
        for(int i=0;i<v;i++)
            adj.add(i,new ArrayList<>());
    }
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    int a[][]=new int[n][n];
		    for(int i=0;i<n;i++)
		        for(int j=0;j<n;j++)
		            a[i][j]=sc.nextInt();
		    System.out.println(checkPath(a,n));
		}
	}
	static int checkPath(int a[][],int n){
	    int s=-1,d=-1;
	    int v=n*n+2;
	    GFG g=new GFG(v);
	    int k=1;
	    for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            if(a[i][j]!=0){
	                if(isSafe(i,j+1,a))
	                    g.addEdge(k,k+1);
	                if(isSafe(i,j-1,a))
	                    g.addEdge(k,k-1);
	                if(i<n-1&&isSafe(i+1,j,a))
	                    g.addEdge(k,k+n);
	                if(i>0&&isSafe(i-1,j,a))
	                    g.addEdge(k,k-n);
	            }
	            if(a[i][j]==1)
	                s=k;
	            if(a[i][j]==2)
	                d=k;
	            k++;
	        }
	    }
	    return g.BFS(s,d);
	}
	static boolean isSafe(int i,int j,int a[][]){
	    int n=a.length;
	    if(i<0||i>=n||j<0||j>=n||a[i][j]==0)
	        return false;
	    return true;
	}
	void addEdge(int s,int d){
	    adj.get(s).add(d);
	}
	int BFS(int s,int d){
	    if(s==d)
	        return 1;
	    boolean visited[]=new boolean[v];
	    Queue<Integer> q=new LinkedList<>();
	    visited[s]=true;
	    q.add(s);
	    while(!q.isEmpty()){
	        int node=q.poll();
	        Iterator<Integer> itr=adj.get(node).listIterator();
	        while(itr.hasNext()){
	            int u=itr.next();
	            if(u==d)
	                return 1;
	            if(!visited[u]){
	                visited[u]=true;
	                q.add(u);
	            }
	        }
	    }
	    return 0;
	}
}
