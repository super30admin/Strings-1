class Solution(object):
    # tc : O(n) each char visited twice once by i and once by the end pointer
    # sc : O(1) 
    def lengthOfLongestSubstring(self, s):
        # use sliding window and keep track of the letters in a arr and if we come across the duplicate
        # to keep track of the letters, i will be using an arr where the arr index wil act as the placeholder for the letter and the arr[i] will be 1 if that letter is present if not it is gng to remain 0
        # and when foudn duplicate when we move our end pointer to the right of the duplicate, we will update the chars back to -1 indicating the previous window characte
        # and also keep track of the sliding window len and return the max len of window without duplicates 
        
        end = 0
        n = len(s)
        max_window = 0
        char_arr = [-1]*256 # we can get letters, digits, symbolas, spaces

        for i in range(n):
            c = s[i]
            if char_arr[ord(c)] != -1:
                while s[end] != c:
                    char_arr[ord(s[end])] = -1
                    end += 1
                end += 1
            char_arr[ord(c)] = 1
            max_window = max(max_window, i - end + 1)

        return max_window
