"""
// Time Complexity : O(len(S) + len(T)) 
// Space Complexity : O(len(T))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Idea is to have a char frequency map for string T which will be used
to fetch the chars according to S order and form the string
Update the string to include the characters not in T
"""
from collections import Counter
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        
        #freq map to store the count of chars in T
        char_freq = Counter(T)
        
        final_str = ""
        for i in S:
            if i in char_freq:
                final_str+= i * char_freq[i]
        S_set = set(S)
        #T_set = set(T)
        for k,v in char_freq.items():
            if k not in S_set:
                final_str+= k * v
        
        return final_str