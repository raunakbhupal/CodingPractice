class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int n = s.length(), ans = 0;
        // Map<Character, Integer> map = new HashMap<>(); // current index of character
        // // try to extend the range [i, j]
        // for (int j = 0, i = 0; j < n; j++) {
        //     if (map.containsKey(s.charAt(j))) {
        //         i = Math.max(map.get(s.charAt(j)), i);
        //     }
        //     ans = Math.max(ans, j - i + 1);
        //     map.put(s.charAt(j), j + 1);
        // }
        // return ans;
        int i = 0, length = 0;
        int[] ch = new int[128];
        for (int j = 0; j < s.length(); j++) {
            ch[s.charAt(j)]++;
            while (ch[s.charAt(j)] > 1) {
                ch[s.charAt(i)]--;
                i++;
            }
            length = Math.max(length, j - i + 1);
        }
        return length;
    }
}
