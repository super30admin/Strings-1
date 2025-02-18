# tc O(n), sc O(min(n, charset)).
maxlen = 0
hmap = {}
left = 0

for right in range(len(s)):
    if s[right] in hmap:
        left = max(hmap[s[right]] + 1, left)
    
    hmap[s[right]] = right
    maxlen = max(maxlen, right-left+1)

return maxlen