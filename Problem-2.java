// Time Complexity : O(n2) brute force, O(n) two pointer
// Space Complexity : O(1) hashset of 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.


class Solution {
    public int lengthOfLongestSubstring1(String s) {
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int slow = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(set.contains(c)){
                while(s.charAt(slow) != c){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++; //escape the repeat char
            }
            max = Math.max(max, i - slow + 1);
            set.add(c);
            }
        return max;
    }


    public int lengthOfLongestSubstring(String s) {
        // StringBuilder sb = new StringBuilder();
        int max = 0;
        for(int i = 0; i < s.length(); i ++){
            HashSet<Character> set = new HashSet<>();
            for(int j = i; j < s.length(); j++){
                if(set.contains(s.charAt(j))){
                    break;
                }
                set.add(s.charAt(j));
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }

    private boolean isUnique(String s, int start, int end){
        boolean [] b = new boolean[26];
        for(int i = start; i <= end; i++){
            if(b[s.charAt(i) - 'a']){
                return false;
            }
            b[s.charAt(i) - 'a'] = true;
        }
        return true;
    }
}