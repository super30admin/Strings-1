class Solution:

    

    def lengthOfLongestSubstring(self, s: str) -> int:

        n = len(s)



        maxS = 0

        start = 0

        end = 0

        aplhaPos = {}



        while end < n:

            # capture position of the alphabet in the dictionary

            if s[end] not in aplhaPos:

                aplhaPos[s[end]] = end

            else:

                # check if the repeated alphabet is within the range (start, end)

                if aplhaPos[s[end]] >= start:

                    start = aplhaPos[s[end]] + 1

                    aplhaPos[s[end]] = end

                # update the position of the alphabet if it's out of the range

                else:

                    aplhaPos[s[end]] = end

            maxS = max(maxS, end-start+1)         

            end += 1



        return maxS
