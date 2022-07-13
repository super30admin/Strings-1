//Time Complexity- O(s.length+t.length)
//Space Complexity- O(t.length)

class Solution {
public:
    string customSortString(string order, string s) {
        
        unordered_map<char,int> mp;
        for(char ch:s){
            mp[ch]++;
        }
        
        string ans="";
        for(char ch:order){
            if(mp.find(ch)!=mp.end()){
                while(mp[ch]--){
                    ans+=ch;
                }
                mp.erase(ch);
            }
        }
        
        for(auto ele:mp){
            while(ele.second--){
                ans+=ele.first;
            }
        }
        return ans;
    }
};