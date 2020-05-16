import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int k,i;
	for(k=n,i=1;k>0;i++)
	{
		if(k<=2*i)
		{
			summands.add(k);
			k-=k;
		}
		else
		{
			summands.add(i);
			k-=i;
		}
	}
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}
