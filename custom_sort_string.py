class Solution:
    def customSortString(self, order, s):
        map = {}

        for c in s:
            if c in map:
                map[c] += 1
            else:
                map[c] = 1

        sb = []

        for c in order:
            if c in map:
                cnt = map[c]
                for k in range(cnt):
                    sb.append(c)
                del map[c]

        for c in map:
            cnt = map[c]
            for k in range(cnt):
                sb.append(c)

        return ''.join(sb)

# Time: O(n + m) where n is length of s and m is length of order.
# Space: O(1)
