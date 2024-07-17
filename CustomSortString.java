// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class CustomSortString {
    public String customSortString(String order, String s) {
        StringBuilder res = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
        }
        for(int i = 0; i < order.length(); i++) {
            if(map.containsKey(order.charAt(i))) {
                int count = map.get(order.charAt(i));
                for(int j = 0; j < count; j++) {
                    res.append(order.charAt(i));
                }
                map.remove(order.charAt(i));
            }
        }
        
        for(char keys : map.keySet()) {
            int count = map.get(keys);
            for(int j = 0; j < count; j++) {
                res.append(keys);
            }
        }
        return res.toString();
    }
}