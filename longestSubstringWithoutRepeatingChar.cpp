class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int a_pointer=0,b_pointer=0;
        int maxi=0;
        unordered_set<int> us;
        
        while (b_pointer<s.length()) {
            if (us.find(s[b_pointer])==us.end()) {  //element not found
                us.insert(s[b_pointer]);
                b_pointer++;
                maxi=max(maxi,(int)us.size());
            } else {
                us.erase(s[a_pointer]);
                a_pointer++;
            }
        }
        
        return maxi;
    }
};