// Time Complexity : O(m + n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String S, String T) {
        
        if(S == null || S.length() == 0 || T == null || T.length() == 0) {
            return T;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(map.containsKey(c)) {
                int times = map.get(c);
                for (int j = 0; j < times; j++) {
                    result.append(c);
                }
                map.remove(c);
            }
        }
        
        for(char c: map.keySet()) {
            int times = map.get(c);
            for(int j = 0; j < times; j++) {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}