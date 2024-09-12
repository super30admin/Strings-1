# Time Complexity : O(n^2) when is length of string s
# Space Complexity :O(n) when is length of string s
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # ------------------method1----------------------------------------------
        # Dictionary for storing the index of the letter
        # char_dct= {}
        # start = max_len = 0
        # Looping over entire string
        # for i, char in enumerate(s):
        #     if char in char_dct:
        # If the letter in string is repeated then Find the maxlength between the found one and the present length
        #         max_len = max(max_len, i - start)
        # Initialize the start pointer to the past occurance+1
        #         start = max(start, char_dct[char] + 1)
        #     char_dct[char] = i
        # return max(max_len, len(s)-start)

        # ---------------method2-------------------------------------------------
        max_len = 0
        # Track is for storing letters found
        track = ''

        for char in s:
            if char in track:
                # If character is already found
                while True:
                    # while 1st element of track is the letter found, remove thhe 1st element
                    if track[0] == char:
                        track = track[1:]
                        break
                    else:
                        track = track[1:]
            # Add the character and find the max length
            track += char
            max_len = max(max_len, len(track))
        return max_len




