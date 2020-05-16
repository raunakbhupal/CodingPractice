import java.util.*;

public class LargestNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> l1=new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            l1.add(i,sc.next());
        }
	Collections.sort(l1,(a,b)->(b+a).compareTo(a+b));
        l1.stream().forEach(System.out::print);
    }
}
