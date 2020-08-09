import java.util.*;

public class Bipartite {
    private static int isBipartiteUtil(ArrayList<ArrayList<Integer>> adj,int src,int color[]) {
       
	color[src]=1;
	Queue<Integer> q= new LinkedList<>();
	q.add(src);
	while(!q.isEmpty()){
		int u=q.poll();
		Iterator<Integer> itr = adj.get(u).listIterator();
		while(itr.hasNext()){
			int v=itr.next();
			if(u==v)
				return 0;
			if(color[v]==-1){
				//assign alternate color
				color[v]=1-color[u];
				q.add(v);
			}
			else if(color[v]==color[u])
				return 0;
		}
	}
        return 1;
    }

    public static int isBipartite(ArrayList<ArrayList<Integer>> adj){

	//color -1 indicates no color, color 1 indicates first color and color 0 indicates 2nd color
	int color[]=new int[adj.size()];
	for(int i=0;i<adj.size();i++)
		color[i]=-1;
	for(int i=0;i<adj.size();i++){
		if(color[i]==-1)
			if(isBipartiteUtil(adj,i,color)==0)
				return 0;
	}
	return 1;
    }

    
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();
	    adj.get(x-1).add(y-1);
	    adj.get(y-1).add(x-1);
        }
        System.out.println(isBipartite(adj));
    }
}
