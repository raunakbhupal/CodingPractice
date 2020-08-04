import java.util.*;
import java.io.*;

public class HelloWorld{

     public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    a[i][j]=sc.nextInt();
            findLongestPath(a,n);
        }
     }
     
    static void findLongestPath(int a[][],int n){
        int dp[][]=new int[n][n];
        int result=1;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dp[i][j]=-1;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]==-1)
                    dp[i][j]=findLongestFromACell(i,j,a,dp,n);
                result=Math.max(result,dp[i][j]);
            }
        }
        System.out.println(result);
    } 
    
    static int findLongestFromACell(int i,int j,int a[][],int dp[][],int n){
        if(i<0||i>=n||j<0||j>=n)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int x=Integer.MIN_VALUE;
        int y=Integer.MIN_VALUE;
        int z=Integer.MIN_VALUE;
        int w=Integer.MIN_VALUE;
        
        if(j<n-1 && (a[i][j]+1==a[i][j+1]))
            x=dp[i][j]=1+findLongestFromACell(i,j+1,a,dp,n);
        if(j>0 && (a[i][j]+1==a[i][j-1]))
            y=dp[i][j]=1+findLongestFromACell(i,j-1,a,dp,n);
        if(i>0 && (a[i][j]+1==a[i-1][j]))
            z=dp[i][j]=1+findLongestFromACell(i-1,j,a,dp,n);
        if(i<n-1 && (a[i][j]+1==a[i+1][j]))
            w=dp[i][j]=1+findLongestFromACell(i+1,j,a,dp,n);
        
        dp[i][j]=Math.max(x,Math.max(y,Math.max(z,Math.max(w,1))));
        return dp[i][j];
    }
}
