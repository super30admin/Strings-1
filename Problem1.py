#Time Complexity:O(m*n)
#Space Complexity:O(1)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        output=""
        for c1 in order:
            for c2 in s:
                if (c1==c2):
                    output = output+c1
                    s=s.replace(c1,'')
 
        for c2 in s:
            output = output+c2
        
        return output
