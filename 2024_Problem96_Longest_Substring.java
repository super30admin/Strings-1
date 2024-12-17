//3. Longest Substring - https://leetcode.com/problems/longest-substring-without-repeating-characters/
//Time Complexity: O(2n)
//Space Complexity: O(1) ~ HashSet Space ~ Constant space for 26 characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int slow = 0; //to keep track of the string having distinct characters

        for(int i=0; i<n; i++){ //i: to iterate over s
            char c = s.charAt(i);
            if(set.contains(c)){
                while(s.charAt(slow) != c){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            set.add(c);
            max = Math.max(max, i-slow+1);
        }
        return max;
    }
}

