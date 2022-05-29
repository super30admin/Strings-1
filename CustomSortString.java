
class CustomSortString {
    /*
     * Time Complexity: O (m + n) as we iterate over both order and s string
     * Space Complexity: O(1) Since HashMap would have fixed 26 lowercase characs
     *
     *
     */
    public String customSortString(String order, String s) {
        
        StringBuilder result = new StringBuilder();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for (int i=0; i<order.length(); i++) {
            char d = order.charAt(i);                        
            if (map.containsKey(d)) {
                int cnt = map.get(d);
                while (cnt > 0) {
                    result.append(d);
                    cnt--;
                }   
            } 
            map.remove(d);
        }
        
				// O(m - 1) elements in worst case
        for (char e: map.keySet()) {
            int cnt = map.get(e);
            while (cnt > 0) {
                result.append(e);
                cnt--;
            }
        }
        
        return result.toString();
    }
}
