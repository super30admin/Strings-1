#I iterated through the string with an index i while maintaining another pointer k to mark the start of the current substring. For each character at index i, I checked for repeats by comparing it with characters from the start of the substring up to i-1. If I found a repeating character, I updated k to exclude the repeating character and adjust the start of the substring. I calculated the length of the current substring and updated the maximum length found so far. The time complexity of this approach is O(n^2) due to the nested loops, where n is the length of the string, and the space complexity is O(1) since only a few additional variables are used.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # Check if the length of the string is less than 2
        if len(s) < 2:
            return len(s)
        
        # Initialize variables
        k, max_len, count = 0, 0, 0
        
        # Iterate through the string
        for i in range(1, len(s)):
            # Check for repeating characters in the current substring
            for j in range(k, i):
                if s[i] == s[j]:
                    k = j + 1
            
            # Update the current substring length
            count = i - k + 1
            
            # Update the maximum length
            if count > max_len:
                max_len = count
        
        # Return the result
        return max_len