//Using hashset

// Time Complexity : O(2N) = O(N)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> set;
        int i=0, j=0, ans = 0;
        while(i<s.length() && j<s.length()){
            char a = s[j];
            if(set.find(s[j])==set.end()){
                set.insert(s[j++]);
                ans = max(ans, j-i);
            }
            else{
                set.erase(s[i++]);
            }
        }
        return ans;
    }
};

//Using hashmap

// Time Complexity : O(N)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int ans = 0;
        unordered_map<char, int>map;
        for(int j=0, i=0;j<s.length();j++){
            if(map.find(s[j])!=map.end()){
                i = max(map[s[j]],i);
            }
            ans = max(ans, j-i +1);
            map[s[j]] = j+1;
        }
        return ans;
    }
};
