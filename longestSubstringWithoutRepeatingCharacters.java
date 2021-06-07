//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
        if(s.length() == 0){
            
            return 0;
        }
        
        HashMap<Character,Integer> map1 = new HashMap<>();
        
        int slowPtr = 0;
        int fastPtr = 0;
        int max = 0;
        
        while(fastPtr < s.length()){
            
            char ch = s.charAt(fastPtr);
            
            if(!map1.containsKey(ch)){
                
                map1.put(ch, fastPtr + 1);
               // fast ++;
               // max = Math.max(max, fastPtr - slowPtr);
            }
            else {
                max = Math.max(max, fastPtr - slowPtr);
                int position = map1.get(ch);
                if(position > slowPtr){
                    
                    slowPtr = position;
                }
                map1.put(ch, fastPtr + 1);
                
                
            }
            fastPtr ++;
            
            
        }
        return Math.max(max,fastPtr-slowPtr);
    }
}