

// Time Complexity :O(m+n)
// Space Complexity : O(1) as there will be 26 charecters in map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String customSortString(String order, String s) {
    HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0) +1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
               int cnt = map.get(c);
               for(int k =0; k < cnt; k++){
                  sb.append(c);      
               }
                map.remove(c);
            }
            
        }
        
        for(char c:map.keySet()){
            int cnt = map.get(c);
            for(int k=0; k<cnt; k++){
                sb.append(c);
            }
         //   map.remove(c);
        }
        return sb.toString();
        
        
    }
}
