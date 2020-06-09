#Problem 2: custom Sort String
#Time complexity: O(n+m) len(S) and len(T)
#Space complexity: O(1)

'''
Keep a count of the relevant letter, append them in order, then append
all the other letters. Return the string
'''
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        string_builder=[]
        h={c:0 for c in S}

        #Creating a count for relevant letter
        for c in T:
            if c in h:
                h[c]+=1
        #put the relevant letters in order, with the count
        for c in S:
            for i in range(h[c]):
                string_builder.append(c)
        #put all the other letters at the end
        for c in T:
            if c not in h:
                string_builder.append(c)

        return "".join(string_builder)
