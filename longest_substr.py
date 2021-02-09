class Solution:

    """
    Description: find the length of the longest substring without repeating characters in stirng s
    
    Time Complexity: O(n)
    Space Complexity: O(n)
    where n is the length of the string s
    
    Approach:
    - Use sliding window, start with an index "slow" from 0
    - declear a global max length parameter, and create a hash table
    - iteratively find if a character is repeated, update the new index + 1 for key as character in hash map
      + otherwise add the key with index + 1 (+1 to skip to the next one) as the value
      + update the maximum length using the position of slow vs current index 
      
    - Caution: don't move slow backwards if the repeat is at the end - edge case
    """
    
    def lengthOfLongestSubstring(self, s: str) -> int:
       
        max_len = 0
        if s == None: return max_len
        
        slow = 0;
        str_dict = {}
        
        for i, c in enumerate(s):
            if c in str_dict:
                slow = max(slow, str_dict[c])
            str_dict[c] = i + 1
            max_len = max(max_len, i - slow + 1)
                
        return max_len
