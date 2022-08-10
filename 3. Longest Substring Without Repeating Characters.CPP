class Solution {
public:
    int lengthOfLongestSubstring(string s) {
     int n=s.size();
     int slow=0,max_length=0;
     unordered_map<char,int> h;
     for(int i=0;i<n;i++){
         if(h.find(s[i])==h.end()){
             h[s[i]]=i;
             
         }
         else{
             slow=max(h[s[i]]+1,slow);
             h[s[i]]=i;
         }
         max_length=max(max_length,i-slow+1);
     }
        return max_length;
    }
};