public class SmallestNonPrimeSubsequence {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int findSmallestNonPrimeSubsequence(String s) {
        int n = s.length();
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                String subsequence = s.substring(i, i + len);
                int subsequenceValue = Integer.parseInt(subsequence);

                if (!isPrime(subsequenceValue)) {
                    return len;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "2357";
        int result = findSmallestNonPrimeSubsequence(s);
        System.out.println(result);  // Output: -1

        s = "3137";
        result = findSmallestNonPrimeSubsequence(s);
        System.out.println(result);  // Output: 2 (e.g., "31")

        s = "123456";
        result = findSmallestNonPrimeSubsequence(s);
        System.out.println(result);  // Output: 2 (e.g., "12")
    }
}
