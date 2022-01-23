class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        Hset=set()
        left=0
        ans=0
        for right in range(len(s)):
            while s[right] in Hset:
                Hset.remove(s[left])
                left+=1
            Hset.add(s[right])
            ans=max(ans,right-left+1)
            
        return ans

# Time complexity: O(n) 
# Space complexity:O(n)