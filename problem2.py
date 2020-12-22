#Time complexity O(n)
#space complexity O(1)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s=="": return 0
        slow=0
        maxlen=0
        _hash={}
        for i,val in enumerate(s):
            if val not in _hash:
                _hash[val]=i
                #maxlen=max(maxlen,i-slow+1)
            else:
                if slow<=_hash[val]:
                    slow=_hash[val]+1
                _hash[val]=i
            maxlen=max(maxlen,i-slow+1)
        return maxlen
        