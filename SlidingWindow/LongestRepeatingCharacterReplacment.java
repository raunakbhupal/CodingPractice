class Solution {
    public int characterReplacement(String s, int k) {
       HashMap<Character, Integer> count = new HashMap<>();
       int i = 0, maxFreq = 0, ans = 0;
       for (int j = 0; j < s.length(); j++) {
           count.put(s.charAt(j), 1 + count.getOrDefault(s.charAt(j), 0));
           maxFreq = Math.max(maxFreq, count.get(s.charAt(j)));
           while (((j - i + 1) - maxFreq) > k) {
               count.put(s.charAt(i), count.get(s.charAt(i)) - 1);
               i++;
           }

           ans = Math.max(ans, j - i + 1);
       }
       return ans; 
    }
}

// Another Way is without using HashMap

class Solution {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int i = 0, j = 0, ans = 0, N = s.length();
        
        while (j < N) {
            cnt[s.charAt(j++) - 'A']++;
            
            while (j - i - maxElement(cnt) > k) {
                cnt[s.charAt(i++) - 'A']--;
            }
            
            ans = Math.max(ans, j - i);
        }
        
        return ans;
    }
    
    private int maxElement(int[] arr) {
        int max = 0;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }
}
