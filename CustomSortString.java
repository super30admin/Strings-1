// Time Complexity : O(m + n)
// Space Complexity : O(1)

class Solution {
    public String customSortString(String order, String s) {
        if(order == null || order.length() == 0 || s == null || s.length() == 0)
            return s;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count != 0){
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }    
        }
        
        for(char c: map.keySet()){
            int count = map.get(c);
            while(count != 0){
                sb.append(c);
                count--;
            }
        }
        
        return sb.toString();
    }
}