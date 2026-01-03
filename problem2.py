"""
We use hmap to store the freq of ch in the s, and then compare if its present in the order, append it to the res as many times as the value of key and then append the remaining ones
to the result. TC is o(n + m) where n is no. of char in S and m is order, but m can be at max 26, so o(n) and SC is o(1) for storing the 26 entries"""

class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        freq = {}
        res = []
        #if found, get its value and add one to it
        for ch in s:
            freq[ch] = freq.get(ch, 0) + 1

        #custom order situation
        for ch in order:
            if ch in freq:
                res.append(ch * freq[ch])
                del freq[ch]

        #append the remaining ch
        for ch in freq:
            res.append(ch * freq[ch])
        return "".join(res)
