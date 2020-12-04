// Time Complexity :  O( M + N )
// Space Complexity : O(N) - length of string 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public String customSortString(String S, String T) {
        if(S== null || S.length() == 0) return T;
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0; i < T.length(); i++){
            char c = T.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< S.length(); i++){
            char c = S.charAt(i);
            int n = map.getOrDefault(c, 0);
            while( n > 0){
                sb.append(c);
                n--;
                map.put(c, map.get(c)- 1);
            }
        }
        for(char c : map.keySet()){
            int n = map.getOrDefault(c, 0);
            while( n > 0){
                sb.append(c);
                n--;
            }
        }
        return sb.toString();
    }
}