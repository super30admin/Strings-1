class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        # to return globalMax
        globalMax = 0
        
        # initialize a dict
        dict = {}
        
        # inLength cal
        inLength = 0
        
        # slow and fastPtr
        slowPtr = 0
        fastPtr = 0
        
        
        # iterate the string s
        while fastPtr != len(s):
            
            # chk if the ele is in the dict
            if s[fastPtr] not in dict:
                
                # add ele to the dict
                dict[s[fastPtr]] = fastPtr
                
            # ele in dictionary
            else:
                
                # update the globalMax
                globalMax = max(globalMax,inLength)
                
                if dict[s[fastPtr]] < slowPtr:
                    # index is behind slowPtr
                    '''we wont move slowPtr behind'''
                    
                    # update index
                    dict[s[fastPtr]] = fastPtr
                                    
                else:
                    # update slowPtr
                    slowPtr = dict[s[fastPtr]] + 1

                    # update ele's index position
                    dict[s[fastPtr]] = fastPtr
                                
            # update the fastPtr
            fastPtr += 1

            # update inLength
            inLength = fastPtr - slowPtr
        
        '''end of while loop'''
        
        globalMax = max(globalMax,inLength)
        
        # print("Max length is:\t",globalMax)
        
        return globalMax