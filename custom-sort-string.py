# time: O(n+m)
# space: O(1) since 26 chars in alphabet
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        mp = {}
        # build frequency map of characters in s
        for c in s:
            if c in mp:
                mp[c]+=1
            else:
                mp[c]=1
        
        sb = []
        # for characters in order, if the char is in freq map, get the count, append it as many times as required in s, delete the char from map
        for c in order:
            if c in mp:
                cnt = mp[c]
                for i in range(cnt):
                    sb.append(c)
                del mp[c]
        # iterate over remaining characters to tack on at the end
        for c in mp:
            cnt = mp[c]
            for i in range(cnt):
                sb.append(c)
        
        return ''.join(sb)