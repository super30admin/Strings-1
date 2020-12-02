"""

Time Complexity 0(N)
Space complexity O(1)

"""


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s)==0:
            return 0
        
        dict={}
        max_len=start=0
        for i in range(len(s)):
            #print(max_len)
            #ch=s[i]
            if s[i] in dict and start<=dict[s[i]]:
                """
                 To print that substring with longest len
                substr=s[start:i]
                if len(substr)>=max_len:
                    print(substr)
                
                  """
                start=dict[s[i]]
            dict[s[i]]=i+1
            max_len=max(max_len,i-start+1)
           
        return max_len
                
                