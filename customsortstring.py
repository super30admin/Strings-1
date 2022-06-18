#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        dic = {}
        res = ''
        for i in range(len(s)):
            if s[i] not in dic:
                dic[s[i]] = 1
            else:
                dic[s[i]] += 1
                
        for i in range(len(order)):
            if order[i] in dic:
                count = dic[order[i]]
                res = res+ (order[i])*count
                dic.pop(order[i])
                
        for char in dic:
            res = res + (char)*dic[char]
            
        return res
                