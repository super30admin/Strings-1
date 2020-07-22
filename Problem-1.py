# Time Complexity :if two arrays sorted average O(n)
# Space Complexity :O(n) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
import collections
class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        
        ans = []
        # get all frequencies of all chars in big string
        frequencies = collections.Counter(T) #gets all frequencies of each letter
        # loop through short string
        for letter in S:
            # if letter in frequencies
            if letter in frequencies:
                #append letter frequencies time
                ans.append(letter * frequencies[letter])
                #delete it
                del frequencies[letter]
        #write the rest
        for letter in frequencies:
            ans.append(letter * frequencies[letter])
        # join and return
        return ''.join(ans)
        