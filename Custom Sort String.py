class Solution:
    def customSortString(self, S: str, T: str) -> str:
        #Time Complexity: O(len(S) + len(T))
        #Space Complexity: O(len(T))  // could have used str instead of [] for SC-TC trade-off
        
        count = {}
        for char in T:
            count[char] = count.get(char, 0) + 1
        
        result = []
        for char in S:
            result.append(char * count.get(char, 0))
            count[char] = 0
            
        for char in count:
            result.append(char * count.get(char, 0))
            count[char] = 0
            
        return "".join(result)