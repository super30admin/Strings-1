// Time Complexity : O(m+n) m is size of string S and n String T
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public String customSortString(String S, String T) {
        
        StringBuilder ans = new StringBuilder();
        
        Map<Character,Integer> map = new HashMap();
        
        for(Character c : T.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        for(Character c : S.toCharArray()) {
            
            if(map.containsKey(c)) {
                
                int count = map.get(c);
                while(count-- > 0)
                    ans.append(c);
                map.remove(c);
                
            }
        }
        
        
        for(Character c : map.keySet()) {
            int count = map.get(c);
            while(count-- > 0)
                ans.append(c);
        }
        
        return ans.toString();
        
    }
}
