class Solution:
    def customSortString(self, order: str, s: str) -> str:
        smap={}

        for c in s:
            smap[c]=smap.get(c,0)+1
        
        sb=[]
        for c in order:
            if c in smap:
                cnt=smap[c]
                for i in range(cnt):
                    sb.append(c)
               
                del smap[c]
        for c in smap:
            cnt=smap[c]
            for i in range(cnt):
                sb.append(c)

        return "".join(sb)