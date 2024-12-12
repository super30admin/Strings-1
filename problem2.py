class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # s = "pwwkew"
        """
        p0w2k3e4
        res = 3
        l = 2
        """
        frame = {}
        l = 0
        result = 0

        for i, char in enumerate(s):
            if char not in frame:
                frame[char] = i

            else:
                if frame[char] >= l:
                    l = frame[char] + 1
                frame[char] = i
            
            result = max(result, i-l+1)
        
        return result

