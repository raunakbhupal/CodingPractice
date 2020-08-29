class GfG {
    public int maxArea(int M[][], int m, int n) {
        int res=maxHist(M[0],n);
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(M[i][j]==1)
                    M[i][j]+=M[i-1][j];
                
            }
            res=Math.max(res,maxHist(M[i],n));
        }
        return res;
    }
    int maxHist(int row[],int n){
        Stack<Integer> s=new Stack<>();
        int max=0;
        int top,area_top,i=0;
        while(i<n){
            if(s.empty()||row[s.peek()]<=row[i])
                s.push(i++);
            else{
                top=s.pop();
                area_top=row[top]*(s.empty()?i:i-s.peek()-1);
                max=Math.max(max,area_top);
            }
        }
        while(!s.empty()){
            top=s.pop();
            area_top=row[top]*(s.empty()?i:i-s.peek()-1);
            max=Math.max(max,area_top);
        }
        return max;
    }
}
