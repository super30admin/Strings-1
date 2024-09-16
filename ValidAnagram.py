class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        """One way is to plain convert the string to list, sort it and then then see if s==t # s=list(s)# s.sort()# t=list(t)# t.sort(),
if t==s return True"""
        if len(t) != len(s):
            return False
        countt = [0] * 26
        counts = [0] * 26
        for i in range(len(s)):
            codes = ord(s[i]) - ord('a')
            codet = ord(t[i]) - ord('a')
            countt[codet] += 1
            counts[codes] += 1
        return countt == counts

        # ###in two passes
        # for c in count:
        #     if c!=0:
        #         return False
        # return True
        # return countt==counts

        # if len(t)>len(s):
        #     return False
        # if len(t)>len(s):
        #     return False

        # s=list(s)
        # s.sort()
        # t=list(t)
        # t.sort()
        # print(s,t)
        # if t==s:
        #     return True
        # return False

