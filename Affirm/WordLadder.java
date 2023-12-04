class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, List<String>> neighbors = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            for (int j = 0; j < word.length(); j++) {
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                neighbors.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(beginWord);
        queue.add(beginWord);
        int res = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return res;
                }
                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    List<String> neighborWords = neighbors.getOrDefault(pattern, new ArrayList<>());
                    for (String neighborWord : neighborWords) {
                        if (!visited.contains(neighborWord)) {
                            visited.add(neighborWord);
                            queue.add(neighborWord);
                        }
                    }
                }
            }
            res += 1;
        }
        return 0;
    }
}
