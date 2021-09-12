// Time Complexity : O(N) where N is length of string
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    string customSortString(string order, string s) {
        if(s.empty() || s.size() == 0)
            return "";
        unordered_map<char, int> map;
        string str;
        for(int i=0; i<s.length(); i++){
            if(map.find(s[i]) != map.end()){
                map[s[i]] +=1;
            }
            else{
                map.insert({s[i], 1});
            }
        }
        for(int i=0; i<order.length(); i++){
            if(map.find(order[i]) != map.end()){
                int times = map[order[i]];
                for(int j=0; j<times; j++){
                    str.push_back(order[i]);
                }
                map.erase(order[i]);
            }
        }
       for(auto i : map){
            if(i.second > 0){
                while(i.second--){
                    str.push_back(i.first);
                }
            }
        }
        return str;
    }
};
