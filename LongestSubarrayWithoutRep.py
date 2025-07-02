#Sliding Window approach:
#TC: O(2n) We are visiting elements twice
#SC: O(1)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #sliding window approach
        start = 0
        max_length = 0
        if len(s)>1:
            hash_set = set()
            hash_set.add(s[start])
            for j in range(1, len(s)):
                if s[j] in hash_set:
                    while(s[start]!=s[j]):
                        hash_set.remove(s[start])
                        start +=1
                    start +=1
                else:
                    hash_set.add(s[j])
                max_length = max(max_length, j-start+1)
        else:
            return len(s)
        return max_length
        
#TC: O(n)
#SC: O(1)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start = 0
        max_length = 0
        if len(s)>1:
            hash_map = {s[start] : start}
            for j in range(1, len(s)):
                if s[j] in hash_map:
                    start = max(start, hash_map[s[j]]+1)
                    hash_map[s[j]] = j
                else:
                    hash_map[s[j]] = j
                max_length = max(max_length, j-start+1)
        else:
            return len(s)
        return max_length