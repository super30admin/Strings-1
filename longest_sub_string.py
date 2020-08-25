class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        count=0
        ans=0
        hashmap=collections.defaultdict(int)
        i=0
        for j in range(len(s)):
            if hashmap.get(s[j]):
                i=max(hashmap.get(s[j]),i)
            ans=max(ans,j-i+1)
            hashmap[s[j]]=j+1
        return ans
#Time-Complexity:O(n)
#space-complexity:O(n)