import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w,int n) {
        int val[][]=new int[n+1][W+1];
	for(int i=0;i<=n;i++)
	{
		for(int j=0;j<=W;j++)
		{
			if(i==0||j==0)
				val[i][j]=0;
			else if(w[i]>j)
				val[i][j]=val[i-1][j];
			else
				val[i][j]=Math.max(val[i-1][j],val[i-1][j-w[i]]+w[i]);
		}
	}
	return val[n][W];
        /*int result = 0;
        for (int i = 0; i < w.length; i++) {
          if (result + w[i] <= W) {
            result += w[i];
          }
        }
        return result;*/
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n+1];
        for (int i = 1; i <=n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w,n));
    }
}
