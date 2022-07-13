# TC: O(m+n)
# SC: O(n), n= length of s
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        freq={}
        sett=set()
        for c in order:
            sett.add(c)
        for c in s:
            if c not in freq:
                freq[c]=0
            freq[c]+=1
        result=[]
        for c in order:
            if c in freq:
                while freq[c]>0:
                    result.append(c)
                    freq[c]-=1
                del freq[c]
        for c in freq:
            cnt=freq[c]
            while cnt>0:
                result.append(c)
                cnt-=1
        # for c in s:
        #     if c in freq:
        #         while freq[c]>0:
        #             result.append(c)
        #             freq[c]-=1
        #         del freq[c]
        return "".join(result)
