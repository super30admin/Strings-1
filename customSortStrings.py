#TimeComplexity:O(T) 
#SpaceComplexity: O(T) for dictionary
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        dictionary={}
        output=''
        for i in range(len(T)):
            dictionary[T[i]]=dictionary[T[i]]+1 if T[i] in dictionary.keys() else 1
        for i in range(len(S)):
            if S[i] in dictionary.keys():
                for j in range(dictionary[S[i]]):
                    output=output+S[i]
                dictionary.pop(S[i])
        for i in dictionary.keys():
            for j in range (dictionary[i]):
                output+=i
        return output   