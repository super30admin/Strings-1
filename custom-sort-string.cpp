//Time - O(m+n) 
//Space - O(1)

class Solution {
public:
    string customSortString(string S, string T) {
        vector<int> mp(26,0);
        
        for(auto c:T){
            mp[c-'a']++;
        }
        string ret = "";
        
        for(auto c:S){
            while(mp[c-'a']){
                ret = ret + c;
                mp[c-'a']--;
            }
        }
        
        for(int i=0;i<26;i++){
            while(mp[i]){
                ret = ret + (char)('a'+i);
                mp[i]--;
            }
        }
        
        return ret;
    }
};