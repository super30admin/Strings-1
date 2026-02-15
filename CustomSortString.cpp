class Solution {
public:
    string customSortString(string order, string s) {
        unordered_map<char, int> um;

        for (int i=0;i<s.length();i++) {
            um[s[i]]++;
        }
        string answer="";
        for (auto ch : order) {
            while (um[ch]) {
                answer.push_back(ch);
                um[ch]--;
            }
            um.erase(ch);
        }

        for (auto& [key, val]: um) {
            while (val) {
                answer.push_back(key);
                val--;
            }
        }

        return answer;
    }
};
