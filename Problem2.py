"""
TC: O(N) The time complexity is linear because we iterate through the string once, and all hash map operations (insert, lookup, update) take average O(1) time.
SC: O(min(N, A)) The space complexity is determined by the hash map, which stores at most the number of unique characters in the string N, or the size of the alphabet A (26 for lowercase English letters), whichever is smaller.

Approach:

This problem is solved using the Sliding Window technique, specifically an expanding and contracting window managed by two pointers, left} and right} (represented by the loop index i). The goal is to find the longest substring without repeating characters.

1.  Hash Map: A hash map is used to store the most recent index of every character encountered within the window.
2.  Expansion and Contraction: The right} pointer (i) expands the window one character at a time.
    * If the character s[i] is already in the hash map AND its last seen index is greater than or equal to the current left} boundary, a duplicate has been found within the current window.
    * The left} pointer must then jump past the previous occurrence of the duplicate character (to hashmap}[ch] + 1) to restore the non-repeating property of the window.
3.  Update: After adjusting the left} pointer (if necessary), we update the hash map with the current index i of the character. We then calculate the length of the current non-repeating window (i - left + 1}) and update the overall maximum length (res}).

The final result is the maximum length found during the single pass.

The problem ran successfully on LeetCode.
"""

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        hashmap = {}
        left = 0
        res = 0
        for i in range(len(s)):
            ch = s[i]
            if ch in hashmap and hashmap[ch] >=left:
                left = hashmap[ch] + 1
            hashmap[ch] = i
            res = max(res, i-left+1)
        return res



                    

    