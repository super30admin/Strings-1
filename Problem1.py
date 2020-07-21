# Time Complexity : O(1), S has maximum 26 characters and while loop inside will run a maximum of 200 time, 
# as 200 is the limit for T
# Space Complexity :O(1), Map_ will have maximum of 26 characters.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def customSortString(self, S, T):
        map_ = {}
        for indx in range(len(T)):
            if T[indx] not in map_:
                map_[T[indx]] = 1 
            else:
                map_[T[indx]] += 1 
        
        result = ''
        for indx in range(len(S)):
            if S[indx] in map_:
                while map_[S[indx]] != 0:
                    result += S[indx]
                    map_[S[indx]] -= 1 
                map_.pop(S[indx])
        
        for k, v in map_.items():
            while v != 0 :
                result += k
                v -= 1 
        
        return result 
                