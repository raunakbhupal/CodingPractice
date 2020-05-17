import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();
	
    static void swap(int a[],int i,int j)
    {
	    int t=a[i];
	    a[i]=a[j];
	    a[j]=t;
    }
    private static int[] partition3(int[] a, int l, int r) {
	    int m2=l-1; //m2 is at starting less than m1 but after this function m2 will be greater than m1
     	    int m1=r;
	    int p=l-1,q=r;
	    int x=a[r];
	    while(true)
	    {
		    while(a[++m2]<x); //From left finding first element >= x
		    while(x<a[--m1])  //From right finding first element <=x
		    	if(m1==l)
				break;
		    if(m2>=m1)
			    break;
		    swap(a,m2,m1); //Swap so that smaller goes on left and larger on right

		    //Move all same left occurence of pivot to the beginning and keep count using p
		    if(a[m2]==x)
		    {
			    p++;
			    swap(a,p,m2);
		    }

		    //Move all same right occurence of pivot to end and keep count using q
		    if(a[m1]==x)
		    {
			    q--;
			    swap(a,m1,q);
		    }
	    }
	    //Move pivot element to its correct index
	    swap(a,m2,r);
	    //Move all same left occurences from beginning to adjacent to a[m2]
	    m1=m2-1;
	    for(int i=l;i<p;i++,m1--)
		    swap(a,i,m1);
	    //Move all same right occurences from end to adjacent to a[m2]
	    m2=m2+1;
	    for(int i=r-1;i>q;i--,m2++)
	  	    swap(a,m2,i);
      int[] m = {m1, m2};
      return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
	int m[]=partition3(a,l,r);
        //int m = partition2(a, l, r);
        randomizedQuickSort(a, l, m[0]); //Do m-1 here and m+1 below when using 2 way partition
        randomizedQuickSort(a, m[1], r);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
