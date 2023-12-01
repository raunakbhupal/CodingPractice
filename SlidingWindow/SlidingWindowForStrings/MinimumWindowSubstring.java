class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        if (t.length() > s.length()) {
            return "";
        }
        HashMap<Character, Integer> count = new HashMap<>();
        for (char ch : t.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        int begin = 0, end = 0, counter = count.size(), len = Integer.MAX_VALUE;

        while (end < s.length()) {
            char ch = s.charAt(end);
            if (count.containsKey(ch)) {
                count.put(ch, count.get(ch) - 1);
                if (count.get(ch) == 0) {
                    counter--;
                }
            }
            while (counter == 0) {
                ch = s.charAt(begin);
                if (count.containsKey(ch)) {
                    count.put(ch, count.get(ch) + 1);
                    if (count.get(ch) > 0) {
                        counter++;
                    }
                }
                if (end - begin + 1 < len) {
                    len = end - begin + 1;
                    ans = s.substring(begin, end + 1);
                }
                begin++;
            }
            end++;
        }
        return ans;
    }
}
