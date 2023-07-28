//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
public:
    string customSortString(string order, string s) {
        unordered_map<char,int> mp; 
        string result = "";
        for(int i = 0; i < s.size(); i++) {
            mp[s[i]]++; 
        }

        for(int i = 0; i < order.size(); i++) {
            while(mp[order[i]] > 0) {
                result += order[i];
                mp[order[i]]--;
            }
        }

        for(auto it : mp) {
            while(it.second > 0) {
                result += it.first; 
                it.second--;
            }
        }

        return result;         
    }
};