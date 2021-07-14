class Solution:
    def customSortString(self, order: str, str: str) -> str:
        strArray = [x for x in str]
        result = ""
        for i in order:
            if i in strArray:
                while i in strArray:
                    result += i
                    strArray.remove(i)
        while strArray:
            result += strArray.pop()
        
        return(result)

#Time complexity is O(M*N) 
#Space complexity is O(N) N -> elements in the str string