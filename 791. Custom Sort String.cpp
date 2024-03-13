/*
Time: O(nlogn)
Space: O(1)

Compare the position of two characters in the order string as the comparator function for these 2 characters in s when sorting
*/

class Solution {
public:
    string customSortString(string order, string s) {
        vector<int> pos(26,0);
        for(int i=0;i<order.length();i++)  pos[order[i]-'a'] = i;

        sort(s.begin(), s.end(), [&](char a, char b){
            return pos[(a-'a')] < pos[(b-'a')];
        });

        return s;
    }
};
