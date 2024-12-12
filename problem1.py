class Solution:
    def customSortString(self, order: str, s: str) -> str:
        """
        c:0, b:1, a:2

        a:1b:1c:1d:1

        """

        from collections import Counter

        freq_s = Counter(s)
        res = ""
        for char in order:
            temp = char * freq_s[char]
            del freq_s[char]
            res += temp
        
        for k,v in freq_s.items():
            res = res + (k* v)

        return res
