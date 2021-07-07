'''

s = 'aabbbacc'      should return 'cc'

s = 'aaccc'         should return 'aa'

s = 'abbbc'         should return 'ac'

'''
# n is length of string

# Runtime - O(n)
# Memory - O(n)

s = "aaccccbbbcca"

d ={}
stack = []
for i in s:
    if i not in d:
        d[i] = 1
        stack.append(i)
    else:
        d[i] += 1
        stack.append(i)
        if d[i] == 3:
            del d[i]
            stack.pop()
            stack.pop()
            stack.pop()
if not stack:
    print('Empty')
print("".join(stack))
