// User function Template for Java

/*
*  g[]: adj list of the graph
*  N : number of vertices
*/
class Traversal {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        // add your code here
        boolean visited[]=new boolean[N];
        int s=0;
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> res=new ArrayList<>(N);
//         for(int i=0;i<N;i++)
// 			res.add(new ArrayList<Integer>());
        q.add(s);
        visited[s]=true;
        while(!q.isEmpty())
        {
            int v=q.poll();
            res.add(v);
            for(int u:g.get(v)){
                if(!visited[u]){
                    q.add(u);
                    visited[u]=true;
                }
            }
        }
        return res; 
        
    }
}
