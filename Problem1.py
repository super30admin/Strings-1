"""
791. Custom Sort String
Time Complexity - O(n) where n is length of larger string
Space Complexity - O(n) where n is length of larger string
From T store all the elements into a dictionary with key as character and no of occurance as value
Then read characters from S and append the occurances of those characters in output
For the characters that where not present in S but present in T append at last"""
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        output = ""
        Hashmap = {}
        
        i = 0
        while(i <len(T)):
            if T[i] in Hashmap:
                Hashmap[T[i]] += 1
            else:
                Hashmap[T[i]] = 1
            i += 1
        i = 0
        while (i < len(S)):
            if S[i] in Hashmap:
                while(Hashmap[S[i]] > 0):
                    output += S[i]
                    Hashmap[S[i]] -= 1
            i += 1

        for key,value in enumerate(Hashmap):
            while(Hashmap[value] > 0):
                output += value
                Hashmap[value] -= 1
        
        return output
                
                
        