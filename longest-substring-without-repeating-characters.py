# TC: O(n)
# SC: O(1)
# Hashset Solution
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        length=0
        if s==None or len(s)==0: return length
        slow=0
        freq={}
        for i in range(len(s)):
            if s[i] in freq:
                slow=max(slow,freq[s[i]])
            freq[s[i]]=i+1
            length=max(length,i-slow+1)
        return length
# TC: O(2n)
# SC: O(1)
# Hashset Solution
    # def lengthOfLongestSubstring(self, s: str) -> int:
    #     length=0
    #     if s==None or len(s)==0: return length
    #     slow=0
    #     hash_set=set()
    #     for i in range(len(s)):
    #         if s[i] in hash_set:
    #             while s[slow]!=s[i]:
    #                 hash_set.remove(s[slow])
    #                 slow+=1
    #             slow+=1
    #         hash_set.add(s[i])
    #         length=max(length,i-slow+1)
    #     return length