//2024. Maximize the Confusion of an Exam
// Both solutions are correct, the commented one too, that is with HashMap and the other is without HashMap

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // HashMap<Character, Integer> map = new HashMap<>();
        // int i = 0, maxFreq = 0, ans = 0;
        // for (int j = 0; j < answerKey.length(); j++) {
        //     map.put(answerKey.charAt(j), 1 + map.getOrDefault(answerKey.charAt(j), 0));
        //     maxFreq = Math.max(maxFreq, map.get(answerKey.charAt(j)));
        //     while (j-i+1 - maxFreq > k) {
        //         map.put(answerKey.charAt(i), map.get(answerKey.charAt(i)) - 1);
        //         i++;
        //     }
        //     ans = Math.max(ans, j-i+1);
        // }
        // return ans;
    return Math.max(count('T', answerKey, k), count('F', answerKey, k));
    }

    private int count(char c, String s, int k) {
        int N = s.length(), cnt = 0, i = 0, ans = 0;
        
        for (int j = 0; j < N; ++j) {
            if (s.charAt(j) == c) {
                cnt++;
            }
            
            while (cnt > k) {
                if (s.charAt(i) == c) {
                    cnt--;
                }
                i++;
            }
            
            ans = Math.max(ans, j - i + 1);
        }
        
        return ans;
    }
}
