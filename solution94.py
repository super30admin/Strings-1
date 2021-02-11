#Time Complexity:O(n)
#Space Complexity:O(n)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        dict={}
        slow=0                                                      #slow pointer
        m=0                                                         #max value holder
        for i in range(len(s)):                                     #for every element encountered in s, if c is  in hashmap add to hashmap and obtain the new slow value
            c=s[i]
            if c not in dict:
                dict[c]=0
            if c in dict:
                slow=max([slow,dict[c]])
            dict[c]=i+1                                             #let c value in hashmap be i+1
            m=max([m,i-slow+1])
        return m                                                    #return maximum value