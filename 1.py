# Runs on Leetcode
# Time: O(len(T) + len(S))
# Space: O(len(T) + len(S))

# Approach: Count all chars of T and then go through S and add char * freq to ans if it is present in T
# After that check all chars of T and if they aren't present in S, add them to the end of the answer in
# whatever order they appear

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        t_freq = {}
        s_char = set(list(S))

        for ele in T:
            t_freq[ele] = t_freq.get(ele, 0) + 1

        ans = []
        for ele in S:
            if ele in t_freq:
                ans.append(ele * t_freq[ele])

        for ele in T:
            if ele not in s_char:
                ans.append(ele)

        return ''.join(ans)