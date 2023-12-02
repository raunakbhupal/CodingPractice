// 438. Find All Anagrams in a String

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if (p.length() > s.length()) {
            return result;
        }
        Map<Character, Integer> count = new HashMap<>();
        for (char ch : p.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        int begin = 0, end = 0, counter = count.size();

        while (end < s.length()) {
            char ch = s.charAt(end);
            if (count.containsKey(ch)) {
                count.put(ch, count.get(ch) - 1);
                if (count.get(ch) == 0) {
                    counter--;
                }
            }
            while (counter == 0) {
                if (end - begin + 1 == p.length()) {
                    result.add(begin);
                }
                ch = s.charAt(begin);
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
        return result;
    }
}
