class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        d = {}
        slow = 0
        max_length = 0
        for i in range(len(s)):
            # print(i)
            c = s[i]
            # print(c, end=',')
            if c in d.keys():
                slow = max(slow, d.get(c))

            max_length = max(max_length, i - slow + 1)
            # print(max_length, end='')

            d[c] = i + 1
        return max_length


obj = Solution()

print(obj.lengthOfLongestSubstring("pwwkew"))
