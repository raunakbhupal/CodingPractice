import java.util.*;
import java.io.*;

public class ChangeDP {

	//See notes for explanation
    private static int getChange(int m,int coins[]) {
    	int minCoins[]=new int[m+1];
	int numCoins;
	for(int i=1;i<=m;i++){
		minCoins[i]=Integer.MAX_VALUE;
		for(int j=0;j<coins.length;j++){
			if(i>=coins[j]){
				numCoins=minCoins[i-coins[j]]+1;
				if(numCoins<minCoins[i])
					minCoins[i]=numCoins;
			}
		}
	}
	return minCoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
	int coins[]={1,3,4};
    	System.out.println(getChange(m,coins));

    }
}
