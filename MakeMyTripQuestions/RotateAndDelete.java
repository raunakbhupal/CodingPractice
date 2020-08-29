import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    ArrayList<Integer> a=new ArrayList<Integer>();
		    for(int i=0;i<n;i++)
		        a.add(sc.nextInt());
		    int i=1;
		    while(i<n/2+1){
		        Collections.rotate(a,1);
		        a.remove(a.size()-i);
		        i++;
		    }
		    System.out.println(a.get(0));
		}
	}
}
