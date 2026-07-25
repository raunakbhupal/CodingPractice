class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}

// optimzed
int[] count = new int[26];
for (char c : s.toCharArray()) count[c - 'a']++;
String key = Arrays.toString(count);   // "[1,0,0,...]" — same for all anagrams
