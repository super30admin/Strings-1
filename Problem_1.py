# https://leetcode.com/problems/custom-sort-string/description/

# Time complexity: O(n) 
# Space complexity: O(n)
# Explanation: Get freq of each char in s; arrange as per order; append the rest

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        scount = Counter(s)
        perm = []

        for ch in order:
            if ch in scount:
                perm.append(ch * scount[ch])
            del scount[ch]
        
        for ch in scount:
            perm.append(ch * scount[ch])
        
        return ''.join(perm)
