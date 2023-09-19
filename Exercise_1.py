# ## Problem1
# Custom Sort String (https://leetcode.com/problems/custom-sort-string/)
# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
class Solution:
    def customSortString(self, order, s):
        # creating a hashmap of chars in s
        hmap_s = {}
        for i in range(len(s)):
            hmap_s[s[i]] = hmap_s.get(s[i], 0) + 1
        result = ""
        for char in order:
            if char in hmap_s:
                result += char * hmap_s[char]
                del hmap_s[char]
        for char, count in hmap_s.items():
            result += char * count
        return result


order = "cba"
s = "abcd"
sol = Solution()
print(sol.customSortString(order, s))
