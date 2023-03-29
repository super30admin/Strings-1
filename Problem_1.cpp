791. Custom Sort String


TC - O(n)
SC - O(1) // since there can be only 26 characters in the map.


class Solution {
public:
    string customSortString(string order, string s) {
        
            map<char,int>mp;
            for(auto it:s){
                mp[it]++;
            }

            string ans="";
            for(auto it:order){
              
                if(mp.find(it)!=mp.end()){
                    auto temp = mp.find(it);
                    int count = temp->second;
                    string ss(count,it);
                    ans+=ss;
                    mp.erase(it);
                }
            }         
            for(auto it:mp){
              string ss (it.second,it.first);
               ans+=ss;

            }
        return ans;
    }
};


