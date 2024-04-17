# T.C. O(n)
# S.C. O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashset = set()
        slow, max_ele = 0, 0
        for i in range(len(s)):
            c = s[i]
            if c in hashset:
                while(s[slow] != c):
                    hashset.remove(s[slow])
                    slow +=1
                slow += 1
            else:
                hashset.add(c)

            max_ele = max(max_ele, i - slow + 1)

        return max_ele
