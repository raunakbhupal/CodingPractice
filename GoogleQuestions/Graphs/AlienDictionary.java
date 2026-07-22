class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> graph = new HashMap<>();
      Map<Character, Integer> indegree = new HashMap<>();

      for (String w : words) {
        for (char c : w.toCharArray()) {
            graph.putIfAbsent(c, new HashSet<>());
            indegree.putIfAbsent(c, 0);
        }
      }

      for (int i=0;i<words.length-1; i++) {
        String w1 = words[i];
        String w2 = words[i+1];

        if (w1.length() > w2.length() && w1.startsWith(w2)) {
            return "";
        }

        for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
            char c1 = w1.charAt(j), c2 = w2.charAt(j);
            if (c1 != c2) {
                if (graph.get(c1).add(c2)) {        // only if NEW edge
                    indegree.put(c2, indegree.get(c2) + 1);
                }
                break;                               // first diff only!
            }
        }
        }

      Queue<Character> queue = new LinkedList<>();
      for (char c : indegree.keySet()) {
        if (indegree.get(c) == 0) {
            queue.offer(c);
        }
      }

      StringBuilder sb = new StringBuilder();
      while (!queue.isEmpty()) {
        char c = queue.poll();
        sb.append(c);
        for (char next : graph.get(c)) {
            indegree.put(next, indegree.get(next) - 1);
            if (indegree.get(next) == 0){
                queue.offer(next);
            }
        }
      }

        return sb.length() == indegree.size() ? sb.toString() : "";


    }
}
