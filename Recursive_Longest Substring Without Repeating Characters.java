
//Recursive Solution
//Time: O(n^2)
//Space: O(n)
//https://leetcode.com/submissions/detail/627562255/

class Solution {
    
    int max;
    public int lengthOfLongestSubstring(String s) {
        max = 0;
        
        for(int i=0; i < s.length(); i++) {
            Helper(new HashSet<Character>(), s, i, 0);
        }
        return max;
    }
    
    void Helper(HashSet<Character> list, String s, int i, int currMax) {
        
        if(i == s.length() || list.contains(s.charAt(i))) {
            max = Math.max(max, list.size());
            return;
        }
        list.add(s.charAt(i));
        Helper(list, s, i+1, currMax+1);
        
    }
}