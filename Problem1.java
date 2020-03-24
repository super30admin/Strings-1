// ## Problem1 :: Custom Sort String (https://leetcode.com/problems/custom-sort-string/)
// Space - O(1) Time - O(S.length() + T.length())
class Solution {
    public String customSortString(String S, String T) {
        int m = S.length(), n = T.length();
        if(m * n == 0) return "";
        
        int[] alphaCount = new int[26];
        
        for(char c: T.toCharArray()) 
            alphaCount[c - 'a']++;
        StringBuilder sb = new StringBuilder("");
        for(char c: S.toCharArray()){
            while(alphaCount[c - 'a']-- > 0)  sb.append(c+"");
           
        }
        
        for(char c = 'a' ; c <= 'z'; c++){
            while(alphaCount[c - 'a']-- > 0) sb.append(c+"");
        }
       
        return sb.toString();
        
    }
}