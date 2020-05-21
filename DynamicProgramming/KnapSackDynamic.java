import java.util.*;

public class KnapSackDynamic
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter KnapSack Capacity");
		int capacity=sc.nextInt();
		System.out.println("Enter number of elements");
		int n=sc.nextInt();
		ArrayStructure a[]=new ArrayStructure[n+1];
		KnapSackDynamic obj=new KnapSackDynamic();
		for(int i=1;i<=n;i++)
		{
			a[i]=new ArrayStructure();
			System.out.println("Enter weight "+i);
			a[i].weight=sc.nextInt();
			System.out.println("Enter price "+i);
			a[i].price=sc.nextInt();
		}
		obj.displayArrayDetails(a,n);
		int profit=obj.KnapSack(a,n,capacity);
		System.out.println("The maximum profit for KnapSack 0/1 by Dynamic Programming is "+profit);
	}
	void displayArrayDetails(ArrayStructure a[],int n)
	{
		for(int i=1;i<=n;i++)
			System.out.println("Weight: "+a[i].weight+"\tPrice: "+a[i].price);
	}
	int KnapSack(ArrayStructure a[],int n,int capacity)
	{
		int val[][]=new int[n+2][capacity+2];
		int i,j;
		for(i=0;i<=n;i++)
		{
			for(j=0;j<=capacity;j++)
			{
				if(i==0||j==0)
					val[i][j]=0;
				else if(a[i].weight>j)
					val[i][j]=val[i-1][j];
				else
					val[i][j]=Math.max(val[i-1][j],val[i-1][j-a[i].weight]+a[i].price);
			}
		}
		i=n;
		j=capacity;
		System.out.println("Elements picked are");
		while(i>0&&j>0)
		{
			if(val[i][j]!=val[i-1][j])
			{	
				System.out.println(i);
				j=j-a[i].weight;
				i--;
			}	
			else 
				i--;
		}
		return val[n][capacity];
	}
}

class ArrayStrucutre
{
	int weight;
	int price;
}
