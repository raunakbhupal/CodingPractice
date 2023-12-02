//567. Permutation in String

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> count = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        int begin = 0, end = 0, counter = count.size();
        while (end < s2.length()) {
            char ch = s2.charAt(end);
            if (count.containsKey(ch)) {
                count.put(ch, count.get(ch) - 1);
                if (count.get(ch) == 0) {
                    counter--;
                }
            }
            while (counter == 0) {
                if (end - begin + 1 == s1.length()) {
                    return true;
                }
                ch = s2.charAt(begin);
                if (count.containsKey(ch)) {
                    count.put(ch, count.get(ch) + 1);
                    if (count.get(ch) > 0) {
                        counter++;
                    }
                }
                begin++;
            }
            end++;
        }
        return false;
    }
}
