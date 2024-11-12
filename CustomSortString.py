#Time Complexity: O(n + m), where n is the length of s and 𝑚 is the length of order, as we iterate through both s and order once to populate scount and build string.
#Space Complexity: O(n), because the dictionary scount and the string list store up to n characters.

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        if(len(order)==0):
            return " "
        string = []
        scount = dict()
        for i in range(0, len(s)):
            scount[s[i]]=scount.get(s[i],0)+1
        for char in order:
            if(char in scount):
                string.append(char * scount[char])
                scount.pop(char)
        for char in scount:
            string.append(char * scount[char])
        return "".join(string)






