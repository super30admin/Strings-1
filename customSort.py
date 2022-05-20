# Time Complexity : O(M+N) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        dict = {}
        
        for i in s:
            dict[i]=dict.get(i,0)+1
        
        res = []
        for i in order:
            if dict.get(i):
                res.append(i*dict.get(i))
                del dict[i]

        for i in dict:
            if dict.get(i):
                res.append(i*dict.get(i))
                

        return "".join(res)
                
solution =  Solution()
print(f'OUTPUT >> {solution.customSortString("cba","abcd")}')