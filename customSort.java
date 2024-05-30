//time O(n+m) n is the length of string and m is the length of order
//space O(m)

class Solution {
    public String customSortString(String order, String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if(map.containsKey(c)) {
                for(int k = 0; k < map.get(c); k++) {
                    sb.append(c);
                }
            }
            map.remove(c);
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            char c = entry.getKey();
            int val = entry.getValue();
            for(int k = 0; k < val; k++) {
                sb.append(c);
            }
            // map.remove(c);
        }
        return sb.toString();
    }
}
