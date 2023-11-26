class Solution {
    public int countVowelSubstrings(String word) {
        return atMost(word, 5) - atMost(word, 4);
    }

    public int atMost(String word, int k) {
        int i = 0, ans = 0;
        HashMap<Character, Integer> count = new HashMap<>();
        for (int j = 0; j < word.length(); j++) {
            char ch = word.charAt(j);
            if (!isVowel(ch)) {
                i = j + 1;
                count.clear();
                continue;
            }
            if (isVowel(ch)) {
                count.put(ch, 1 + count.getOrDefault(ch, 0));
            }
            while (count.size() > k) {
                ch = word.charAt(i);
                if (count.containsKey(ch) && count.get(ch) > 0) {
                    count.put(ch, count.get(ch) - 1);
                    if (count.get(ch) == 0) {
                        count.remove(ch);
                    }
                }
                i++;
            }
            ans += j - i;
        }
        return ans;
    }

    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }
}
