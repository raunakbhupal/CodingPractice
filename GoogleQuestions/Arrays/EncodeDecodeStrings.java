public class Codec {

    // Encode: prefix each string with its length + '#'
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decode: read length, then grab exactly that many chars
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') j++;          // find the '#' → digits are s[i..j)
            int len = Integer.parseInt(s.substring(i, j));   // the length

            String str = s.substring(j + 1, j + 1 + len);    // grab exactly len chars
            res.add(str);

            i = j + 1 + len;                          // jump to the next chunk
        }
        return res;
    }
}
