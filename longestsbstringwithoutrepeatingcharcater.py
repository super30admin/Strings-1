class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        if s is None or len(s) == 0: return 0
        low_map = collections.defaultdict(int)
        slow, fast, maxresut = 0, 0, 0

        while fast < len(s):

            character = s[fast]
            if character in low_map.keys():
                slow = max(slow, low_map[character])
            low_map[character] = fast + 1
            maxresut = max(maxresut, fast - slow + 1)
            fast += 1
        return maxresut

# Time:-0(n)
# Space :- O(n)
