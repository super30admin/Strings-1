// Time: O(max of order, s)
// Space: O(1)
// Leetcode: https://leetcode.com/submissions/detail/627129758/
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            } else {
                int val = map.get(s.charAt(i));
                val++;
                map.put(s.charAt(i), val);
            }
        }
        
        for(int i = 0; i < order.length(); i++) {
            
            if(map.containsKey(order.charAt(i))) {
                int freq = map.get(order.charAt(i));
                
                while(freq > 0) {
                    result = result + order.charAt(i);
                    freq--;
                }
                map.remove(order.charAt(i));
            }
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer freq = entry.getValue();
            while(freq > 0) {
                    result = result + key;
                    freq--;
                }
        }
        return result;
    }
}