class Solution:
    def customSortString(self, order: str, s: str) -> str:
        result=""
        Hmap={}
        
        for char in s:
            if char not in Hmap:
                Hmap[char]=1
            else:
                Hmap[char]+=1
        
        for char in order:
            if char in Hmap:
                result=result+char*Hmap[char]
                Hmap[char]=0
            
        
        for key,value in Hmap.items():
            if value>0:
                result+=key*value

        return result

# Time Complexity: O(order+s) as we are iterating over both lists once
# Space Complexity: O(order)  