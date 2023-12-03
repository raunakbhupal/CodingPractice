//983. Minimum Cost For Tickets

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length-1] + 1];
        Set<Integer> daysPresent = new HashSet<>();
        for (int i : days) {
            daysPresent.add(i);
        }
        for (int i = 1; i <= days[days.length - 1]; i++) {
            if(!daysPresent.contains(i)) {
                dp[i] = dp[i-1];
            } else {
                int one = dp[Math.max(0, i-1)] + costs[0];
                int seven = dp[Math.max(0, i-7)] + costs[1];
                int thirty = dp[Math.max(0, i-30)] + costs[2];
                dp[i] = Math.min(one, Math.min(seven, thirty));
            }
        }
        return dp[days[days.length - 1]];
    }
}
