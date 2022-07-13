//Time Complexity- O(n)
//Space Complexity- O(min(m,n))

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int i=0;
        int j=0;
        int ans=0;
        
        unordered_set<char> st;
        while(j<s.size()){
            if(st.find(s[j])==st.end()){
                st.insert(s[j]);
                int size=st.size();
                ans=max(size,ans);
                j++;
            }
            else{
                st.erase(s[i]);
                i++;
            }
        }
        return ans;
    }
};