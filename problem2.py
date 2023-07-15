#Time Complexity : O(n) ... where n is the length of the string
#Space Complexity : O(1) ... O(26) can be treated as constant
#Any problem you faced while coding this : -

# Used the hashset to maintain the check for the characters in the string. Slow and fast(iterator i) pointers were used to keep track of the substring, along with the max_len which stores the length of the longest substring. Everytime a repeated character was found, the slow pointer is gradually incremented to the point where the repeated character can no more be consumed.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        substr_set = set()
        slow, max_len = 0, 0
        for i in range(len(s)):
            c = s[i]
            if c in substr_set:
                while s[slow] != c:
                    substr_set.remove(s[slow])
                    slow += 1
                slow += 1
            substr_set.add(c)
            max_len = max(max_len, i - slow + 1)

        return max_len