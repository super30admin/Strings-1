// TC: O(s + t)
// SC: O(s)
class Solution {
    public String customSortString(String order, String s) {
        if(order == null || order.length() == 0 || s == null || s.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder result = new StringBuilder();
        for(char c : order.toCharArray()) {
            if(map.containsKey(c)) {
                int val = map.get(c);
                map.remove(c);
                while(val-- > 0) {
                    result.append(c);
                }
            }
        }
        for(char c : map.keySet()) {
            int val = map.get(c);
            while(val-- > 0) {
                result.append(c);
            }
        }
        return result.toString();
    }
}