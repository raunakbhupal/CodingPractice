import java.util.*;

public class PlacingParentheses {
	static long[] MinAndMax(int i,int j,long m[][],long M[][],char op[])
	{
		long min=Integer.MAX_VALUE;
		long max=Integer.MIN_VALUE;
		for(int k=i;k<=j-1;k++)
		{
			long a=eval(M[i][k],M[k+1][j],op[k]);
			long b=eval(M[i][k],m[k+1][j],op[k]);
			long c=eval(m[i][k],M[k+1][j],op[k]);
			long d=eval(m[i][k],m[k+1][j],op[k]);
			min=Math.min(min,Math.min(a,Math.min(b,Math.min(c,d))));
			max=Math.max(max,Math.max(a,Math.max(b,Math.max(c,d))));
		}
		long a[]=new long[2];
		a[0]=min;
		a[1]=max;
		return a;
	}
    private static long getMaximValue(char c1[]) {
      		
	    int length=c1.length;
	    int d[]=new int[length/2+3];
	    char op[]=new char[length/2+2];
	    int j=1;
	    for(int i=0;i<length-1;i+=2)
      	    {
		    d[j]=(int)(c1[i])-48;
		    op[j]=c1[i+1];
		    j++;
	    }
	    d[j]=(int)(c1[length-1])-48;
	    long m[][]=new long[length/2+3][length/2+3];
	    long M[][]=new long[length/2+3][length/2+3];
	    for(int i=1;i<=length/2+1;i++)
	    {
		    m[i][i]=d[i];
		    M[i][i]=d[i];
	    }
	    j=0;
	    long a[]=new long[2];
	    for(int s=1;s<=length/2;s++)
	    {
		    for(int i=1;i<=length/2+1-s;i++)
		    {
			j=i+s;
			a=MinAndMax(i,j,m,M,op);
			m[i][j]=a[0];
			M[i][j]=a[1];
		    }
	    }
	    return M[1][length/2+1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
	char c1[]=exp.toCharArray();
        System.out.println(getMaximValue(c1));
    }
}
