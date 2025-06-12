// Time Complexity : O(N) N size of string "s"
// Space Complexity : O(N) Worst case and O(1) for average 
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach:
// 1. Store frequency in hash_map for string 's'.
// 2. Traverse order string and concatenate character if present in order.
// 3. Concatenate char n(frequency of that char) times. Concatenate all remaining chars in hashmap to answer string.

class Solution {
public:
    string customSortString(string order, string s) {
        map<char,int> m;
        for(int i=0;i<(s.size());i++){
            m[s[i]]++;
        }
        string ans="";
        for(int i=0;i<(order.size());i++){
            while(m[order[i]]!=0){
                ans=ans+order[i];m[order[i]]--;
            }
        }

        for(auto x:m){
            while(x.second != 0){ans=ans+(x.first);x.second--;}
        }
        return ans;
    }
};