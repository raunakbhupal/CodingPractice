class RandomizedCollection {

    ArrayList<Integer> list;
    HashMap<Integer, Set<Integer>> map;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean output = !map.containsKey(val);
        if (output) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return output;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Set<Integer> indexSet = map.get(val);
        int indexToBeRemoved = indexSet.iterator().next();
        if (indexSet.size() == 1) {
            map.remove(val);
        } else {
            indexSet.remove(indexToBeRemoved);
        }
        int lastIndex = list.size() - 1;
        if (indexToBeRemoved == lastIndex) {
            list.remove(lastIndex);
            return true;
        }
        int last = list.get(lastIndex);
        list.set(indexToBeRemoved, last);
        map.get(last).add(indexToBeRemoved);
        map.get(last).remove(lastIndex);
        list.remove(lastIndex);
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        int val = random.nextInt(list.size());
        return list.get(val);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
