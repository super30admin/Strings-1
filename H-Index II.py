# Time Complexity :
# TC: O(logN) --> N is len citations array

# Space Complexity :
# SC: O(1)

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach
# I used Binary Search to solve this problem as the array was sorted.
# The comments in program are step by step description


class Solution:
    
    # Binary Search
    # TC: O(logN) --> N is len citations array
    # SC: O(1)
    
    def hIndex(self, citations: List[int]) -> int:
        
        if (len(citations) == 0 or citations == None):
            return 0
        
        n = len(citations)
        low = 0
        high = n - 1
        
        while (low <= high):
            mid = (low + high)//2
            diff = n - mid
            
            if (diff == citations[mid]):
                return diff
            elif (diff > citations[mid]):
                low = mid + 1
            else:
                high = mid - 1
                
        return n - low