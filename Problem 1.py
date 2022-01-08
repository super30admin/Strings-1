# Time comlpexity: O(len(s))
# Space Complexity: O(1)
class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        dic = {}
        for i in s:
            if i not in dic:
                dic[i] = 1
            else:
                dic[i] += 1
        ans = ''
        for i in order:
            if i in dic:
                ans += i*dic[i]
                del dic[i]
        for key, value in dic.items():
            ans += key*value
        return ans
        
