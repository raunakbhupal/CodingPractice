class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> hmap1 = new HashMap<>();
        Map<Character, Integer> hmap2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            hmap1.put(s.charAt(i), hmap1.getOrDefault(s.charAt(i), 0) + 1);
            hmap2.put(t.charAt(i), hmap2.getOrDefault(t.charAt(i), 0) + 1);
        }

        if (hmap1.equals(hmap2)) {
            return true;
        }
        return false;
    }
}


## OR in O(1) space

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] count = new int[26];
    for (int i = 0; i < s.length(); i++) {
        count[s.charAt(i) - 'a']++;
        count[t.charAt(i) - 'a']--;
    }
    for (int c : count) if (c != 0) return false;
    return true;
}
