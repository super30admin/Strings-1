#Time Complexity:O(n)
#Space Complexity:O(1)

#Algorithm:
#1. Create hashmap for the occurences of characters in T
#2. Check if the characters in s exists in hashmap .
#3. If yes add that character to string x its occurences,to be returned and delete it from the map.
#4.Later check for the elements still present in the hashmap and add all those to the string being returned.

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        intersection=set(S)&set(T)
     
        res=''
        dc=collections.Counter(T)
      
        for s in S:
            if s in dc:
                res+=s*dc[s]
                del dc[s]
        # print(dc)
        
        for x in dc:
                res+=x*dc[x]
        
        return res
