// Time Complexity : O(M+N) m, n are the length of strings
// Space Complexity : O(M)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap();
        
        for(int i = 0; i < T.length(); i++) {
            map.put(T.charAt(i), map.getOrDefault(T.charAt(i), 0) + 1);
        }
        
        String res = "";
        
        for(int i = 0; i < S.length(); i++) {
            if(map.containsKey(S.charAt(i))) {
            
                int temp = map.get(S.charAt(i));
                while(temp -- > 0) {
                    res += S.charAt(i);
                }
                map.remove(S.charAt(i));
                
            }
        }
        
        for(char i : map.keySet()) {
            int count = map.get(i);
            while(count -- > 0) {
                res += i;
            }
        }
        return res;
    }
}