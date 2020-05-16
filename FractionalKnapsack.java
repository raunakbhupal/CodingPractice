import java.util.Scanner;

public class FractionalKnapsack {
	private static int min(int a,int b)
	{
		if(a<b)
			return a;
		return b;
	}

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
	int a;
	for(int i=0;i<values.length;i++)
	{
		if(capacity==0)
			break;
		int pos=0;
		double max=0.0;
		for(int j=0;j<values.length;j++)
		{
			if(weights[j]>0&&((double)values[j]/weights[j])>max)
			{
				pos=j;
				max=(double)values[j]/weights[j];
			}
		}
		a=min(weights[pos],capacity);
		value=value+(a*max);
		weights[pos]-=a;
		capacity-=a;
	}
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
