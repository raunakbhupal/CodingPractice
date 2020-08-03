import java.util.*;

public class Floyd
{
	public static void main(String args[])
	{
		Floyd obj=new Floyd();
		Scanner sc=new Scanner(System.in);
		int wt[][]=new int[10][10];
		System.out.println("Enter number of vertices");
		int n =sc.nextInt();
		System.out.println("Enter weighted matrix");
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				wt[i][j]=sc.nextInt();
		obj.FloydCheck(wt,n);
	}
	void FloydCheck(int wt[][],int n)
	{
		int i,j,k;
		for(k=1;k<=n;k++)
		{
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=n;j++)
				{
					wt[i][j]=Math.min(wt[i][j],wt[i][k]+wt[k][j]);
				}
			}
			displayFloyd(wt,k,n);
		}
	}
	void displayFloyd(int wt[][],int k,int n)
	{
		int i,j;
		System.out.println("For node : "+k);
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
				System.out.print(wt[i][j]+"\t");
			System.out.println();
		}
	}
}
