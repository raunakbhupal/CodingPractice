class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int i = 0, cost = 0, ans = 0;
        for (int j = 0; j < s.length(); j++) {
            cost += Math.abs((int)s.charAt(j) - (int)t.charAt(j));
            while (cost > maxCost) {
                cost -= Math.abs((int)s.charAt(i) - (int)t.charAt(i));
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
