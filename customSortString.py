# TimeComplexity:O(S+O)->O(S)
# SpaceComplexity Constant ..26 letter in dict
# Approach:
# BruteForce: for every letter in order go through string and if found add it to ans O(OxS)
# Optimal:Get Frequency of each letter in string S and now go thoeugh order add that many chars in ans string 
# O(s) for building map , O(o) for going through order

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        #order is uniuqe
        chars=defaultdict(int)
        for i in s:
            chars[i]+=1
        ans=""
        for letter in order:

            if letter in chars:
                while(chars[letter]):
                    ans+=letter
                    chars[letter]-=1
        for letter in chars:
            if chars[letter]>0:
                while(chars[letter]):
                    ans+=letter
                    chars[letter]-=1
        return ans


class Solution:
    def customSortString(self, order: str, s: str) -> str:
        # Build priority mapping
        priority = {char: idx for idx, char in enumerate(order)}

        # Sort s using priority, assign large values (like 26) to unknown chars
        sorted_s = sorted(s, key=lambda c: priority.get(c, 26))

        return "".join(sorted_s)
