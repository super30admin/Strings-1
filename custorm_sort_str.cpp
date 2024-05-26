//Time = O(n+m)
//Space = O(1)
//Leetcode: yes
//Issue seen: none

class Solution {
public:
    string customSortString(string order, string s) {
        unordered_map<char, int> mp;
        string ans;

        for(int i=0; i<s.size(); i++){
            mp[s[i]]++;
        }
        for(int i=0; i<order.size();i++){
            if(mp.find(order[i]) != mp.end()){
                while(mp[order[i]] != 0){
                  ans.push_back(order[i]);
                  mp[order[i]]--;
                }
                mp.erase(order[i]);
            }
        }

        for(auto it = mp.begin(); it != mp.end(); it++){
            while(it->second != 0){
                ans.push_back(it->first);
                it->second--;
            }
        }
        return ans;
    }
};
