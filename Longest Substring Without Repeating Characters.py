# time complexity is o(n), where n is the size of the input
# space complexity is o(26), which is a constant, o(1)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        d = dict() # space is o(26), which is a constant, o(1)
        slow = 0
        maxi = 0
        for i in range(len(s)): #time is o(1)
            if(s[i] in d):
                slow = max(d[s[i]], slow)
            d[s[i]] = i + 1
            maxi = max(maxi, i-slow + 1)
        return maxi
        




        
#         time complexity is o(2n), where n is the size of the input
#         space complexity is o(1)
#         if(len(s) == 0):
#             return 0
#         slow = 0
#         st = set() #space is o(26), which is constant that is o(1)
#         st.add(s[slow])
#         fast = 1
#         maxi = 0
#         for i in s[1:]:
#             if(i in st):
#                 maxi = max(maxi, fast - slow)
#                 while(i in st):
#                     st.remove(s[slow])
#                     slow += 1
#                 # st.add(s[slow])
#             fast += 1
#             st.add(i)
#         return max(maxi, fast - slow)
            
                
#         if(s==""):
#             return 0
#         # if(s==" "):
#         #     return 1
#         d = dict()
#         maxi = float('-inf')
#         for i in range(len(s)):
#             d = dict()
#             k = i
#             while(k < len(s)):
#                 if(s[k] not in d):
#                     d[s[k]] = True
#                 else:
#                     break
#                 k += 1
#             maxi = max(maxi,len(d))
#             if(maxi == len(s)):
#                 return maxi
        
#         return maxi

                    
                


        
#         leng = 0
#         old_len = 0 
#         t=''
#         for i in s:
#             if(i not in t):
#                 t+=i
#                 leng = len(t)
#                 if(old_len < leng):
#                     old_len = leng
                
#             else:
#                 while(i in t):
#                     t = t.lstrip(t[0])
#                 t = t + i
#                 if(old_len < leng):
#                     old_len = len(t)
#         return old_len

         