class Solution:
    def customSortString(self, S: str, T: str) -> str:

        count = Counter(T)
    
        output = ""
        for letter in S:
            if letter in T:
                output+=(letter*count[letter])
                count[letter] = 0
        for letter in count:
            if count[letter]>0:
                output+=(letter*count[letter])
        return output
                
Time: O(M+N)
Space: O(N)
