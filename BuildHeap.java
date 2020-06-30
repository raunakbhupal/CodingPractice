import java.util.*;

public class BuildHeap1
{
	//ArrayList<Integer> arr=new ArrayList<Integer>();
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		ArrayList<Integer> arr=new ArrayList<Integer>(n);
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		BuildHeap1 bh=new BuildHeap1();
		bh.solve(a,n,arr);
	}

	void solve(int a[],int n,ArrayList<Integer> arr)
	{
		generateSwaps(a,n,arr);
		writeOutput(a,n,arr);
	}

	void generateSwaps(int a[],int n,ArrayList<Integer> arr)
	{
		repairHeap(a,n,arr);
	}

	void repairHeap(int a[],int n,ArrayList<Integer> arr)
	{
		int j=n/2;
		for(int i=j;i>0;i--)
			SiftDown(a,i,n,arr);
	}

	void SiftDown(int a[],int i,int n,ArrayList<Integer> arr)
	{
		int minIndex=i;
		int l=leftChild(i);
		if(l<n&&a[l]<a[minIndex])
			minIndex=l;
		int r=rightChild(i);
		if(r<n&&a[r]<a[minIndex])
			minIndex=r;
		if(i!=minIndex)
		{
			arr.add(i,minIndex);
			int t=a[i];
			a[i]=a[minIndex];
			a[minIndex]=t;
			SiftDown(a,minIndex,n,arr);
		}
	}

	int leftChild(int i)
	{
		return 2*i+1;
	}

	int rightChild(int i)
	{
		return 2*i+2;
	}

	void writeOutput(int a[],int n,ArrayList<Integer> arr)
	{
		System.out.println(arr.size());
		arr.forEach((i)->print(i));
		/*for(int i=0;i<arr.size()-1;i+=2)
		{
			System.out.println(arr.get(i)+" "+arr.get(i+1));
		}*/
	}
}
