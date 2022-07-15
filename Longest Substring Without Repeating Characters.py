#TC:O(n)
#SC:O(1)
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        hashMap=dict()
        max1=0
        slow=0
        for i in range(len(s)):
            if s[i] in hashMap:
                slow=max(slow,hashMap[s[i]])
            max1=max(max1,i-slow+1)
            hashMap[s[i]]=i+1
            
        return max1

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