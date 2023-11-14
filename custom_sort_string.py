class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        #T: O(m+n)
        #S: O(n): length of string s
        alphabet = collections.defaultdict(int)
        for char in s:
            alphabet[char]+=1
        res = ""
        for char in order:
            for _ in range(alphabet[char]):
                res = "".join([res,char])
                alphabet[char]-=1

        for  key,value in alphabet.items():
            if value > 0:
                for _ in range(value):
                    res = "".join([res,key])
        return res