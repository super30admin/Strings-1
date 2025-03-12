class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left=max_sum=0
        '''
        char =set()
        for right in range(len(s)):
            while s[right] in char:
                char.remove(s[left])
                left +=1
            char.add(s[right])
            max_sum = max(max_sum,right-left+1)
        return max_sum
        '''
        charmap={}
        for right in range(len(s)):
            if s[right] in charmap:
                left = max(left,charmap[s[right]]+1)
            charmap[s[right]]=right
            max_sum = max(max_sum,right-left+1)
        return max_sum

        