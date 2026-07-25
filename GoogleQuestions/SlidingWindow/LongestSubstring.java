public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> lastSeen = new HashMap<>();
    int left = 0, maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        if (lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
            left = lastSeen.get(c) + 1;           // jump past the duplicate directly
        }
        lastSeen.put(c, right);
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}

public int lengthOfLongestSubstring(String s) {
    Set<Character> window = new HashSet<>();
    int left = 0, maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);

        // duplicate? shrink from the left until it's gone
        while (window.contains(c)) {
            window.remove(s.charAt(left));
            left++;
        }

        window.add(c);                              // add the new char
        maxLen = Math.max(maxLen, right - left + 1); // window size = right - left + 1
    }
    return maxLen;
}
