class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        """
            Time Complexity - O(n)
            Space Complexity - O(n)
            'n' is the length of the string 's'
        """
        slow = fast = max_len = 0
        pos_dic = {}
        while fast < len(s):
            if s[fast] in pos_dic:
                slow = max(slow, pos_dic[s[fast]])
            pos_dic[s[fast]] = fast + 1
            max_len = max(max_len, fast - slow + 1)
            fast += 1
        return max_len

    def lengthOfLongestSubstringBruteForce(self, s: str) -> int:
        max_string = 0
        for i in range(len(s)):
            for j in range(i, len(s)):
                cur_string = s[i:j]
                cur_set = set()
                cur_max = 0
                for c in cur_string:
                    if c not in cur_set:
                        cur_set.add(c)
                        cur_max += 1
                    else:
                        break
                max_string = max(cur_max, max_string)
        return max_string


if __name__ == '__main__':
    print(Solution().lengthOfLongestSubstring('abcabcbb'))
    print(Solution().lengthOfLongestSubstring('abbabc'))
    print(Solution().lengthOfLongestSubstring('bbbbb'))
    print(Solution().lengthOfLongestSubstring('pwwkew'))
    print(Solution().lengthOfLongestSubstring(' '))
