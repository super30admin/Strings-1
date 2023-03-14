#All TC passed on leetcode


class Solution:
    def customSortString(self, order: str, s: str) -> str:

        #Here we store the chars and their count in a map. We traverse the order string and if its cur char exists in map then we append it count times in result. Then the chars not present in map but were present in s are appended to result any order.
        #Time complexity - O(n) where n is length of s as length of order is contant hence not considered.
        #Space complexity - O(1) - dict can have max 26 chars
        dict = collections.defaultdict(int)
        res = ""

        for ch in s:
            dict[ch]+=1
        
        for ch in order:
            if ch in dict:
                res = res + ch*dict[ch]
                dict.pop(ch)
        
        for ch, fq in dict.items():
            res = res + ch*fq
        
        return res
