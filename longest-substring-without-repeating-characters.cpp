// Time Complexity : O(n)
// Space Complexity : O(min(m, n))
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <string>
#include <unordered_set>

int lengthOfLongestSubstring(std::string s) {
    int start = 0, end = 0;
    std::unordered_set<char> set;
    int maxLen = 0;

    while (start < s.length() && end < s.length()) {
        char ch = s[end];

        // Remove characters from set until s[end] can be inserted.
        while (set.count(ch)) {
            set.erase(s[start++]);
        }

        // Insert s[end]
        set.insert(ch);

        maxLen = std::max(maxLen, static_cast<int>(set.size()));

        end++;
    }

    return maxLen;
}