// Time Complexity : O(n)
//  Space Complexity : Auxiliary O(n) : no extra space used
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
// Three line explanation of solution in plain english:
//1. We use a sliding window approach with two pointers to track the longest substring without repeating characters.
//2. We maintain a set to store characters in the current substring and adjust the window size
//3. If a character is repeated, we move the left pointer to the right until the substring is valid again, updating the maximum length found.




class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=s.length();
        // If the string is empty or has only one character, return its length
        if (l<=1) return l;
        // Use a set to track characters in the current substring
        Set<Character> set=new HashSet<>();
        int max=0;
        // Two pointers for the sliding window
        int left=0 , right=0;
        // Iterate through the string with the right pointer
        while (right<s.length()){
            // If the character at the right pointer is not in the set, add it
            // and update the maximum length
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                max = Math.max(max, right - left);
            }
            // If the character is repeated, move the left pointer to the right
            //removing characters from the set until the substring is valid again
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        // Return the maximum length of the substring found
        return max;
    }
}