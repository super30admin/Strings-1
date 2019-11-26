#Time Complexity:O(n)
#space Complexity:O(k) no of element in the subset
#Leetcode submission:successful
#approch :first append the common words of String S and T and paste the remaining words of T in ans
class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        ct=collections.Counter(T)
        ans=[]
        for c in S:
            ans.append(c*ct[c])
            ct[c]=0
        for c in ct:
            ans.append(c*ct[c])
        return "".join(ans)
        