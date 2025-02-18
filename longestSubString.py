class Solution:
    # 2-pointer approach with hashmap
    # TC : O(n)
    # SC : O(1)
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s is None or len(s) == 0:
            return 0
        start = 0
        maxlen = 0
        hmap = defaultdict(int)
        for i in range(len(s)):
            ch = s[i]
            if ch in hmap.keys():
                start = max(start,hmap[ch])
            maxlen = max(maxlen,i-start+1)
            hmap[ch] = i+1
        return maxlen

        