import java.util.*;

public class Kruskal
{
	public int arr[];
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Kruskal obj=new Kruskal();
		int wt[][]=new int[10][10];
	//	int visited[]=new int[10];
		int i,j;
		System.out.println("Enter number of vertices");
		int n=sc.nextInt();
	//	for(i=0;i<n;i++)
	//		visited[i]=0;
		System.out.println("Enter the weighted matrix");
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
				wt[i][j]=sc.nextInt();
//		System.out.println("Enter the source vertex");
//		int s=sc.nextInt();
		int temp[][]=new int[10][10];
		System.arraycopy(wt,0,temp,0,n);
		int weight=obj.kruskalCheck(temp,n);
		System.out.println("The matrix is :");
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
				System.out.print(wt[i][j]+" ");
			System.out.println();
		}
		System.out.println("The minimum weight is: "+weight);
	}
	int kruskalCheck(int temp[][],int n)
	{
		int k=0,min,sum=0,a=0,b=0;
		int i,j;
		arr=new int[10];
		System.out.println("The edges picked up are : ");
		while(k<n-1)
		{
			min=999;
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
				{
					if(i!=j&&temp[i][j]<min)
					{
						min=temp[i][j];
						a=i;
						b=j;
					}
				}
			}
			i=find(a);
			j=find(b);
			if(i!=j)
			{
				union(i,j);
				System.out.println("("+a+","+b+")"+"->"+temp[a][b]);
				sum+=temp[a][b];
				k++;
			}
			temp[a][b]=999;
//			k++;
		}
		return sum;
	}
	int find(int p)
	{
		while(arr[p]!=0)
			p=arr[p];
		return p;
	}	
	void union(int i,int j)
	{
		if(i<j)
			arr[i]=j;
		else
			arr[j]=i;
	}
}	
