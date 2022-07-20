// Time COmplexity -> O(m+n), where m - length of 'order' and n = length of 's'
// Space Complexity -> O(n), where n = length of 's'
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    string customSortString(string order, string s) {
        unordered_map<char, int> map;
        string answer =  "";
        for(int i = 0; i < s.length(); i++){
            char c = s[i];
            map[c]++;
        }

        for(int i = 0; i < order.length(); i++){
            char c = order[i];
            if(map.count(c)){
                int count = map[c];
                while(count > 0){
                    answer += c;
                    count--;
                }
            }
            map.erase(c);
        }
        
        for(auto it = map.begin(); it != map.end(); ++it){
            int count = (*it).second;
            while(count > 0){
                answer += (*it).first;
                count--;
            }
        }
        return answer;
    }
};