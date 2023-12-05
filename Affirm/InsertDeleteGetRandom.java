//380. Insert Delete GetRandom O(1)

class RandomizedSet {

    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();    
    }
    
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        // check for single element
        if (index == list.size() - 1) {
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        map.remove(val);
        int size = list.size();
        int last = list.get(size - 1);
        list.set(index, last);
        list.remove(size - 1);
        map.put(last, index);
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        int val = random.nextInt(list.size());
        return list.get(val);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
