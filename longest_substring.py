# Time Complexity: O(n)
# Space Complexity: O(1) because max 26 chars
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        result = 0
        # store index + 1 of every char in hash map
        hash_map = {}
        slow = 0

        for i in range(len(s)):
            c = s[i]
            if(c in hash_map):
                # if a repeating char is found, update the slow pointer to skip the previous occurrence of the char
                # take max to update it only to a later index and never go back
                slow = max(slow, hash_map[c])
                
            # in any case, update the hash map with index+1 value of that char in s
            hash_map[c] = i+1
            result = max(result, i-slow+1)
        
        return result
        