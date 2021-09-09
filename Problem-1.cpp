/*
Time Complexity = O(n+m)
Space Complexity = O(1)
where n is the length of the string order and m is the length of the string s.
*/
class Solution {
public:
    string customSortString(string order, string s) {
        int nums[26]={0};
        int i,times;
        for(i=0;i<s.length();i++){
            nums[s[i]-'a']++;
        }
        string str="";
        for(i=0;i<order.length();i++)
        {
            times = nums[order[i]-'a'];
            nums[order[i]-'a'] = 0;
            while(times){
                str.push_back(order[i]);
                times--;
            }
        }
        for(i=0;i<26;i++)
        {
            times = nums[i];
            while(times)
            {
                str.push_back((char)(i+97));
                times--;
            }
        }
        return str;
    }
};
