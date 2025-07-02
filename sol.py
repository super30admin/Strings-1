##problem1 

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        mydict = Counter(s)

        myret = ""

        for a in order:
            count = mydict[a]

            myret += a *count
            mydict[a] = 0
        for k in mydict.keys():
            if mydict[k] != 0:
                count = mydict[k]
                myret += k *count
        return myret


##problem2

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        mydict = collections.defaultdict(int)

        lo = 0
        hi = 0 
        currlen = 0 
        maxlen = 0

        while hi < len(s):

            if s[hi] in mydict and mydict[s[hi]] >= lo:
                lo = mydict[s[hi]] + 1
                currlen = hi -lo 
            else:
                mydict[s[hi]] = hi
                currlen +=1 
                hi+=1
                maxlen = max(currlen,maxlen)
        return maxlen 


       
