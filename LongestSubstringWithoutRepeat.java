// Time Complexity : O(n^3)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : 986/987, TLE
// Any problem you faced while coding this : no, bruteforce

// Your code here along with comments explaining your approach
// Generate all possible substrings
// validate if substring doesn't contain repeat chars, update max substring length

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        
        int maxSubStringLength = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(validSubString(s, i, j)){
                    maxSubStringLength = Math.max(maxSubStringLength, j-i+1);
                }
            }
        }
        
        return maxSubStringLength;
    }
    
    private boolean validSubString(String s, int i, int j){
        Set<Character> set = new HashSet();
        
        for(int k=i; k<=j; k++){
            set.add(s.charAt(k));
        }
        
        return set.size()==(j-i+1);
    }
}