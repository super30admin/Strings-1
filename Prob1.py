# Time Complexity -O(n)
# Space Complexity - O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        #Method 1 - Hashset Sliding Window TC - O(2n) or O(n), SC-O(1) (characters so O(26)~O(1))
        # slow=0
        # maxi=0
        # hash=set()
        # for i in range(len(s)):
        #     c=s[i]
        #     if c in hash:
        #         while s[slow]!=c: #remove all elements till previous occurence
        #             hash.remove(s[slow])
        #             slow+=1
        #         slow+=1
        #     hash.add(c) #if not add it to hashset
        #     maxi=max(maxi,i-slow+1) #max length is max of max and i-slow+1 for each i
        # return maxi

         #Method 1 - Hashmap Sliding Window TC - O(n), SC-O(1) (characters so O(26)~O(1))
        hashmap=dict()
        slow=0
        maxi=0
        for i in range(len(s)):
            c=s[i]
            if c in hashmap:
                slow=max(slow,hashmap[c]+1) #move slow, only if repeat is in the currrent range, else keep slow the same
            hashmap[c]=i #update hashmap irrespective if it was already in hashmap or not
            maxi=max(maxi,i-slow+1)
        return maxi
