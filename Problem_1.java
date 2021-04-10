// Time Complexity : O(n) n = length of string T
// Space Complexity : O(1) since size of map does not depend on input string length
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public String customSortString(String S, String T) {
        if(T == null || T.length() == 0) 
            return T;
        String res = "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c: T.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c: S.toCharArray()){
            if(map.containsKey(c)){
                for(int i = 0; i < map.get(c); i++){
                    res += c;
                }
                map.remove(c);
            }
        }
        for(Character c : map.keySet()){
            for(int i = 0; i < map.get(c); i++){
                res += c;
            }
        }
        return res;
    }
}
