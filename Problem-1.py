#Approach
#Maintain the 2 pointers i, j add he elemts to hash set and if j index element is present is set then get max of max, len(set)


#Complexities
#Time: O(N)
#Space: O(N)


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        length = 0
        hashSet = set()
        i, j = 0, 0

        while j < len(s):
            if s[j] not in hashSet:
                hashSet.add(s[j])
                length = max(len(hashSet), length)
            else:
                while s[i] != s[j]:
                    hashSet.remove(s[i])
                    i += 1
                i += 1
            j += 1
        return length
