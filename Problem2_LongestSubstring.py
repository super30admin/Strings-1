# Time Complexity: O(n), where n - length of the string
# Space Complexity: O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s or len(s) == 0:
            return 0

        # Hashmap to store the chars and their index
        hmap = dict()
        maximum = 0
        slow = 0

        for i in range(len(s)):
            # If the char is repeating, move the slow pointer to the next index of its prev occurrence
            ch = s[i]
            if ch in hmap:
                slow = max(slow, hmap[ch])

            hmap[ch] = i + 1
            # Update the maximum length of the string without repeating chars
            maximum = max(maximum, i - slow + 1)

        return maximum

