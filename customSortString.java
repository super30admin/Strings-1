// Time Complexity : O(len(S)+len(T)) = O(1)
// Space Complexity : O(len(T)) = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String S, String T) {
        int[] map = new int[26];
        StringBuffer result = new StringBuffer();
        for(int i = 0 ; i <  T.length() ; i++){
            char c = T.charAt(i);
            map[c-'a']++;
        }
        for(int i = 0 ; i <  S.length() ; i++){
            char c = S.charAt(i);
            while(map[c-'a']-- > 0){
                result.append(c);
            }
        }
        for(int i = 0 ; i <  26 ; i++){
            while(map[i]-- > 0){
                result.append((char)(i+'a'));
            }
        }
        return result.toString();
        
    }
}

