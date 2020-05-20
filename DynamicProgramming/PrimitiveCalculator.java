import java.util.*;

public class PrimitiveCalculator {

    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
	HashMap<Integer,Integer> map=new HashMap<>();
	map.put(0,0);
	int i=1,v3,v2,v1;
	while(i<=n){
		if(i%3==0)
			v3=map.get(i/3);
		else
			v3=n;
		if(i%2==0)
			v2=map.get(i/2);
		else
			v2=n;
		v1=map.get(i-1);
		int val;
		if(v3<=v2&&v3<=v1)
			val=i/3;
		else if(v2<=v3&&v2<=v1)
			val=i/2;
		else
			val=i-1;
		int min=map.get(val)+1;
		map.put(i,min);
		i++;
	}
	while(n>0){
		sequence.add(n);
		if(n%3==0)
			v3=map.get(n/3);
		else
			v3=n;
		if(n%2==0)
			v2=map.get(n/2);
		else

			v2=n;
		v1=map.get(n-1);
		if(v3<=v2&&v3<=v1)
			n/=3;
		else if(v2<=v3&&v2<=v1)
			n/=2;
		else
			n-=1;
	}
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
