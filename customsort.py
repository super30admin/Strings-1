class Solution:
    def customSortString(self, S: str, T: str) -> str:
        '''
        Time Complexity: O(S + T)
        Space Complexity: O(T)
        '''
        x = ""
        y = {}
        for i in T:
            if(i in y.keys()):
                y[i] += 1
            else:
                y[i] = 1
        
        for i in S:
            if(i in y.keys()):
                x+= (i*y[i])
                del y[i]
        
        for i in y.keys():
            x+= (i*y[i])
        
        return x
