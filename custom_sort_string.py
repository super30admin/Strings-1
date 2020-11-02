# O(N + M) TIME AND O(1) SPACE WHERE N IS LEN(S) AND M IS LEN(T)

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        hashtable={}
        output=[]
        for char in T:
            if char not in hashtable:
                hashtable[char]=0
            hashtable[char]+=1
        for char in S:
            if char in hashtable and hashtable[char]>=1:
                val=hashtable[char]
                temp= char*val
                output.append(temp)
                hashtable[char]-=val
            
        for key,val in hashtable.items():
            if val>0:
                temp = key*val
                output.append(temp)
        print(output)
        return ''.join(output)