// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class Solution {
    public String customSortString(String S, String T) {
        if(T.length() == 0) return "";
        
        Map<Character, Integer> map = new HashMap();
        
        StringBuilder sb = new StringBuilder();
        
        for(char ch : T.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        for(char ch : S.toCharArray()){
            
            int count = map.getOrDefault(ch,0);
            
            while(count-- > 0){
                sb.append(ch);
            }
            map.remove(ch);
        }
        
        for(char ch: map.keySet()){
            int count = map.get(ch);
            
            while(count-- > 0){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
