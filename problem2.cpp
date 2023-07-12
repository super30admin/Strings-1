// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
Find the index of the repetetive character, store the length of the substring and compare with the max.
Update the new start idx with the idx that occur just after where the charcter was found earlier.
*/

#include<string>
#include<vector>

using namespace std;

// using hash set
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        vector<bool> hashset(128,false);
        int max_cnt{};
        int cnt{};
        int s_idx{};
        //cout<<"s_idx "<<"i "<<"max_cnt "<<endl;
        for(int i{};i<s.size();++i){
            if(hashset.at(s.at(i))){

                max_cnt = max(max_cnt,cnt);
                //cout<<s_idx<<" "<<i<<" "<<max_cnt<<endl;
                while(s.at(s_idx)!=s.at(i)){
                    hashset.at(s.at(s_idx)) = false;
                    cnt--;
                    s_idx++;
                }
                s_idx++;
            }
            else{
                hashset.at(s.at(i)) = true;
                cnt++;
            }
        }
        return max(max_cnt,cnt);
    }
};


// using hashmap

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        vector<int> hashmap(128,-1);
        int max_cnt{},s_idx{},cnt{};
            //cout<<"i_val "<<"s_idx "<<"cnt"<<endl;
        for(int i{};i<s.size();i++){
            if(hashmap.at(s.at(i))>=0){
                int n_idx = hashmap.at(s.at(i))+1;
                if(n_idx>s_idx){
                    //out<<i<<" "<<s_idx<<" "<<i-s_idx<<endl;
                    max_cnt = max(max_cnt,i-s_idx);
                    s_idx = n_idx;
                }
            }
            hashmap.at(s.at(i)) = i;
        }
        int some_cnt = s.size() - s_idx;
        //cout<<"some_cnt"<<some_cnt<<endl;
        max_cnt = max(max_cnt,some_cnt);
        return max_cnt;
    }
};


