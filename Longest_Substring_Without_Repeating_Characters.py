# Sliding Window Approach
# Time :  O(N)
# Space (HashMap) : O(min(m,n)
# Space (Table): O(m). m is the size of the charset.

class Solution(object):
    def lengthOfLongestSubstring(self, s):
		# Base case
        if not s:
            return 0
        
        maximum = 0
        slow = 0
        dic = {}
        
		
        for i in range(len(s)):
            if s[i] in dic:
				# since need to avoid going back, we will be traveling back only when the slow pointer is smaller 
				# than current pointer value in the dic
                slow = max(slow, dic[s[i]])
			# why i + 1 since we need to pass repeating charcter
            dic[s[i]] = i + 1
			
			# Check maximum length of substring everytime
            maximum = max(maximum, i - slow + 1)
            
        return maximum
