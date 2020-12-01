#Time Complexity : O(len(S)+len(T))
#Space Complexity : O(len(T))
#Did this code successfully run on Leetcode : Yes

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        #get counts of characters in our T string
        counts = collections.Counter(T)
        result = []
        #iterate through each char of S and append that char into the count of that char appearing in string T
        for char in S:
            result.append(char*counts[char])
            counts[char] = 0
            
        #append remaining chars of T in result which are not present in string T
        for char, count in counts.items():
            result.append(char*count)

        return "".join(result)
