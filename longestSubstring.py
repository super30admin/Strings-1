def longestSubstring(s):
        #sliding window soln- 2 ptr=i&j; for loop will be for j which will traverse thru the entire str and i will move according to j
        visited={} #visited-dictonary; v={str-element: length}
        i=0
        res=0 # length of the substring

        for j in range(len(s)):
            if s[j] in visited:            # if the element of 's' is in dict
                i=max(visited[s[j]],i)     #increment the i ptr
            res=max(j-i+1,res)              # update the length of substring
            visited[s[j]]=j+1               #the value of each key in dict is j+1
            print(visited)
        return res

s = "abcabcbbc"
print(longestSubstring(s))

#time = O(n)
#space = O(1)