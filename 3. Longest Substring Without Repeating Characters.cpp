/*
Time: O(n)
Space: O(1) (fixed alphabet size)

Use Minimizing Sliding Window technique... 
Increment Right border as long as no duplicates found
If duplicate find, increment left border until the left occurance of the duplicate is out of the current window
*/

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        vector<int> cnt(128,0);
        int n = s.length(), left = 0;

        int ans = 0;
        for(int i=0;i<n;i++){
            cnt[s[i]]++;
             
            while(cnt[s[i]] > 1){//duplicate found, adjust left border
                cnt[s[left]]--;
                left++;
            }

            //current window (left.....right) will always be duplicate-free
            int curr_window = (i-left+1);
            ans = max(ans, curr_window);
        }

        return ans;
    }
};
