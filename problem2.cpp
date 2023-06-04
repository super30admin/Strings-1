
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// Approach 2
// Time Complexity :O(n)
// Space Complexity : O(1)
// Your code here along with comments explaining your approach
// we use a map to store the index of characters as we traverse through the string.
// we use this map to find if there is a repeating character and then we also use that index +1 as the starting index of the substring.


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.size() == 0) return 0;
        unordered_map<char,int>map;
        int start = 0,j = 0;
        int ans = 0;
        for(int i = 0;i<s.size();i++)
        {
            if(map.count(s[i])!=0)
            {
                start = max(start,map[s[i]] + 1);
            }
            ans = max(ans,i-start+1);
            map[s[i]] = i;
        }
        return ans;
    }
};



// Approach 2
// Time Complexity : O(nlogn)
// Space Complexity : O(1)

// we use binary search on the range of answer. we then check for each substring of length mid, if it exists, we update our answer.


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.size()==0) return 0;
        int lo = 1;
        int hi = s.size();
        int ans = 1;
        while(lo<=hi)
        {
            int mid = lo + (hi-lo)/2;
            if(check(s,mid))
            {
                ans = mid;
                lo = mid+1;
            }
            else
            {
                hi = mid-1;
            }
        }
        return ans;
    }
    bool check(string &s,int k)
    {
        unordered_map<char,int>map;
        int n = s.size();
        int matched = 0;
        for(int i = 0;i<n;i++)
        {
            map[s[i]]++;
            if(map[s[i]] == 1){
                matched++;
            }
            if(i>=k)
            {
                map[s[i-k]]--;
                if(map[s[i-k]]==0){
                    matched--;
                }
            }
            if(matched==k) return true;
        }
        return false;
    }
};