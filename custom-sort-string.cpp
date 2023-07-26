// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>
#include <algorithm> // for sort

std::string customSortString_usingCustomSort(std::string order, std::string str) {
    int sortedOrder[26] = {0};

    for (int i = 0; i < order.length(); ++i) {
        sortedOrder[order[i] - 'a'] = i;
    }

    std::vector<char> arr(str.length());
    for (int i = 0; i < str.length(); ++i) {
        arr[i] = str[i];
    }

    std::sort(arr.begin(), arr.end(), [&](char c1, char c2) {
        return sortedOrder[c1 - 'a'] < sortedOrder[c2 - 'a'];
    });

    std::string result;
    for (char c : arr) {
        result.push_back(c);
    }

    return result;
}