class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] m = new int[128];
        int i = 0, ans = 0, cnt = 0;
        for (int j = 0; j < s.length(); ++j) {
            if (m[s.charAt(j)]++ == 0) {
                ++cnt;
            }
            while (cnt > 2) {
                if (m[s.charAt(i)]-- == 1) {
                    --cnt;
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
