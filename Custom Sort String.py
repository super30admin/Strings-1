""""// Time Complexity : O(m+n) ~O(n)  asymptotically
// Space Complexity :O(1) as atmost 26 letters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


class Solution:
    def customSortString(self, order: str, s: str) -> str:
        h = {}
        for i in s:
            if i not in h:
                h[i] = 0
            h[i] += 1
        result = []

        for i in order:
            if i in h:
                while h[i] != 0:
                    result.append(i)
                    h[i] -= 1
                del h[i]

        if len(h) != 0:
            for i in h:
                if h != 0:
                    while h[i] != 0:
                        result.append(i)
                        h[i] -= 1
        return ''.join(result)

# class Solution:
#     def customSortString(self, order: str, s: str) -> str:
#         h={}
#         for i in s:
#             if i not in h:
#                 h[i]=0
#             h[i]+=1
#         result=''

#         for i in order:
#             if i in h:
#                 while h[i]!=0:
#                     result+=i
#                     h[i]-=1
#                 del h[i]

#         if len(h)!=0:
#             for i in h:
#                 if h!=0:
#                     while h[i]!=0:
#                         result+=i
#                         h[i]-=1
#         return result


