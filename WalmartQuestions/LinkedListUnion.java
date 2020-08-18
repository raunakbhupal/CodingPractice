LinkedList getUnion(Node head1, Node head2) 
    { 
        // HashMap that will store the 
        // elements of the lists with their counts 
        HashMap<Integer, Integer> hmap = new HashMap<>(); 
        Node n1 = head1; 
        Node n2 = head2; 
        LinkedList result = new LinkedList(); 
  
        // loop inserts the elements and the count of 
        // that element of list1 into the hmap 
        while (n1 != null) { 
            if (hmap.containsKey(n1.data)) { 
                int val = hmap.get(n1.data); 
                hmap.put(n1.data, val + 1); 
            } 
            else { 
                hmap.put(n1.data, 1); 
            } 
            n1 = n1.next; 
        } 
  
        // loop further adds the elements of list2 with 
        // their counts into the hmap 
        while (n2 != null) { 
            if (hmap.containsKey(n2.data)) { 
                int val = hmap.get(n2.data); 
                hmap.put(n2.data, val + 1); 
            } 
            else { 
                hmap.put(n2.data, 1); 
            } 
            n2 = n2.next; 
        } 
  
        // Eventually add all the elements 
        // into the result that are present in the hmap 
        for (int a : hmap.keySet()) { 
            result.append(a); 
        } 
        return result; 
    }
