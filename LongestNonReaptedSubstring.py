class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s == None or len(s) ==0:
            return 0
        maxLength = []
        hashmap = {}
        e = 0
        for i in range(len(s)):
            if(s[i] in hashmap and e <= hashmap[s[i]]):
                e = hashmap[s[i]] + 1
            hashmap[s[i]] = i
            maxLength.append(i-e+1)
            # if s[i] not in hashmap:
            #     hashmap[s[i]] = i
            #     print(e)
            
        #print(hashmap)
        return max(maxLength)


        