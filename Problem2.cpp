// Time Complexity : O(N) N size of string
// Space Complexity : O(N) Worst case and O(1) for average 
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach:
// 1. Traverse string if new character found increase count for sub array in hashmap and increase right pointer and also increase length.
// 2. Else its already present so incresae left pointer until current right pointer's char frequency becomes 0 and decrease lenth.
// 3. If length is max at any point store as answer and lastly return max length.

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int ans=0,n=s.size(),f=0,l=0,r=0;
        map<char,int> m;
        while(l!=n){
            if(m[s[l]]==0){
                m[s[l]]++;
                r++;l++;
            }
            else{
                m[s[f]]--;
                r--;f++;
            }
            if(r>ans){
                ans=r;
            }
        }
        return ans;
    }
};