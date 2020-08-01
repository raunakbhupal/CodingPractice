import java.util.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    int n = sc.nextInt();
		    int[] a = new int[n];
		    for(int i=0;i<n;i++) {
		        a[i] = sc.nextInt();
		    }
		    
		    printPreorder(a, 0, n-1);
		    System.out.println();
		}
	}
	
	static void printPreorder(int[] a, int start, int end) {
	    if(start>end)
	        return;
	        
	    int mid = (start+end)/2;
	    //mid = mid+start;
	    System.out.print(a[mid]+" ");
	    printPreorder(a, start, mid-1);
	    printPreorder(a, mid+1, end);
	}
}
