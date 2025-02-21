class Solution:
    def customSortString(self, order: str, s: str) -> str:
        ## Brute force approach
        # TC - O(m*n) -> order * s character to iterate
        # result = ""
        # for ch in order:
        #     for i in range(len(s)):
        #         if s[i] == ch:
        #             result += s[i]
        # for ch in s:
        #     if ch not in order:
        #         result += ch

        # return result

        # Optimized Approach
        # Tc - O(n)
        # Sc - O(1) 26 characters if only small so constant time operation
        freqMap = defaultdict(int)
        for ch in s:
            freqMap[ch]+=1
        result = ""
        for ch in order:
            if ch in freqMap:
                freq = freqMap[ch]
                for i in range(freq):
                    result+=ch
                del freqMap[ch]

        if len(freqMap)>0:
            for key,val in freqMap.items():
                for i in range(val):
                    result+=key

        return result                        



          


        
