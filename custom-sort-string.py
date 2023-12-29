'''The code uses a sliding window approach to find the length of the longest substring without repeating characters. 
It maintains a set (char_set) to track unique characters in the current substring. 
When a repeating character is encountered, it removes characters from the set until there are no duplicates,
updating the start index (left). The result is the maximum length of unique substrings.

Time complexity: O(n) - The algorithm iterates through each character in the input string once.
Space complexity: O(min(n, m)) - The space used by the set is bounded by the size of the character set or the length of the input string.'''
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        result = 0
        left = 0
        char_set = set()
        for i in s:
            if i in char_set:
                while(i!=s[left]):
                    char_set.remove(s[left])
                    left=left+1
                left=left+1
            char_set.add(i)   
            result = max(result,len(char_set))

        return result 
        