//Time - O(m) - m-len of string
//space - O(1)

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int ret = 0,j = 0;
        unordered_map<char,int> mp;
        
        for(int i=0;i<s.length();i++){
           if(mp.find(s[i])!=mp.end()){
               j = max(mp[s[i]],j);
           } 
            mp[s[i]] = i+1;
            ret = max(ret, i-j + 1);
            
        }
        
        return ret;
    }
};