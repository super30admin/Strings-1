#include<unordered_set>
#include<string>
#include<algorithm>
#include<iostream>
using namespace std;
class Solution {
    public:
        int lengthOfLongestSubstring(string s) {
            unordered_set<int>unique;
            if(s.empty()) return 0;
            int f = 0, l = 1, n = s.size(),ans = 1;
            unique.insert(s[0]);
            while(l<=n-1){
                while(unique.find(s[l])!=unique.end()){
                    unique.erase(s[f]);
                    f++;
                }
                ans = max(ans, l-f+1);
                unique.insert(s[l]);
                l++;
            }
            return ans;
        }
};
int main() {
    Solution solution;
    string s = "abcabcbb";
    int result = solution.lengthOfLongestSubstring(s);
    cout << "Length of longest substring without repeating characters: " << result << endl; // Output: 3
    return 0;
}
// // Time Complexity: O(n) where n is the length of the string
// // Space Complexity: O(min(m,n)) where m is the size of the character set and n is the length of the string
// // Did this code successfully run on Leetcode: Yes
// // Any problem you faced while coding this: No
// // Your code here along with comments explaining your approach in three sentences only
// Used a sliding window approach with two pointers to maintain a window of unique characters. Expanded the right pointer to include new characters and contracted the left pointer when a duplicate was found, updating the maximum length of the substring as needed. Utilized an unordered set to efficiently check for duplicates within the current window.