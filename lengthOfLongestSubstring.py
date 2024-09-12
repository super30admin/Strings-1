class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        p1 = 0 
        state = {}
        max_length = 0
        i = 0
        while i < len(s) :
            if state.get(s[i]) :
                # increment p1
                state[s[p1]] = False
                p1 += 1
            else :
                state[s[i]] = True
                i+=1
                if (i-p1) > max_length :
                    max_length = (i-p1)
        
        return max_length
                

        
