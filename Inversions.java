import java.util.*;

public class Inversions {

    /*private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        //write your code here
        return numberOfInversions;
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
	}
	System.out.println(MergeSort(a,0, a.length-1));
    }

    static int MergeSort(int a[],int l ,int r)
    {
	int count=0;
	if(l<r)
	{
		int m=(l+r)/2;
		//Total count=count on left half+count on right half+merge count
		count+=MergeSort(a,l,m);
		count+=MergeSort(a,m+1,r);
		count+=Merge(a,l,r,m);
	}
	return count;
    }

    static int Merge(int a[],int l,int r,int m)
    {
	    int left[]=Arrays.copyOfRange(a,l,m+1);
	    int right[]=Arrays.copyOfRange(a,m+1,r+1);
	    int i=0,j=0,k=l,count=0;
	    while(i<left.length&&j<right.length)
	    {
		    if(left[i]<=right[j])
			    a[k++]=left[i++];
		    else
		    {
			    a[k++]=right[j++];
			    count+=(m+1)-(l+i);  //Logic:if a[i]>a[j] then all elements from a[i+1]...a[m] will be greater than a[j]
			    			//Thats why there will be a total of m-i inversions 
		    }
	    }
	    while(i<left.length)
		    a[k++]=left[i++];
	    while(j<right.length)
		    a[k++]=right[j++];
	    return count;
    }
}
