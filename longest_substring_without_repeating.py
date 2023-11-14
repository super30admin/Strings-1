class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        # T: O(N)
        # O(1) since we only have 26 characters
        if len(set(s))<=1: return len(set(s))
        res=0
        i=0
        j=0
        q = collections.deque([])
        while j <len(s):
            if s[j] in q:
                while s[j] in q:
                    q.popleft()
                    i+=1
            else:
                q.append(s[j])
                j+=1
            res = max(res, j-i)
        return res        