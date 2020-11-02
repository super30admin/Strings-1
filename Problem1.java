// Time Complexity : O(T) 
// Space Complexity : O(T)
// Did this code successfully run on Leetcode : Yes, 0ms
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Store freq of all characters in the hashtable and iterate over String S, and then iterate and append remaining characters in the StringBuffer

class Solution {
    public String customSortString(String S, String T) {
        
        if(S == null && T == null){
            return null;
        }
        
        StringBuffer sb = new StringBuffer();
        
        int[] freq = new int[26];
        
        for(char c : T.toCharArray()){
            
            freq[c - 'a']++;
        }
 
        for(char c : S.toCharArray()){
            
           while(freq[c-'a']-- > 0){
               sb.append(c);
           }
        }
        
        for(char c : T.toCharArray()){
            
            while(freq[c-'a']-- > 0)
            {
                sb.append(c);
            }
            
        }
        
        return sb.toString();
        
    }
}