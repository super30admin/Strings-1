def customSortString(order, s):
    count = {}
    for char in s:
        if char in count:
            count[char]+=1
        else:
            count[char]=1
    print(count)
    res= []
    for char in order:
        if char in count:
            res.append(char * count[char])
            del count[char]

    for char, cnt in count.items():
        res.append(char * cnt)
    return ''.join(res)

order = "cbade"
str = "abcdefgfj"
print(customSortString(order, str))  # Output: "cbad"

#time = O(n+m)
#space = O(1)