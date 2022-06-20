class Solution {
public:
    string customSortString(string order, string s) {
        string result;
        unordered_map<char,int> m;
        for(int i=0;i<s.length();i++){
            m[s[i]]++;
        }
        for(int i=0;i<order.length();i++){
            int count = m[order[i]];
            while(count>0){
                result.push_back(order[i]);
                count--;
            }
            m.erase(order[i]);
        }
        for(auto c:m){
            int count = c.second;
            while(count>0){
                result.push_back(c.first);
                count--;
            }
        }
        return result;
    }
};

TC = O(S)  
SC = O(k) where k = length of the consecutive unique characters

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char,int> m;
        int start=0, end=0, len=0;
        string result="";
        
        while(end<s.length()){
            char ch = s[end];
            
            if(m.find(ch)!=m.end() && m[ch]>=start){
                start = m[ch]+1;
            }
            else{
                m[ch]=end;
                end++;
            }
            
            if(len<end-start){
                len = end-start;
                result = s.substr(start,end-start);
            }
        }
        cout<<result;
        return len;
    }
};
