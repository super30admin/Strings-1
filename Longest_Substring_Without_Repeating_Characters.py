#Time Complexity:O(n)
#space Complexity:O(k) no of element in the subset
#Leetcode submission:successful
#approch :Sliding Window
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        n=len(s)
        a=set()
        ans=i=j=0
        while(i<n and j<n):
            if s[j] not in a:
                a.add(s[j])
                j=j+1
                ans=max(ans,j-i)
            else:
                
                a.remove(s[i])
                i=i+1
        return ans