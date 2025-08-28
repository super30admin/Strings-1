#include<unordered_map>
#include<unordered_set>
#include<string>
#include<iostream>
using namespace std;
class Solution {
    public:
        string customSortString(string order, string s) {
            unordered_map<char,int>freq;
            unordered_set<char>ord;
            for(auto c:order) ord.insert(c);
            for(auto c:s){
                if(ord.find(c)!=ord.end())freq[c]++;
            }
            string ans;
            for(auto c:order){
                if(freq.find(c)!=freq.end()){
                    for(int i=1;i<=freq[c];i++) ans.push_back(c);
                }
            }
            for(auto c:s){
                if(freq.find(c)==freq.end()){
                    ans.push_back(c);
                }
            }
            return ans;
        }
};
int main() {
    Solution solution;
    string order = "cba";
    string s = "abcd";
    string result = solution.customSortString(order, s);
    cout << "Custom sorted string: " << result << endl; // Output: cbad
    return 0;
}
// // Time Complexity: O(m+n) where m is the length of order and n is the length of s
// // Space Complexity: O(1) since the character set is fixed (26 lowercase letters)
// // Did this code successfully run on Leetcode: Yes
// // Any problem you faced while coding this: No
// // Your code here along with comments explaining your approach in three sentences only
// // Counted the frequency of each character in string s that appears in order using a hash map. Constructed the result string by appending characters from order based on their frequencies, followed by any remaining characters from s that were not in order. This ensured that the characters in s were sorted according to the custom order while maintaining the relative order of characters not in order.