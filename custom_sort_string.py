class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        from collections import defaultdict
        dic = defaultdict(int)
        res = ''
        last = ''
        for i in T:
            dic[i] += 1
        for i in S:
            for j in range(dic[i]):
                res += i
            dic.pop(i)
        for i in dic:
            for j in range(dic[i]):
                res += i
        return res