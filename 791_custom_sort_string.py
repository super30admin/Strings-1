from collections import Counter


class Solution:
    def customSortString(self, S: str, T: str) -> str:
        """
            https://leetcode.com/problems/custom-sort-string/
            Time Complexity - O(n)
            Space Complexity - O(n)
            'n' is the length of the string.
            Explanation -
                - Add char -> count of String 'T'
                - Iterate over S and append corresponding char from C with count to result
                - Iterate over remaining char from 'T'
                - Join the result list
        """
        count_dic = Counter(T)
        res = []
        for c in S:
            if c in count_dic:
                print(c * count_dic[c])
                res.append(c * count_dic[c])
                count_dic.pop(c)
        for k, v in count_dic.items():
            res.append(k * v)
        return ''.join(res)


if __name__ == '__main__':
    Solution().customSortString('cba', 'abbcddaaetÎd')
