###3. Longest Substring Without Repeating Characters#############################################################################################
// Time Complexity : 2N
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
We used sliding window technique along with set, where we used fast and slow pointer and fast pointer keep going through the list and add elements to set, If any element is again encountered by fast pointer we will move slow pointer till it passes the element which fast has encountered and also along the path it will delete the entry for set also

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        setchk=set()
        slow=0
        maxlen=0
        if len(s)==0:
            return 0
        for i,val in enumerate(s):
            if val not in setchk:
                setchk.add(val)
            else:
                maxlen=max(maxlen,i-slow)
                while s[slow]!=val:
                    setchk.remove(s[slow])
                    slow+=1
                slow+=1
            fast=i
        return max(maxlen,fast-slow+1)
        