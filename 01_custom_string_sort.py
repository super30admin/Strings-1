'''
order = char which unique
s = char which may or maynot be unique

hashSetS = {

}
output = ''
for ch in order:
    if ch in hashSetS:
        output += ch
        hashMapS                                                                                               .remove(ch)
for key in hashSetS:
    utput += key
    n = length of String s, m = length of string m
   

'''
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashMapS = {}
        
        for ch in s: #TC = O(n), SC: O(n)
            if ch in hashMapS:
                hashMapS[ch] += 1
            else:
                hashMapS[ch] = 1
        output = ''
        
        for ch in order: #TC = O(m) SC: O(1)
            if ch in hashMapS:
                output += ch*hashMapS[ch]
                hashMapS.pop(ch)

        for ch in hashMapS:#TC = O(n), SC: O(1)
            output += ch*hashMapS[ch]
   
        return output