// 30. Substring with Concatenation of All Words

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }
        int wordSize = words[0].length();
        int windowSize = words.length * wordSize;
        if (s.length() < windowSize) {
            return result;
        }
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> reference = new HashMap<>(count);
        int begin, end, counter;
        // There are only wordSize possible start points for our window.
        // End is actually the start of the last word in the window or, in other words,
        // the real end of the window is at end + wordSize.
        for (int i = 0; i < wordSize; i++) {
            begin = i;
            end = i;
            count = new HashMap<>(reference); // Reset to the original frequency table after every iteration
            counter = count.size();

            while (end + wordSize - 1 < s.length()) {
                String lastWord = s.substring(end, end + wordSize);
                if (count.containsKey(lastWord)) {
                    count.put(lastWord, count.get(lastWord) - 1);
                    if (count.get(lastWord) == 0) {
                        counter--;
                    }
                }

                if (end + wordSize - begin == windowSize) {
                    if (counter == 0) {
                        result.add(begin);
                    }
                    String firstWord = s.substring(begin, begin + wordSize);
                    if (count.containsKey(firstWord)) {
                        count.put(firstWord, count.get(firstWord) + 1);
                        if (count.get(firstWord) > 0) {
                            counter++;
                        }
                    }
                    begin += wordSize;
                }
                end += wordSize;
            }
        }
        return result;
    }
}
