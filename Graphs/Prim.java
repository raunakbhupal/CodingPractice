import java.util.*;

public class Prim
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Prim obj=new Prim();
		int wt[][]=new int[10][10];
		int visited[]=new int[10];
		int i,j;
		System.out.println("Enter number of vertices");
		int n=sc.nextInt();
		for(i=0;i<n;i++)
			visited[i]=0;
		System.out.println("Enter the weighted matrix");
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
				wt[i][j]=sc.nextInt();
		System.out.println("Enter the source vertex");
		int s=sc.nextInt();
		int weight=obj.PrimCheck(wt,visited,n,s);
		System.out.println("The minimum weight is: "+weight);
	}
	int PrimCheck(int wt[][],int visited[],int n,int s)
	{
		int k=0,min,sum=0,a=s,b=s;
		int i,j;
		System.out.println("The nodes picked up are : ");
		visited[s]=1;
		while(k<n-1)
		{
			min=999;
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
				{
					if(visited[i]==1&&visited[j]==0)
					{
						if(i!=j&&wt[i][j]<min)
						{
							min=wt[i][j];
							a=i;
							b=j;
						}
					}
				}
			}
			visited[b]=1;
			sum+=min;
			System.out.println(a+"->"+b+"="+min);
			k++;
		}
		return sum;
	}
}	
