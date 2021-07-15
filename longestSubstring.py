class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        """
        TC:O(n)
        SC:O(26) or O(1)
        """
        if not s: return 0
        slow=0
        hashmap={}
        ind=1
        leng=0
        for i in range(len(s)):
            # check if char is already present
            if s[i] in hashmap:
                slow=max(slow,hashmap[s[i]])
            hashmap[s[i]]=i+1
            leng=max(leng, i-slow+1)
        
        return leng