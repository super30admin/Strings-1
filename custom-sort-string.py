class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        out = ""
        if s == None or len(s) == 0: return out
        charMap = Counter(s)
        for i in range(len(order)):
            if charMap.has_key(order[i]):
                count = charMap[order[i]]
                while count > 0:
                    out += order[i]
                    count -= 1
                del charMap[order[i]]
        print(out)
        for ele in charMap:
            count = charMap[ele]
            while count > 0:
                out += ele
                count -= 1
        return out