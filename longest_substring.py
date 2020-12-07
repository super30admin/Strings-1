class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s == '':
            return 0
        i = 0
        j = 0
        dic = {}
        l = 0
        while i < len(s):
            if s[i] not in dic:
                dic[s[i]] = i + 1

            else:
                if dic[s[i]] >= j and dic[s[i]] <= i:
                    j = dic[s[i]]
                    # print('j',j)
                dic[s[i]] = i + 1

            l = max(l, i - j + 1)
            # print(l)
            i += 1
        return l

# time-O(n)-in all sliding windows its always o(n)
# space-o(1)-storing 26 alphabets