#Problem1: longest substring
#Time Complexity: O(n)
#Space Complexity: O(1)
'''
Similar to longest subsequence, we move the slow pointer to where we last
encountered the present element (only if it's after where the slow is).
Store in a hashmap. There's no point in continuing with fast since
if there's a duplicate, everything after would have duplicate, so
we need to go beyond with slow so we can start moving with fast

'''
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        previous={}
        slow=0
        max_substring=0
        for i in range(len(s)):
            if s[i] in previous:
                #maybe previous was seen before slow, so it might not affect
                slow=max(previous[s[i]],slow)
            #update max substring
            max_substring=max(max_substring,i-slow+1)
            #update the hashmap
            previous[s[i]]=i+1
        return max_substring
