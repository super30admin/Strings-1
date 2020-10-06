// Time Complexity : O(T + S) size of S and T
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {   
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i< T.length(); i++){
            char c = T.charAt(i);
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count > 0){
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            char c = entry.getKey();
            
            int count = entry.getValue();
            while(count > 0){
                sb.append(c);
                count--;
            }
        }  
        return sb.toString();
    }
}