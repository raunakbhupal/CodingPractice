public static void main(String[] args) {
        List<String> names = Arrays.asList("cheapair", "cheapoair", "peloton", "pelican");

        Map<String, String> res = new HashMap();
        for(String name: names){
            String shortString = findShortestUniqueSubstring(name, names);
            res.put(name, shortString);
        }
        System.out.println(res);
    }

    private static String findShortestUniqueSubstring(String name, List<String> names) {
        String res = "";
        for(int i = 0; i < name.length(); i++){
            for(int j = i+1; j <= name.length(); j++){
                String substr = name.substring(i, j);
                boolean unique = true;
                for(String otherName: names){
                    if(!otherName.equals(name) && otherName.contains(substr)){
                        unique = false;
                        break;
                    }
                }
                if(unique && (res.equals("") || substr.length() < res.length())){
                    res = substr;
                }
            }
        }
        return res;
    }
